package com.example.finalproject.view.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.finalproject.entity.AppDatabase;
import com.example.finalproject.entity.DataQuote;

import java.util.List;

public class MainPresenter implements MainContact.presenter {
    private MainContact.view view;

    public MainPresenter(MainContact.view view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void, Void, Long>{
        private AppDatabase appDatabase;
        private DataQuote dataQuote;

        public InsertData(AppDatabase appDatabase, DataQuote dataQuote) {
            this.appDatabase = appDatabase;
            this.dataQuote = dataQuote;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataQuote);
        }

        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String quote_body, String quote_author, AppDatabase database) {
        final DataQuote dataQuote = new DataQuote();
        dataQuote.setQuote_body(quote_body);
        dataQuote.setQuote_author(quote_author);
        new InsertData(database, dataQuote).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataQuote> list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataQuote dataQuote;

        public EditData(AppDatabase appDatabase, DataQuote dataQuote) {
            this.appDatabase = appDatabase;
            this.dataQuote = dataQuote;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.dao().updateData(dataQuote);
        }
        protected void onPostExecute(Integer integer){
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : "+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String quote_body, String quote_author, int id, AppDatabase database) {
        final DataQuote dataQuote = new DataQuote();
        dataQuote.setQuote_body(quote_body);
        dataQuote.setQuote_author(quote_author);
        dataQuote.setId(id);
        new EditData(database, dataQuote).execute();
    }

    class DeleteData extends AsyncTask<Void, Void, Long> {
        private AppDatabase appDatabase;
        private DataQuote dataQuote;

        public DeleteData(AppDatabase appDatabase, DataQuote dataQuote) {
            this.appDatabase = appDatabase;
            this.dataQuote = dataQuote;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            appDatabase.dao().deleteData(dataQuote);
            return null;
        }
        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataQuote dataQuote, AppDatabase database) {
        new DeleteData(database, dataQuote).execute();
    }
}
