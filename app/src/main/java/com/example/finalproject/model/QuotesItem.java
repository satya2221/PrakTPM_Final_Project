package com.example.finalproject.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuotesItem{

	@SerializedName("private")
	private boolean jsonMemberPrivate;

	@SerializedName("favorites_count")
	private int favoritesCount;

	@SerializedName("author")
	private String author;

	@SerializedName("dialogue")
	private boolean dialogue;

	@SerializedName("upvotes_count")
	private int upvotesCount;

	@SerializedName("author_permalink")
	private String authorPermalink;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("url")
	private String url;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("downvotes_count")
	private int downvotesCount;

	@SerializedName("source")
	private String source;

	public void setJsonMemberPrivate(boolean jsonMemberPrivate){
		this.jsonMemberPrivate = jsonMemberPrivate;
	}

	public boolean isJsonMemberPrivate(){
		return jsonMemberPrivate;
	}

	public void setFavoritesCount(int favoritesCount){
		this.favoritesCount = favoritesCount;
	}

	public int getFavoritesCount(){
		return favoritesCount;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setDialogue(boolean dialogue){
		this.dialogue = dialogue;
	}

	public boolean isDialogue(){
		return dialogue;
	}

	public void setUpvotesCount(int upvotesCount){
		this.upvotesCount = upvotesCount;
	}

	public int getUpvotesCount(){
		return upvotesCount;
	}

	public void setAuthorPermalink(String authorPermalink){
		this.authorPermalink = authorPermalink;
	}

	public String getAuthorPermalink(){
		return authorPermalink;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setDownvotesCount(int downvotesCount){
		this.downvotesCount = downvotesCount;
	}

	public int getDownvotesCount(){
		return downvotesCount;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}
}