package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.UserMapper;
import com.theresourceroom.api.models.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

public interface UserDAO {

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User WHERE id = ?")
	@RegisterRowMapper(UserMapper.class)
	User getUserById(int id);

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User")
	@RegisterRowMapper(UserMapper.class)
	List<User> getUsers();

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User WHERE role = 'Parent' ")
	@RegisterRowMapper(UserMapper.class)
	List<User> getParents();

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User WHERE role = 'Teacher' ")
	@RegisterRowMapper(UserMapper.class)
	List<User> getTeachers();

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User WHERE school = ? AND role = 'Parent' ")
	@RegisterRowMapper(UserMapper.class)
	List<User> getParentsFromSchool(int school);

	@SqlQuery("SELECT id, registered, first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role FROM User WHERE id = ? AND role = 'Teacher' ")
	@RegisterRowMapper(UserMapper.class)
	List<User> getTeachersFromSchool(int school);

	@SqlUpdate("INSERT INTO User (first_name, last_name, school, salt, password_hash, email, last_logged_in, last_logged_off, license_used, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?")
	int createUser(Date today, String first_name, String last_name, int school, String salt, String password_hash, int license_used, String role);

	@SqlUpdate("UPDATE User SET first_name = ?, last_name = ?, school = ?, salt = ?, password_hash = ?, email = ?, last_logged_in = ?, last_logged_off = ?, license_used = ? WHERE ID = ?")
	int updateUser(String first_name, String last_name, String email, Date last_logged_in, Date last_logged_off, int license_used, int id);

	@SqlUpdate("DELETE FROM User WHERE ID = ?")
	int deleteUser(int id);
}
