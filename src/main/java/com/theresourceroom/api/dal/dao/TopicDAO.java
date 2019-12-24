package com.theresourceroom.api.dal.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Topic;

public interface TopicDAO {
	
	List<Topic> getTopicsFromSchool(int school);
	
	Topic getWeakTopicsOfParent(int parent_id);
	
	Topic getWeakTopicsOfStudent(int student_id);
	
	int AddNewTopic(String name, int school);
	
	int deleteTopic(int topic_id, int school_id);
	
	int updateTopic(int topic_id, int school_id, String name);

}
