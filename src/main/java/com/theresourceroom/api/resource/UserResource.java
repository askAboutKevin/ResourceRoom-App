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

import com.theresourceroom.api.models.License;
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

        Boolean success = Boolean.FALSE;

        User user1 = this.userService.createUser(
                user.getFirst_name(),
                user.getLast_name(),
                user.getSchool(),
                user.getPassword_hash(),
                user.getEmail(),
                user.getLicense_used(),
                user.getRole());

        if(user1 != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(user1)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(User user, @PathParam("id") int id) {

        user = this.userService.updateUser(
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getLicense_used(),
                id);

        if (user != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(user)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {

        int countDeleted = this.userService.deleteUser(id);

        Boolean success;

        if (countDeleted == 1) {
            success = Boolean.TRUE;

            return Response
                    .status(Status.ACCEPTED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }


}
