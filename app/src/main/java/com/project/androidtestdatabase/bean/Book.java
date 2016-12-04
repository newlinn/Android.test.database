package com.project.androidtestdatabase.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LingChen on 2016/11/23.
 */

@DatabaseTable(tableName = "book")
public class Book extends AbsBean {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "category_id")
    Category category;

    public Book() {
        // needed by ormlite
    }
}
