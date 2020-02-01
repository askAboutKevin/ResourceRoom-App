package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.Rating;

public class RatingMapper implements RowMapper<Rating> {

	public Rating map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Rating(rs.getInt("id"), rs.getString("type"), rs.getInt("rated_object_id"), rs.getInt("topic_id"), rs.getInt("rate"));
	}

}
