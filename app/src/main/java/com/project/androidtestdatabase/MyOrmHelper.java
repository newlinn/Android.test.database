package com.project.androidtestdatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.table.TableUtils;
import com.project.androidtestdatabase.bean.Book;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.project.androidtestdatabase.bean.Category;

/**
 * Created by LingChen on 2016/11/23.
 */

public class MyOrmHelper extends OrmLiteSqliteOpenHelper {

    private static MyOrmHelper instance;

    public static synchronized MyOrmHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (MyOrmHelper.class) {
                if (instance == null) {
                    instance = new MyOrmHelper(context);
                }
            }
        }
        return instance;
    }

    private static final String DB_NAME = "BookStore.db";
    private static int DATABASE_VERSION = 1;

    private MyOrmHelper(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Category.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
