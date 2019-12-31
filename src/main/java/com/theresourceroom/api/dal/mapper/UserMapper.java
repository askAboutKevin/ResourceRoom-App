package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.User;

public class UserMapper implements RowMapper<User> {

	public User map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new User(
					rs.getInt("id"),
					rs.getString("registered"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("school"), 
					rs.getString("salt"),
					rs.getString("password_hash"), 
					rs.getString("email"), 
					rs.getString("last_logged_in"),
					rs.getString("last_logged_off"),
					rs.getInt("license_used"),
					rs.getString("role")
				);
	}

}
