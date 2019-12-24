package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.User;

public interface UserDAO {

	
//	CREATE TABLE User (
//			id INT AUTO_INCREMENT PRIMARY KEY,
//			registered DATETIME DEFAULT CURRENT_TIMESTAMP,
//			first_name VARCHAR(255),
//			last_name VARCHAR(255),
//			school INT,
//			salt VARCHAR(255),
//			password_hash VARCHAR(255),
//			email VARCHAR(255),
//			last_logged_in DATETIME,
//			last_logged_off DATETIME,
//			license_used INT,
//			role ENUM(‘Teacher’, ‘Parent’, ‘Student’, ‘Admin’) NOT NULL,
//			FOREIGN KEY(license_used) REFERENCES License(num),
//			FOREIGN KEY(school) REFERENCES School(id)
//			);
	
	User getUserById(int id);
	
	List<User> getUsers();
	
	int createUser(Date today, String first_name, String last_name, int school, String salt, String password_hash, int license_used, String role);

}
