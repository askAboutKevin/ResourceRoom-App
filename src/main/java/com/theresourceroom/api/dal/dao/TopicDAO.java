package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.TopicMapper;
import com.theresourceroom.api.models.Topic;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TopicDAO {

	@SqlQuery("SELECT id, name, school FROM Topic WHERE school = ?")
	@RegisterRowMapper(TopicMapper.class)
	List<Topic> getTopicsFromSchool(int school);

	@SqlQuery("SELECT id, name, school FROM Topic WHERE id IN (SELECT topic_id FROM Rating WHERE rate <= 3 AND user_id = ? AND title = ?)")
	@RegisterRowMapper(TopicMapper.class)
	List<Topic> getWeakTopicsOfType(int _id, String type);

	@SqlUpdate("INSERT INTO Topic (name, school) VALUES (?, ?)")
	int AddNewTopic(String name, int school);

	@SqlUpdate("DELETE FROM Topic WHERE id = ?)")
	int deleteTopic(int topic_id);

	@SqlUpdate("UPDATE Topic SET name = ? WHERE id = ?")
	int updateTopic(String name, int topic_id);

}
