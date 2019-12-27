package com.theresourceroom.api.service.rating;

import com.theresourceroom.api.dal.dao.RatingDAO;
import com.theresourceroom.api.models.Rating;

import java.util.List;

public class RatingServiceWebImpl implements RatingService {

    private RatingDAO ratingDAO;

    public RatingServiceWebImpl(RatingDAO ratingDAO) {
        this.ratingDAO = ratingDAO;
    }

    @Override
    public List<Rating> getAllRatingsOfParent(int id) {
        return ratingDAO.getAllRatingsOfParent(id);
    }

    @Override
    public Rating getRatingOfParentInTopic(int id, int topic_id) {
        return ratingDAO.getRatingOfParentInTopic(id, topic_id);
    }

    @Override
    public List<Rating> getAllRatingsOfStudent(int id) {
        return ratingDAO.getAllRatingsOfStudent(id);
    }

    @Override
    public Rating getRatingOfStudentInTopic(int id, int topic_id) {
        return ratingDAO.getRatingOfStudentInTopic(id, topic_id);
    }

    @Override
    public List<Rating> getRatingOfArticle(int id) {
        return ratingDAO.getRatingOfArticle(id);
    }

    @Override
    public Rating getRatingInTopic(int rated_obj_id, String type) {
        return ratingDAO.getRatingInTopic(rated_obj_id, type);
    }

    @Override
    public int rateUserInTopic(String type, int rated_obj_id, int rate) {
        return ratingDAO.rateUserInTopic(type, rated_obj_id, rate);
    }

    @Override
    public int updateRating(int rate, int id) {
        return ratingDAO.updateRating(rate, id);
    }

    @Override
    public int deleteRating(int id) {
        return ratingDAO.deleteRating(id);
    }
}
