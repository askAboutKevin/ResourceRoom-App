package com.theresourceroom.api.models;

import java.util.Date;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Session {

	private int id;
	private int user_id;
	private String cookie;
	private Date started;
	private Date expires;
	
	public Session(int id, int user_id, String cookie, Date started, Date expires) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.cookie = cookie;
		this.started = started;
		this.expires = expires;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("user_id")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@ColumnName("cookie")
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	@ColumnName("started")
	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	@ColumnName("expires")
	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}
	
	
}
