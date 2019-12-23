package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.License;

public class LicenceMapper implements RowMapper<License> {

	public License map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new License(rs.getInt("num"), rs.getDate("purchased"), rs.getDate("expires"), rs.getString("role"));
	}

}
