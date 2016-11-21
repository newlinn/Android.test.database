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
                            SQLiteDatabase.CursorFactory cursorFactory, int version) {
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
        switch (i) {
            case 1: {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS category");
                final String CREATE_CATEGORY = "CREATE TABLE category ("
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + " category_name TEXT,"
                        + " category_code INTEGER"
                        + ")";
                sqLiteDatabase.execSQL(CREATE_CATEGORY);
                Toast.makeText(this.mContext, "CREATE TABLE category", Toast.LENGTH_SHORT).show();
            }
            ;
            case 2: {
                final String add_book_category = "ALERT TABLE book"
                        + " COLUMN category_id INTEGER";
                sqLiteDatabase.execSQL(add_book_category);
                Toast.makeText(this.mContext, "ALTER TABLE book", Toast.LENGTH_SHORT).show();
            }
            default: {

            }
        }
    }

}
