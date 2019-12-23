package com.theresourceroom.api.models;

import java.util.Date;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class License {
	
	private int num;
	private Date purchased;
	private Date expires;
	private String role;
	
	public License(int num, Date purchased, Date expires, String role) {
		super();
		this.num = num;
		this.purchased = purchased;
		this.expires = expires;
		this.role = role;
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


}
