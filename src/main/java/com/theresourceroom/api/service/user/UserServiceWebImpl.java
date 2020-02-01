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
    public User createUser(String first_name, String last_name, int school, String password, String email, int license_used, String role) {

        if (school < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        role = role.strip().toUpperCase();
        String salt = SecureSalt.generateSalt();
        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);

        int id = this.userDAO.createUser(first_name, last_name, school, salt, hash, email, license_used, role);
        User user = this.userDAO.getUserById(id);
        user.setSalt(null); user.setPassword_hash(null);

        if(user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return user;
    }

    @Override
    public User updateUser(String first_name, String last_name, String email, int license_used, int id) {
        if (id < 1 || license_used < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        if (this.userDAO.updateUserNameAndEmail(first_name, last_name, email, license_used, id) == 1) {
            return this.userDAO.getUserById(id);
        }
//      else if (password != null) {
//          if(this.userDAO.updatePassword(hash, salt, id) == 1) {
//              return this.userDAO.getUserById(id);
//          }
//    }
        throw new WebApplicationException(Response.Status.NOT_MODIFIED);
    }

    @Override
    public int deleteUser(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.userDAO.deleteUser(id);
    }
}
