package com.project.androidtestdatabase.dao;

import android.content.Context;

import com.project.androidtestdatabase.bean.Category;

/**
 * Created by LingChen on 2016/12/4.
 */

public class CategoryDao extends AbsDao<Category> {

    public CategoryDao(Context context){
        super(context, Category.class);
    }
}
