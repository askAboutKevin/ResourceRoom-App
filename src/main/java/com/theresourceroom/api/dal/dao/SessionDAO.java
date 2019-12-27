package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import com.theresourceroom.api.dal.mapper.SessionMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Session;

public interface SessionDAO {

	@SqlQuery("SELECT id, user_id, cookie, started, expires FROM Session")
	@RegisterRowMapper(SessionMapper.class)
	Session getSessionWithCookie(String cookie);

	@SqlUpdate("UPDATE Session SET started = ?")
	int renewSession(String cookie);

	@SqlUpdate("INSERT INTO Session (user_id, cookie, started) VALUES (?, ?, ?)")
	int createNewSession(int user_id, String cookie, Date start);

}
