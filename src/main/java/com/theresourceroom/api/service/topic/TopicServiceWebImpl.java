package com.theresourceroom.api.service.topic;

import com.theresourceroom.api.dal.dao.TopicDAO;
import com.theresourceroom.api.models.Topic;

import java.util.List;

public class TopicServiceWebImpl implements TopicService {

    private TopicDAO topicDAO;

    public TopicServiceWebImpl(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public List<Topic> getTopicsFromSchool(int school) {
        return topicDAO.getTopicsFromSchool(school);
    }

    @Override
    public Topic getWeakTopicsOfType(int _id, String type) {
        return topicDAO.getWeakTopicsOfType(_id, type);
    }

    @Override
    public int AddNewTopic(String name, int school) {
        return topicDAO.AddNewTopic(name, school);
    }

    @Override
    public int deleteTopic(int topic_id) {
        return topicDAO.deleteTopic(topic_id);
    }

    @Override
    public int updateTopic(String name, int topic_id) {
        return topicDAO.updateTopic(name, topic_id);
    }
}
