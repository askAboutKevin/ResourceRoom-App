package com.theresourceroom.api.resource;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.theresourceroom.api.models.Rating;
import com.theresourceroom.api.service.rating.RatingService;

@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RatingResource {

    private RatingService ratingService;

    public RatingResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GET
    Response getAllRatingsOfUser(@QueryParam("id") int id, @QueryParam("role") String role)  {
        if(id >= 1 && !role.isEmpty()) {

        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response getRatingOfParentInTopic(int id, int topic_id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response getAllRatingsOfStudent(int id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response getRatingOfStudentInTopic(int id, int topic_id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response getRatingOfArticle(int id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response getRatingInTopic(int rated_obj_id, String type) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response rateUserInTopic(String type, int rated_obj_id, int rate) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response updateRating(int rate, int id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    Response deleteRating(int id) {

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
