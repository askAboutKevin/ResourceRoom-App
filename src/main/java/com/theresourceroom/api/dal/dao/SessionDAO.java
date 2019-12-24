package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Session;
import com.theresourceroom.api.models.User;

public interface SessionDAO {

	User getUserWIthSessionCookie(String cookie);
	
	int renewSession(String cookie);
	
	int createNewSession(int user_id, String cookie);
	
	Date checkSessionExpiration(String cookie);
	
	Date checkSessionStart(String cookie);


}
