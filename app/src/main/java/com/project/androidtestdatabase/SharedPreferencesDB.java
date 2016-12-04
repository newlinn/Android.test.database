package com.project.androidtestdatabase;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by LingChen on 2016/12/4.
 */

public final class SharedPreferencesDB {

    private SharedPreferencesDB() {
    }

    public static String[] getData(Context context, String dbName, String[] keys) {
        SharedPreferences sp = context.getSharedPreferences(dbName, context.MODE_PRIVATE);
        String[] results = new String[keys.length];
        for (int idx = 0, max = keys.length; idx < max; idx++) {
            results[idx] = sp.getString(keys[idx], "");
        }
        return results;
    }

    public static void saveData(Context context, String dbName, String[] keys, String[] values) {
        SharedPreferences sp = context.getSharedPreferences(dbName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        for (int idx = 0, max = keys.length; idx < max; idx++) {
            editor.putString(keys[idx], values[idx]);
        }
        editor.commit();
    }
}
