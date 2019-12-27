package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.TutorialMapper;
import com.theresourceroom.api.models.Tutorial;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TutorialDAO {

	@SqlQuery("SELECT id, name, school FROM Tutorial")
	@RegisterRowMapper(TutorialMapper.class)
	List<Tutorial> getAllTutorials();

	@SqlQuery("SELECT id, name, school FROM Tutorial WHERE id IN (SELECT tutorial_id FROM Tutorial_topic WHERE topic_id = ?)")
	@RegisterRowMapper(TutorialMapper.class)
	List<Tutorial> getAllTutorialsForTopic(int topic_id);

	@SqlQuery("SELECT id, name, school FROM Tutorial WHERE id = ?")
	@RegisterRowMapper(TutorialMapper.class)
	Tutorial getTutorialById(int id);

	@SqlUpdate("INSERT INTO Tutorial (name, school) VALUES (?, ?)")
	int AddTutorial(String name, String link_image, String link_story);

	@SqlUpdate("DELETE FROM Tutorial WHERE id = ?")
	int deleteTutorial(int id);

	@SqlUpdate("UPDATE Tutorial SET name = ?, link_image = ?, link_story = ? WHERE id = ?")
	int updateTutorial(String name, String link_image, String link_story, int id);
	
}
