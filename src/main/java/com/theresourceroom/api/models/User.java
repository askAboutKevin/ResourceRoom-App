package com.theresourceroom.api.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class User {

	private int id;
	private String registered;
	private String first_name;
	private String last_name;
	private int school;
	private String salt;
	private String password_hash;
	private String email;
	private Date last_logged_in;
	private Date last_logged_off;
	private int license_used;
	private String role;


	public User(int id, String registered, String first_name, String last_name, int school, String salt,
				String password_hash, String email, Date last_logged_in, Date last_logged_off, int license_used,
				String role) {
		super();
		this.id = id;
		this.registered = registered;
		this.first_name = first_name;
		this.last_name = last_name;
		this.school = school;
		this.salt = salt;
		this.password_hash = password_hash;
		this.email = email;
		this.last_logged_in = last_logged_in;
		this.last_logged_off = last_logged_off;
		this.license_used = license_used;
		this.role = role;
	}

	// Constructor for incoming requests
	@JsonCreator
	public User(@JsonProperty("first_name") String first_name, @JsonProperty("last_name") String last_name, @JsonProperty("school") int school,
				@JsonProperty("password_hash") String password_hash, @JsonProperty("email") String email, @JsonProperty("license_used") int license_used,
				@JsonProperty("role") String role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.school = school;
		this.password_hash = password_hash;
		this.email = email;
		this.license_used = license_used;
		this.role = role;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("registered")
	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	@ColumnName("first_name")
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@ColumnName("last_name")
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@ColumnName("school")
	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	@ColumnName("salt")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@ColumnName("password_hash")
	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	@ColumnName("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ColumnName("last_logged_in")
	public Date getLast_logged_in() {
		return last_logged_in;
	}

	public void setLast_logged_in(Date last_logged_in) {
		this.last_logged_in = last_logged_in;
	}

	@ColumnName("last_logged_off")
	public Date getLast_logged_off() {
		return last_logged_off;
	}

	public void setLast_logged_off(Date last_logged_off) {
		this.last_logged_off = last_logged_off;
	}

	@ColumnName("license_used")
	public int getLicense_used() {
		return license_used;
	}

	public void setLicense_used(int license_used) {
		this.license_used = license_used;
	}

	@ColumnName("role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
