package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.School;

public class SchoolMapper implements RowMapper<School> {

	public School map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new School(
					rs.getInt("id"), 
					rs.getDate("registered"), 
					rs.getString("name"), 
					rs.getString("street_address"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getString("zip_code"),
					rs.getString("country"), 
					rs.getString("nces_number"), 
					rs.getString("code_hash")
					);
	}

}
