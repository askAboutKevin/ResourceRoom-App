package com.theresourceroom.api.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Topic {
	
	private int id;
	private String name;
	private int school;
	
	public Topic(int id, String name, int school) {
		super();
		this.id = id;
		this.name = name;
		this.school = school;
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

	@ColumnName("school")
	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

}
