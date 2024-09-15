package com.alphacrud.phototranslator.Utilis;

import android.graphics.Bitmap;
import android.view.View;

public class Screenshot {

    public static Bitmap takeScreenshot(View v) {

        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        return bitmap;
    }
}
