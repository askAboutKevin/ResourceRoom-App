package com.theresourceroom.api.dal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.theresourceroom.api.models.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("teacher"), rs.getInt("parent"), rs.getInt("license_used"));
	}

}
