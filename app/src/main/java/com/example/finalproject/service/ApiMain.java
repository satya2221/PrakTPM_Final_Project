package com.example.finalproject.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// deklarasi base url untuk  API
public class ApiMain {
    private Retrofit retrofit;

    public QuoteRepo getApiFavQs(){
        String BASE_URL = "https://favqs.com/api/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuoteRepo.class);
    }
}
