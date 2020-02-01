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
    @Path("/{topic}")
    public Response getAllRatingsOfUser(@QueryParam("id") int id, @QueryParam("role") String role, @PathParam("topic") int topic)  {
        List<Rating> ratings = null;
        System.out.println(role);

        if(role.matches("parent")) {
            if(topic != 0) {
                Rating rating = ratingService.getRatingOfParentInTopic(id, topic);
                if(rating != null) {
                    return Response
                            .status(Response.Status.OK)
                            .entity(rating)
                            .build();
                }
            }
            ratings = ratingService.getAllRatingsOfParent(id);
        }
        else if(role.matches("student")) {
            if(topic != 0) {
                Rating rating = ratingService.getRatingOfStudentInTopic(id, topic);
                if(rating != null) {
                    return Response
                            .status(Response.Status.OK)
                            .entity(rating)
                            .build();
                }
            }
            ratings = ratingService.getAllRatingsOfStudent(id);
        }
        else if(role.matches("article")) {
            ratings = ratingService.getRatingOfArticle(id);
        }

        if(ratings != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(ratings)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response rateUserInTopic(Rating rating) {

        String type = rating.getType();
        int rated_obj_id = rating.getRated_object_id();
        int topic = rating.getTopic_id();
        int rate = rating.getRate();

        Boolean success = Boolean.FALSE;

        int ratedSuccess = this.ratingService.rateUserInTopic(type, rated_obj_id, rate, topic);

        if(ratedSuccess == 1) {
            success = Boolean.TRUE;
        }
        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRating(@QueryParam("rate") int rate, @PathParam("id") int id) {

        Boolean success = Boolean.FALSE;

        int ratedSuccess = this.ratingService.updateRating(rate, id);
        if(ratedSuccess == 1) {
            success = Boolean.TRUE;
        }
        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }

    @DELETE
    public Response deleteRating(int id) {

        Boolean success = this.ratingService.deleteRating(id);

        return Response
                .status(Response.Status.OK)
                .entity(success)
                .build();
    }
}
