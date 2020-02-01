package com.theresourceroom.api.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class School {
	
	private int id;
	private Date registered;
	private String name;
	private String street_address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String nces_number;
	private String code_hash;
	

	public School(int id, Date registered, String name, String street_address, String city, String state, String zipcode,
			String country, String nces_number, String code_hash) {
		super();
		this.id = id;
		this.registered = registered;
		this.name = name;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.nces_number = nces_number;
		this.code_hash = code_hash;
	}

	// Constructor for incoming requests
	@JsonCreator
	public School(@JsonProperty("name") String name, @JsonProperty("street_address") String street_address, @JsonProperty("city") String city, @JsonProperty("state") String state, @JsonProperty("zipcode") String zipcode,
				  @JsonProperty("country") String country, @JsonProperty("nces_number") String nces_number, @JsonProperty("code_hash") String code_hash) {
		super();
		this.name = name;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.nces_number = nces_number;
		this.code_hash = code_hash;
	}

	@ColumnName("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ColumnName("registered")
	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	@ColumnName("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ColumnName("street_address")
	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	@ColumnName("city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ColumnName("state")
	public String getState() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	@ColumnName("zip_code")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@ColumnName("country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ColumnName("nces_number")
	public String getNces_number() {
		return nces_number;
	}

	public void setNces_number(String nces_number) {
		this.nces_number = nces_number;
	}

	@ColumnName("code_hash")
	public String getCode_hash() {
		return code_hash;
	}

	public void setCode_hash(String code_hash) {
		this.code_hash = code_hash;
	}
	
	
}
