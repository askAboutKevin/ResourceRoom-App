package com.theresourceroom.api.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class License {
	
	private int num;
	private Date purchased;
	private int purchased_by;
	private Date expires;
	private String role;
	
	public License(int num, Date purchased, Date expires, int purchased_by, String role) {
		super();
		this.num = num;
		this.purchased = purchased;
		this.expires = expires;
		this.role = role;
		this.purchased_by = purchased_by;
	}

	// Constructor for incoming requests
	@JsonCreator
	public License(@JsonProperty("purchased_by") int purchased_by, @JsonProperty("role") String role) {
		super();
		this.role = role;
		this.purchased_by = purchased_by;
	}

	@ColumnName("num")
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@ColumnName("purchased")
	public Date getPurchased() {
		return purchased;
	}

	public void setPurchased(Date purchased) {
		this.purchased = purchased;
	}

	@ColumnName("expires")
	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	@ColumnName("role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ColumnName("purchased_by")
	public int getPurchased_by() {
		return purchased_by;
	}

	public void setPurchased_by(int purchased_by) {
		this.purchased_by = purchased_by;
	}


}
