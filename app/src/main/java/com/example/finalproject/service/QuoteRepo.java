package com.example.finalproject.service;

import com.example.finalproject.model.FavQsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface QuoteRepo {
    @Headers("Authorization: Token token=\"ab0b3345565062723787525cdca97538\"")
    @GET("quotes/")
    Call<FavQsResponse> getQuote();

}
