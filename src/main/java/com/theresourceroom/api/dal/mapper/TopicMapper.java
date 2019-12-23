package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.Topic;

public class TopicMapper implements RowMapper<Topic> {

	public Topic map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Topic(rs.getInt("id"), rs.getString("name"), rs.getInt("school"));
	}

}
