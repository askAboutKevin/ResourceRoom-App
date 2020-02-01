package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.SchoolMapper;
import com.theresourceroom.api.models.School;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface SchoolDAO {

	@SqlQuery("SELECT id, registered, name, street_address, city, state, zip_code, country, nces_number, code_hash FROM School")
	@RegisterRowMapper(SchoolMapper.class)
	List<School> getAllSchools();

	@SqlQuery("SELECT id, registered, name, street_address, city, state, zip_code, country, nces_number, code_hash FROM School WHERE id = ?")
	@RegisterRowMapper(SchoolMapper.class)
	School getSchoolById(int id);

	@SqlQuery("SELECT id, registered, name, street_address, city, state, zip_code, country, nces_number, code_hash FROM School WHERE nces_number = ?")
	@RegisterRowMapper(SchoolMapper.class)
	School getSchoolByNcesNumber(String nces_number);

	@SqlUpdate("INSERT INTO School (name, street_address, city, state, zip_code, country, nces_number, code_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")
	int addSchool(String name, String street_address, String city, String state, String zipcode, String country, String nces_number, String code_hash);

	@SqlUpdate("UPDATE School SET name = ?, street_address = ?, city = ?, state = ?, zip_code = ?, country = ?, nces_number = ?, code_hash = ? WHERE id = ?")
	int updateSchool(String name, String street_address, String city, String zipcode, String country, String nces_number, String code_hash, int id);

	@SqlUpdate("DELETE FROM School WHERE id = ?")
	int deleteSchool(int id);



}
