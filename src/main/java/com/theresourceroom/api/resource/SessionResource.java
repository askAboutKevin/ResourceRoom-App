package com.theresourceroom.api.resource;

import com.theresourceroom.api.models.Session;
import com.theresourceroom.api.service.session.SessionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SessionResource {

    private SessionService sessionService;

    public SessionResource(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GET
    @Path("/{cookie}")
    public Response getSessionWithCookie(@PathParam("cookie")  String cookie) {

        Session session = this.sessionService.getSessionWithCookie(cookie);

        return Response
                .status(Response.Status.OK)
                .entity(session)
                .build();
    }

    @PUT
    public Response renewSession(Session session) {
        String cookie = session.getCookie();
        int sessionRenewed = this.sessionService.renewSession(cookie);

        Boolean success = Boolean.FALSE;

        if(sessionRenewed == 1) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @POST
    public Response createNewSession(Session session) {

        int user_id = session.getUser_id();
        String cookie = session.getCookie();
        Date start = session.getStarted();

        int sessionCreated = this.sessionService.createNewSession(user_id, cookie, start);

        Boolean success = Boolean.FALSE;

        if(sessionCreated == 1) {
            success = Boolean.TRUE;
        }

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }
}
