package com.theresourceroom.api.resource;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.theresourceroom.api.service.user.UserService;
import com.theresourceroom.api.models.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/{id}")
    public Response fetchUserById(@PathParam("id") int id) {

        User user = this.userService.getUserById(id);

        if(user != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(user)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    public Response fetchAllUsers() {

        List<User> users = this.userService.getUsers();

        if( users != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(users)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/parents")
    public Response fetchParents() {

        List<User> users = this.userService.getParents();

        if( users != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(users)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/teachers")
    public Response fetchTeachers() {

        List<User> users = this.userService.getTeachers();

        if( users != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(users)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/parents/{school}")
    public Response fetchParentsFromSchool(@PathParam("school") int school) {

        List<User> users = this.userService.getParentsFromSchool(school);

        if( users != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(users)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/teachers/{school}")
    public Response fetchTeachersFromSchool(@PathParam("school") int school) {

        List<User> users = this.userService.getTeachersFromSchool(school);

        if( users != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(users)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @POST
    public Response createUser(User user) {

        String first_name = user.getFirst_name();
        String last_name = user.getLast_name();
        int school = user.getSchool();
        String password_hash = user.getPassword_hash();
        String role = user.getRole();
        String email = user.getEmail();
        Boolean success = Boolean.FALSE;

        int countAdded = this.userService.createUser(first_name, last_name, school, password_hash, email, role);

        if(countAdded == 1) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(User user, @PathParam("id") int id) {

        String first_name = user.getFirst_name();
        String last_name = user.getLast_name();
        String password = user.getPassword_hash();
        int license_used = user.getLicense_used();
        String email = user.getEmail();
        String last_logged_in = user.getLast_logged_in();
        String last_logged_off = user.getLast_logged_off();

        Boolean success;

        int countUpdated = this.userService.updateUser(first_name, last_name, email, password, license_used, id);

        if (countUpdated == 1) {
            success = Boolean.TRUE;

            return Response
                    .status(Response.Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(int id) {

        int countDeleted = this.userService.deleteUser(id);

        Boolean success;

        if (countDeleted == 1) {
            success = Boolean.TRUE;

            return Response
                    .status(Response.Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }


}
