package com.theresourceroom.api.dal.dao;

import java.util.Date;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Rating;

public interface RatingDAO {

	List<Rating> getRatingsOfPerson(int id, String title);
	
	Rating getRatingInTopic(int user_id, String title, int topic_id);
	
	int newRating(int user_id, int topic_id, String title, int rate);
	
	int updateRating(int user_id, int topic_id, String title, int rate);
	
}
