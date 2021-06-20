package com.example.finalproject.view.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject.model.FavQsResponse;
import com.example.finalproject.model.QuotesItem;
import com.example.finalproject.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavQsViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<QuotesItem>> listFavQs = new MutableLiveData<>();

    public void setFavQs(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFavQs().getQuote().enqueue(new Callback<FavQsResponse>() {
            @Override
            public void onResponse(Call<FavQsResponse> call, Response<FavQsResponse> response) {
                FavQsResponse responseQuote =response.body();

                if (responseQuote != null && responseQuote.getQuotes() != null){
                    ArrayList<QuotesItem> quotesItems = responseQuote.getQuotes();
                    listFavQs.postValue(quotesItems);
                }
            }

            @Override
            public void onFailure(Call<FavQsResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<QuotesItem>> getFavQs(){
        return listFavQs;
    }
}
