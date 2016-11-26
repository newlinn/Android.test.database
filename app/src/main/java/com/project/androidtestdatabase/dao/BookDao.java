package com.project.androidtestdatabase.dao;

import android.content.Context;
import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.project.androidtestdatabase.MyOrmHelper;
import com.project.androidtestdatabase.bean.Book;

/**
 * Created by newli on 2016/11/26.
 */

public class BookDao {
    private Dao<Book, Integer> mBookDao;
    private MyOrmHelper dbhelper;

    public BookDao(Context context) {
        try {
            dbhelper = MyOrmHelper.getInstance(context);
            mBookDao = dbhelper.getDao(Book.class);
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void add(Book book) {
        try {
            mBookDao.create(book);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Book get(int id) {
        Book book = null;
        try {
            book = mBookDao.queryForId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> getByName(String name) {
        try {
            return mBookDao.queryBuilder().where().eq("name", name)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
