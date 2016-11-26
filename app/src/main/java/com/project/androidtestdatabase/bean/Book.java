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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

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

    public Book() {
        // needed by ormlite
    }
}
