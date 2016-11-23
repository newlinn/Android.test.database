package com.project.androidtestdatabase.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.types.IntegerObjectType;
import com.j256.ormlite.table.DatabaseTable;

import java.security.Key;

/**
 * Created by LingChen on 2016/11/23.
 */

@DatabaseTable(tableName = "book")
public class Book {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String author;
    @DatabaseField
    double price;
    @DatabaseField
    int pages;
    @DatabaseField
    String name;
    @DatabaseField
    int category_id;

    Book() {
        // needed by ormlite
    }
}
