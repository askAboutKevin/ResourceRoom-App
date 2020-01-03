package com.theresourceroom.api.service.user;

import com.theresourceroom.api.dal.dao.UserDAO;
import com.theresourceroom.api.models.License;
import com.theresourceroom.api.models.User;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.theresourceroom.api.util.SecureSalt;
import com.theresourceroom.api.util.PasswordHashSHA512;
import java.util.List;

public class UserServiceWebImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceWebImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.userDAO.getUserById(id);
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
    public int createUser(String first_name, String last_name, int school, String password, String email, List<License> licenses, String role) {
        role = role.strip().toUpperCase();
        if(school < 1 || !email.matches(".+@.+/..+") || !role.matches("TEACHER") || !role.matches("ADMIN") || !role.matches("STUDENT") || !role.matches("PARENT")) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        String salt = SecureSalt.generateSalt();
        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);
        int added = 0;
        for(int tries = 0; tries <= licenses.size(); tries++) {
            added = this.userDAO.createUser(first_name, last_name, school, salt, hash, email, licenses.get(tries).getNum(), role);
            if(added == 1) {
                break;
            }
        }
        return added;
    }

    @Override
    public int updateUser(String first_name, String last_name, String email, String password, int license_used, int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);

        int updated = this.userDAO.updateUser(first_name, last_name, email, currentTime, currentTime, 9, id);
        return updated;
    }

    @Override
    public int deleteUser(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.userDAO.deleteUser(id);
    }
}
