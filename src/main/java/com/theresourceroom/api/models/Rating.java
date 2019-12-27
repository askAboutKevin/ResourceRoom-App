package com.theresourceroom.api.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Rating {

	private int id;
	private String type;
	private int rated_obj_id;
	private int rate;
	
	public Rating(int id, String type, int rated_obj_id, int rate) {
		super();
		this.id = id;
		this.type = type;
		this.rated_obj_id = rated_obj_id;
		this.rate = rate;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ColumnName("rated_obj_id")
	public int getRated_obj_id() {
		return rated_obj_id;
	}

	public void setRated_obj_id(int rated_obj_id) {
		this.rated_obj_id = rated_obj_id;
	}

	@ColumnName("rate")
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
