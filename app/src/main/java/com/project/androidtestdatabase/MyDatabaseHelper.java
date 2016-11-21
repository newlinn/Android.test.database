package com.project.androidtestdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by newli on 2016/11/20.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {



    Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context, name, cursorFactory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         final String CREATE_BOOK = "CREATE TABLE book ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " author TEXT,"
                + " price REAL,"
                + " pages INTEGER,"
                + " name TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_BOOK);
        Toast.makeText(this.mContext, "CREATE TABLE book", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i==1 && i1 == 2) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS category");
            final String CREATE_CATEGORY = "CREATE TABLE category ("
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " category_name TEXT,"
                    + " category_code INTEGER"
                    + ")";
            sqLiteDatabase.execSQL(CREATE_CATEGORY);
            Toast.makeText(this.mContext, "CREATE TABLE category", Toast.LENGTH_SHORT).show();
        }
    }

}
