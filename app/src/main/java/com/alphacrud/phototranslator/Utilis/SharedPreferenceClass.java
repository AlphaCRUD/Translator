package com.alphacrud.phototranslator.Utilis;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharedPreferenceClass {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPrefEditor;

    private SharedPreferenceClass(Context mContext) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        sharedPrefEditor = sharedPreferences.edit();
    }

    public static SharedPreferenceClass getInstance(Context mContext) {
        return new SharedPreferenceClass(mContext);
    }

    public static void clearAll() {
        sharedPrefEditor.clear();
        sharedPrefEditor.commit();
    }

    public static void setValue(String key, String value) {
        sharedPrefEditor.putString(key, value);
        sharedPrefEditor.commit();

    }

    public static String getValue(String key, String default_value) {
        return sharedPreferences.getString(key, default_value);
    }

    public static void setBooleanValue(String key, boolean value) {
        sharedPrefEditor.putBoolean(key, value);
        sharedPrefEditor.commit();

    }

    public static boolean getBooleanValue(String key, boolean default_value) {
        return sharedPreferences.getBoolean(key, default_value);
    }
    public static void setLongValue(String key, long value) {
        sharedPrefEditor.putLong(key, value);
        sharedPrefEditor.commit();

    }

    public static long getLongValue(String key, long default_value) {
        return sharedPreferences.getLong(key, default_value);
    }
}