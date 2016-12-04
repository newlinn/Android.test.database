package com.project.androidtestdatabase.dao;

import android.content.Context;

import com.project.androidtestdatabase.bean.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by newli on 2016/11/26.
 */

public class BookDao extends AbstractDao<Book> {

    public BookDao(Context context) {
        super(context, Book.class);
    }
    public List<Book> getByName(String name) {
        try {
            return this.getDao().queryBuilder().where().eq("name", name)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
