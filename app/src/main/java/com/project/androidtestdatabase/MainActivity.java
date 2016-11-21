package com.project.androidtestdatabase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 2016/11/20 database version
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        Button btn_create_datebase = (Button)findViewById(R.id.btn_create_datebase);
        btn_create_datebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();

            }
        });

        Button btn_add_data = (Button)findViewById(R.id.btn_add_data);
        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The DDa Vinci Code");
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

        Button btn_update_data = (Button)findViewById(R.id.btn_update_data);
        btn_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 15.99);
                db.update("book", values, "name = ?", new String[]{"The Lost Symbol"});
            }
        });
    }
}
