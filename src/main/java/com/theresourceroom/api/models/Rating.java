package com.theresourceroom.api.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Rating {

	private int id;
	private String title;
	private int topic_id;
	private int rate;
	
	public Rating(int id, String title, int topic_id, int rate) {
		super();
		this.id = id;
		this.title = title;
		this.topic_id = topic_id;
		this.rate = rate;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ColumnName("topic_id")
	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	@ColumnName("rate")
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
