package com.theresourceroom.api.service.topic;

import com.theresourceroom.api.dal.mapper.TopicMapper;
import com.theresourceroom.api.models.Topic;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TopicService {

    List<Topic> getTopicsFromSchool(int school);

    Topic getWeakTopicsOfType(int _id, String type);

    int AddNewTopic(String name, int school);

    int deleteTopic(int topic_id);

    int updateTopic(String name, int topic_id);
}
