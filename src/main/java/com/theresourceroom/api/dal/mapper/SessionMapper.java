package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.Session;

public class SessionMapper implements RowMapper<Session> {

	public Session map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Session(rs.getInt("id"), rs.getInt("user_id"), rs.getString("cookie"), rs.getDate("started"), rs.getDate("expires"));
	}

}
