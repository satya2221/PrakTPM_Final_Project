package com.example.finalproject.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataQuoteDAO {
    @Insert
    Long insertData (DataQuote dataQuote);

    @Query("Select * from quote_db")
    List<DataQuote> getData();

    @Update
    int updateData(DataQuote item);

    @Delete
    void deleteData(DataQuote item);
}
