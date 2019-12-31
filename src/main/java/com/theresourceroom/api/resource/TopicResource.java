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

import com.theresourceroom.api.models.Tutorial;
import com.theresourceroom.api.service.topic.TopicService;
import com.theresourceroom.api.models.Topic;

@Path("/topic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TopicResource {

    private TopicService topicService;

    public TopicResource(TopicService topicService) {
        this.topicService = topicService;
    }

    int updateTopic(String name, int topic_id);

    @GET
    public Response fetchTopicsFromSchool(@QueryParam("school") int id) {

        List<Topic> topics = this.topicService.getTopicsFromSchool(id);

        if (topics != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(topics)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchWeakTopicsOfType(@PathParam("id") int id, @QueryParam("type") String type) {

        List<Topic> topics = this.topicService.getWeakTopicsOfType(id, type);

        if (topics != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(topics)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @POST
    public Response createdTopic(Topic topic) {

        String name = topic.getName();
        int school = topic.getSchool();

        int topicCreated = this.topicService.AddNewTopic(name, school);

        Boolean success = Boolean.FALSE;

        if( topicCreated == 1 ) {
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
    public Response deleteTopic(@PathParam("id") int id) {

        int topicDeleted = this.topicService.deleteTopic(id);
        Boolean success = Boolean.FALSE;

        if( topicDeleted == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @Path("/{id}")
    public Response updateTopic(@PathParam("id") int id, @QueryParam("school") String name) {

        int topicUpdated = this.topicService.updateTopic(name, id);
        Boolean success = Boolean.FALSE;

        if( topicUpdated == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.CREATED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }


}
