package com.theresourceroom.api.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Tutorial {

	private int id;
	private String name;
	private String link_story;
	private String link_image;
	
	public Tutorial(int id, String name, String link_story, String link_image) {
		super();
		this.id = id;
		this.name = name;
		this.link_story = link_story;
		this.link_image = link_image;
	}
	
	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ColumnName("link_story")
	public String getLink_story() {
		return link_story;
	}

	public void setLink_story(String link_story) {
		this.link_story = link_story;
	}

	@ColumnName("link_image")
	public String getLink_image() {
		return link_image;
	}

	public void setLink_image(String link_image) {
		this.link_image = link_image;
	}
}
