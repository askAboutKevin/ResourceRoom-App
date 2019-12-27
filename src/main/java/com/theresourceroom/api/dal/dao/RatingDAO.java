package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.RatingMapper;
import com.theresourceroom.api.models.Rating;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface RatingDAO {

	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE user_id = ? AND title = 'PARENT' ")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getAllRatingsOfParent(int id, String title);

	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE user_id = ? AND rated_obj_id = ? AND title = 'PARENT' ")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingOfParentInTopic(int id, String title);

	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE user_id = ? AND title = 'STUDENT' ")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getAllRatingsOfStudent(int id);

	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE user_id = ? AND rated_obj_id = ? AND title = 'STUDENT' ")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingOfStudentInTopic(int id, int topic);

	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE rated_obj_id = ? and title = 'ARTICLE' ")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getRatingOfArticle(int id, String title);
	
	@SqlQuery("SELECT id, title, rated_obj_id, rate FROM Rating WHERE rated_obj_id = ? AND topic_id = ?")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingInTopic(int user_id, int rated_obj_id);

	@SqlUpdate("INSERT INTO Ratings (title, rated_obj_id, rate) VALUES (?, ?, ?)")
	int rateUserInTopic(String title, int rated_obj_id, int rate);

	@SqlUpdate("UPDATE Rating SET rate = ? WHERE id = ?")
	int updateRating(int rate, int id);


}
