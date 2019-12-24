package com.theresourceroom.api.dal.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Tutorial;

public interface TutorialDAO {

	List<Tutorial> getAllTutorials();
	
	List<Tutorial> getAllTutorialsForTopic(int topic_id);
	
	Tutorial getTutorialById(int id);
	
	int AddTutorial(String name, String link_image, String link_story);
	
	int deleteTutorial(int id);
	
	int updateTutorial(int id, String name, String link_image, String link_story);
	
}
