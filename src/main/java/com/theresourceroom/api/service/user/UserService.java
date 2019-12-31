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

    int createUser(String first_name, String last_name, int school, String password_hash, String email, String role);

    int updateUser(String first_name, String last_name, String email, String password, int license_used, int id);

    int deleteUser(int id);

}
