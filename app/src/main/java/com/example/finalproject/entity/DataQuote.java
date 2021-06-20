package com.example.finalproject.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quote_db")
public class DataQuote {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "quote_body")
    private String quote_body;

    @ColumnInfo(name = "quote_author")
    private String quote_author;

    public String getQuote_author() {
        return quote_author;
    }

    public void setQuote_author(String quote_author) {
        this.quote_author = quote_author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote_body() {
        return quote_body;
    }

    public void setQuote_body(String quote_body) {
        this.quote_body = quote_body;
    }
}
