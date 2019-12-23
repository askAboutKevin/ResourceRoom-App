package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.Tutorial;

public class TutorialMapper implements RowMapper<Tutorial> {

	public Tutorial map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Tutorial(rs.getInt("id"), rs.getString("name"), rs.getString("link_story"), rs.getString("link_image"));
	}

}
