package com.project.androidtestdatabase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TableLayout;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.table.TableUtils;
import com.project.androidtestdatabase.bean.Book;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.project.androidtestdatabase.bean.Category;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LingChen on 2016/11/23.
 */

public class MyOrmHelper extends OrmLiteSqliteOpenHelper {

    private static MyOrmHelper instance;

    public static synchronized MyOrmHelper getInstance(Context context) {
        context = context.getApplicationContext();
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
    private Map<String, Dao> daos = new HashMap<>();

    private MyOrmHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Category.class);
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Category.class, true);
            TableUtils.dropTable(connectionSource, Book.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }

    public synchronized Dao getDao(Class cls) throws java.sql.SQLException {
        Dao dao = null;
        String clsName = cls.getSimpleName();
        if (daos.containsKey((clsName))) {
            dao = daos.get((clsName));
        }
        if (dao == null) {
            dao = super.getDao(cls);
            daos.put(clsName, dao);
        }
        return dao;
    }
}
