package com.theresourceroom.api.service.rating;

import com.theresourceroom.api.dal.dao.RatingDAO;
import com.theresourceroom.api.models.Rating;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class RatingServiceWebImpl implements RatingService {

    private RatingDAO ratingDAO;

    public RatingServiceWebImpl(RatingDAO ratingDAO) {
        this.ratingDAO = ratingDAO;
    }

    @Override
    public List<Rating> getAllRatingsOfParent(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getAllRatingsOfParent(id);
    }

    @Override
    public Rating getRatingOfParentInTopic(int id, int topic_id) {
        if(id < 1 || topic_id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getRatingOfParentInTopic(id, topic_id);
    }

    @Override
    public List<Rating> getAllRatingsOfStudent(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getAllRatingsOfStudent(id);
    }

    @Override
    public Rating getRatingOfStudentInTopic(int id, int topic_id) {
        if(id < 1 || topic_id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getRatingOfStudentInTopic(id, topic_id);
    }

    @Override
    public List<Rating> getRatingOfArticle(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getRatingOfArticle(id);
    }

    @Override
    public Rating getRatingInTopic(int rated_obj_id, String type) {
        type = type.strip().toUpperCase();
        if(rated_obj_id < 1 || !type.matches("TEACHER") || !type.matches("ADMIN") || !type.matches("STUDENT") || !type.matches("PARENT")) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.getRatingInTopic(rated_obj_id, type);
    }

    @Override
    public int rateUserInTopic(String type, int rated_obj_id, int rate) {
        type = type.strip().toUpperCase();
        if( rate < 1 || rate > 5 || rated_obj_id < 1 || !type.matches("TEACHER") || !type.matches("ADMIN") || !type.matches("STUDENT") || !type.matches("PARENT")) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.rateUserInTopic(type, rated_obj_id, rate);
    }

    @Override
    public int updateRating(int rate, int id) {
        if( rate < 1 || rate > 5 || id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.updateRating(rate, id);
    }

    @Override
    public boolean deleteRating(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ratingDAO.deleteRating(id)==1;
    }
}
