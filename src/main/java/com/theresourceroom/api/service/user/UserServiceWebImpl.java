package com.theresourceroom.api.service.user;

import com.theresourceroom.api.dal.dao.UserDAO;
import com.theresourceroom.api.models.User;

import java.util.Date;
import java.util.List;

public class UserServiceWebImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceWebImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = this.userDAO.getUsers();
        return users;
    }

    @Override
    public List<User> getParents() {
        List<User> parents = this.userDAO.getParents();
        return parents;
    }

    @Override
    public List<User> getTeachers() {
        List<User> teachers = this.userDAO.getTeachers();
        return teachers;
    }

    @Override
    public List<User> getParentsFromSchool(int school) {
        List<User> parents = this.userDAO.getParentsFromSchool(school);
        return parents;    }

    @Override
    public List<User> getTeachersFromSchool(int school) {
        List<User> parents = this.userDAO.getTeachersFromSchool(school);
        return parents;
    }

    @Override
    public int createUser(String first_name, String last_name, int school, String password_hash, String email, String role) {

        int added = this.userDAO.createUser(first_name, last_name, school, "salt", password_hash, email, 1, role);
        return added;
    }

    @Override
    public int updateUser(String first_name, String last_name, String email, String password, int license_used, int id) {

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);


        int updated = this.userDAO.updateUser(first_name, last_name, email, currentTime, currentTime, 9, id);
        return updated;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
