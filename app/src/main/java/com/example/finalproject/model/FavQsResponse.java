package com.example.finalproject.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FavQsResponse{

	@SerializedName("last_page")
	private boolean lastPage;

	@SerializedName("page")
	private int page;

	@SerializedName("quotes")
	private ArrayList<QuotesItem> quotes;

	public void setLastPage(boolean lastPage){
		this.lastPage = lastPage;
	}

	public boolean isLastPage(){
		return lastPage;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setQuotes(ArrayList<QuotesItem> quotes){
		this.quotes = quotes;
	}

	public ArrayList<QuotesItem> getQuotes(){
		return quotes;
	}
}