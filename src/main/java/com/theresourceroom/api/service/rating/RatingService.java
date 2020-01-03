package com.theresourceroom.api.service.rating;

import com.theresourceroom.api.models.Rating;
import java.util.List;

public interface RatingService {

    List<Rating> getAllRatingsOfParent(int id);

    Rating getRatingOfParentInTopic(int id, int topic_id);

    List<Rating> getAllRatingsOfStudent(int id);

    Rating getRatingOfStudentInTopic(int id, int topic_id);

    List<Rating> getRatingOfArticle(int id);

    Rating getRatingInTopic(int rated_obj_id, String type);

    int rateUserInTopic(String type, int rated_obj_id, int rate);

    int updateRating(int rate, int id);

    boolean deleteRating(int id);
}
