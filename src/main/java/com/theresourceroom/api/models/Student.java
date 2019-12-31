package com.theresourceroom.api.models;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Student {

	private int id;
	private String name;
	private int teacher;
	private int parent;
	private int license_used;

	public Student(int id, String name, int teacher, int parent, int license_used) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.parent = parent;
		this.license_used = license_used;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("teacher")
	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	@ColumnName("parent")
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@ColumnName("license_used")
	public int getLicense_used() {
		return license_used;
	}

	public void setLicense_used(int license_used) {
		this.license_used = license_used;
	}

	@ColumnName("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
