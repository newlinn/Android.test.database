package com.project.androidtestdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 2016/11/20 database version
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        Button btn_create_datebase = (Button) findViewById(R.id.btn_create_datebase);
        btn_create_datebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();

            }
        });

        Button btn_add_data = (Button) findViewById(R.id.btn_add_data);
        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("book", null, values);

                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("book", null, values);
            }
        });

        Button btn_update_data = (Button) findViewById(R.id.btn_update_data);
        btn_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 15.99);
                db.update("book", values, "name = ?", new String[]{"The Lost Symbol"});
            }
        });

        Button btn_delete_data = (Button) findViewById(R.id.btn_delete_data);
        btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("book", "pages < ?", new String[]{"400"});
            }
        });

        Button btn_query_data = (Button) findViewById(R.id.btn_query_data);
        btn_query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        String content = "name:" + name + " author:" + author
                                + " pages:" + pages + "" + " price:" + price;
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
                    } while (cursor.moveToNext());
                }
            }
        });

        Button btn_transaction = (Button) findViewById(R.id.btn_transaction);
        btn_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    db.setTransactionSuccessful();
                } catch (Exception ex) {

                } finally {
                    db.endTransaction();
                }
            }
        });
    }
}
