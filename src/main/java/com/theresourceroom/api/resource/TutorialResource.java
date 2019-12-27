package com.theresourceroom.api.resource;

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
import com.theresourceroom.api.service.tutorial.TutorialService;
import com.theresourceroom.api.models.Tutorial;

@Path("/tutorial")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)public class TutorialResource {

    private TutorialService tutorialService;

    public TutorialResource(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }
}
