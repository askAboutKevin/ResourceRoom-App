package com.theresourceroom.api.service.user;

import com.theresourceroom.api.models.User;

import java.util.Date;
import java.util.List;

public class UserServiceWebImpl implements UserService {

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getParents() {
        return null;
    }

    @Override
    public List<User> getTeachers() {
        return null;
    }

    @Override
    public List<User> getParentsFromSchool(int school) {
        return null;
    }

    @Override
    public List<User> getTeachersFromSchool(int school) {
        return null;
    }

    @Override
    public int createUser(Date today, String first_name, String last_name, int school, String salt, String password_hash, int license_used, String role) {
        return 0;
    }

    @Override
    public int updateUser(String first_name, String last_name, String email, Date last_logged_in, Date last_logged_off, int license_used, int id) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
