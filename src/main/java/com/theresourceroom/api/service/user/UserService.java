package com.theresourceroom.api.service.user;

import com.theresourceroom.api.dal.mapper.UserMapper;
import com.theresourceroom.api.models.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getUsers();

    List<User> getParents();

    List<User> getTeachers();

    List<User> getParentsFromSchool(int school);

    List<User> getTeachersFromSchool(int school);

    int createUser(Date today, String first_name, String last_name, int school, String salt, String password_hash, int license_used, String role);

    int updateUser(String first_name, String last_name, String email, Date last_logged_in, Date last_logged_off, int license_used, int id);

    int deleteUser(int id);

}
