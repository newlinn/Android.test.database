package com.project.androidtestdatabase.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LingChen on 2016/11/23.
 */

@DatabaseTable(tableName = "category")
public class Category {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(canBeNull = false)
    String category_name;
    @DatabaseField
    int category_code;

    public Category() {
        // needed by ormlite
    }
}
