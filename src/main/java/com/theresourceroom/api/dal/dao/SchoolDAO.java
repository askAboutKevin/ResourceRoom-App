package com.theresourceroom.api.dal.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.School;

public interface SchoolDAO {

	List<School> getAllSchools();
	
	School getSchoolById(int id);
	
	School getSchoolByNcesNumber(String nces_number);
	
	int addSchool(String name, String street_address, String city, String zipcode, String country, String nces_number, String code_hash);
	
	int updateSchool(String name, String street_address, String city, String zipcode, String country, String nces_number, String code_hash);
	
}
