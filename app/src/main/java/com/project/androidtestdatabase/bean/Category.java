package com.project.androidtestdatabase.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LingChen on 2016/11/23.
 */

@DatabaseTable(tableName = "category")
public class Category extends AbsBean {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public ForeignCollection<Book> getBooks() {
        return books;
    }

    public void setBooks(ForeignCollection<Book> books) {
        this.books = books;
    }

    @DatabaseField(generatedId = true, canBeNull = false)
    int id;
    @DatabaseField(canBeNull = false)
    String category_name;
    @DatabaseField
    String category_code;
    @ForeignCollectionField
    ForeignCollection<Book> books;

    public Category() {
        // needed by ormlite
    }

    @Override
    public int hashCode() {
        return (category_code + category_name).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass())
            return false;
        Category other = (Category) obj;
        return (category_code + category_name)
                .equals(other.getCategory_code() + other.getCategory_name());
    }
}
