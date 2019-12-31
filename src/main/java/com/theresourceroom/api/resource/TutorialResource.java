package com.theresourceroom.api.resource;

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

import com.theresourceroom.api.models.Article;
import com.theresourceroom.api.service.tutorial.TutorialService;
import com.theresourceroom.api.models.Tutorial;

@Path("/tutorial")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)public class TutorialResource {

    private TutorialService tutorialService;

    public TutorialResource(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GET
    public Response fetchAllTutorials(@QueryParam("topic") OptionalInt topicId) {

        if (!topicId.isEmpty()) {
            List<Tutorial> tutorials = this.tutorialService.getAllTutorialsForTopic(topicId.getAsInt());

            if (tutorials != null) {
                return Response
                        .status(Response.Status.OK)
                        .entity(tutorials)
                        .build();
            }
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        List<Tutorial> tutorials = this.tutorialService.getAllTutorials();

        if (tutorials != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(tutorials)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchTutorialById(@PathParam("id") int id) {

        Tutorial tutorial = this.tutorialService.getTutorialById(id);
        if (tutorial != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(tutorial)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @POST
    public Response createdTutorial(Tutorial tutorial) {

        String name = tutorial.getName(), link_image = tutorial.getLink_image(), link_story = tutorial.getLink_story();
        int tutorialCreated = this.tutorialService.AddTutorial(name, link_image, link_story);

        Boolean success = Boolean.FALSE;

        if( tutorialCreated == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.CREATED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTutorial(@PathParam("id") int id) {

        int tutorialDeleted = this.tutorialService.deleteTutorial(id);
        Boolean success = Boolean.FALSE;

        if( tutorialDeleted == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @Path("/{id}")
    public Response updateTutorial(@PathParam("id") int id, Tutorial tutorial) {
        String name = tutorial.getName(), link_image = tutorial.getLink_image(), link_story = tutorial.getLink_story();
        int tutorialUpdated = this.tutorialService.updateTutorial(name, link_image, link_story, id);
        Boolean success = Boolean.FALSE;

        if( tutorialUpdated == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.CREATED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
