package com.theresourceroom.api.service.topic;

import com.theresourceroom.api.models.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getTopicsFromSchool(int school);

    Topic getWeakTopicsOfType(int _id, String type);

    int AddNewTopic(String name, int school);

    int deleteTopic(int topic_id);

    int updateTopic(String name, int topic_id);
}
