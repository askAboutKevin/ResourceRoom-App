package com.theresourceroom.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Rating {

	private int id;
	private String type;
	private int rated_object_id;
	private int topic_id;
	private int rate;
	
	public Rating(int id, String type, int rated_object_id, int topic_id, int rate) {
		super();
		this.id = id;
		this.type = type;
		this.rated_object_id = rated_object_id;
		this.topic_id = topic_id;
		this.rate = rate;
	}

	// Constructor for incoming requests
	@JsonCreator
	public Rating(@JsonProperty("type") String type, @JsonProperty("rated_object_id") int rated_object_id, @JsonProperty("topic_id") int topic_id, @JsonProperty("rate") int rate) {
		super();
		this.type = type;
		this.rated_object_id = rated_object_id;
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

	@ColumnName("type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ColumnName("rated_object_id")
	public int getRated_object_id() {
		return rated_object_id;
	}

	public void setRated_object_id(int rated_object_id) {
		this.rated_object_id = rated_object_id;
	}

	@ColumnName("topic_id")
	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.id = topic_id;
	}

	@ColumnName("rate")
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
