package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.RatingMapper;
import com.theresourceroom.api.models.Rating;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface RatingDAO {

	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? AND type = 'PARENT'")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getAllRatingsOfParent(int id);

	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? AND topic_id = ? AND type = 'PARENT'")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingOfParentInTopic(int id, int topic_id);

	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? AND type = 'STUDENT' ")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getAllRatingsOfStudent(int id);

	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? AND topic_id = ? AND type = 'STUDENT'")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingOfStudentInTopic(int id, int topic_id);

	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? and type = 'ARTICLE'")
	@RegisterRowMapper(RatingMapper.class)
	List<Rating> getRatingOfArticle(int id);
	
	@SqlQuery("SELECT id, type, rated_object_id, topic_id, rate FROM Rating WHERE rated_object_id = ? AND type = ?")
	@RegisterRowMapper(RatingMapper.class)
	Rating getRatingInTopic(int rated_object_id, String type);

	@SqlUpdate("INSERT INTO Rating (type, rated_object_id, rate, topic_id) VALUES (?, ?, ?, ?)")
	int rateUserInTopic(String type, int rated_object_id, int rate, int topic_id);

	@SqlUpdate("UPDATE Rating SET rate = ? WHERE id = ?")
	int updateRating(int rate, int id);

	@SqlUpdate("DELETE FROM Rating WHERE id = ?")
	int deleteRating(int id);

}
