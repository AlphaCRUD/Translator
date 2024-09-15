package com.alphacrud.phototranslator.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.alphacrud.phototranslator.Model.PreviousDataModel;
import com.alphacrud.phototranslator.MyApplication;

import java.util.ArrayList;

public class DatabaseAssist extends SQLiteOpenHelper {

    public static synchronized DatabaseAssist getInstance(Context context) {

        if (MyApplication.DA == null) {
            MyApplication.DA = new DatabaseAssist(context.getApplicationContext());
        }
        return MyApplication.DA;
    }

    public DatabaseAssist(Context context) {
        super(context, "Hisabkitab.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String queryUsers = "CREATE TABLE data (id INTEGER PRIMARY KEY AUTOINCREMENT,text VARCHAR, imgUrl VARCHAR,dateTime default current_timestamp)";
        database.execSQL(queryUsers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void deleteTables() throws SQLiteException {

        SQLiteDatabase db = this.getWritableDatabase();

        String user = "DELETE FROM data";
        db.execSQL(user);

    }
    public void doSecond() {
        SQLiteDatabase database = this.getWritableDatabase();
        String q11 = "SELECT * FROM data";
        Cursor res = database.rawQuery(q11, null);
        if (res.getCount() > 0) {
            while (res.moveToNext()) {
                String text = res.getString(res.getColumnIndex("text"));
                String imgUrl = res.getString(res.getColumnIndex("imgUrl"));
                String dateTime = res.getString(res.getColumnIndex("dateTime"));

            }
            res.close();
        }
    }

    public long insertClient(String text, String imgUrl) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("text", text);
        values.put("imgUrl", imgUrl);
//        values.put("dateTime", dateTime);

        return database.insert("data", null, values);
    }
    public long delete(int id) {

        SQLiteDatabase database = this.getWritableDatabase();

//        values.put("dateTime", dateTime);

        return database.delete("data", "id=" + id, null);
    }
    public ArrayList<PreviousDataModel> getSingleCustomerData() throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<PreviousDataModel> userList = new ArrayList<>();
        double total_amount = 0, total_subAmount = 0, total_of_each = 0;

//        String query = "SELECT Transactions.*, Clients.business_id, Clients.name, Clients.phone, Clients.paydate FROM Transactions INNER JOIN Clients ON Clients.id=Transactions.customer_id WHERE customer_id = '" + customer_id + "' AND Transactions.isDeleted IS NULL ORDER BY date";

        String query = "SELECT * FROM data";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                PreviousDataModel model = new PreviousDataModel();

                String text = cursor.getString(cursor.getColumnIndex("text"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String imgUrl = cursor.getString(cursor.getColumnIndex("imgUrl"));
                String dateTime = cursor.getString(cursor.getColumnIndex("dateTime"));

                model.setTxt(text);
                model.setDate(dateTime);
                model.setImgUrl(imgUrl);
                model.setId(id);
                userList.add(model);
            }

        }
        cursor.close();
        return userList;
    }

}
