package com.example.finalproject.view.database;

import android.view.View;

import com.example.finalproject.entity.AppDatabase;
import com.example.finalproject.entity.DataQuote;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataQuote> list);
        void editData(DataQuote item);
        void deleteData(DataQuote item);
    }

    interface presenter{
        void insertData (String quote_body, String quote_author, AppDatabase database);
        void readData (AppDatabase database);
        void editData (String quote_body, String quote_author, int id, AppDatabase database);
        void deleteData (DataQuote dataQuote, AppDatabase database);
    }
}
