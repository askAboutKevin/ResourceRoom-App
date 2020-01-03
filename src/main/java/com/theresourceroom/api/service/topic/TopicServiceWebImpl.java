package com.theresourceroom.api.service.topic;

import com.theresourceroom.api.dal.dao.TopicDAO;
import com.theresourceroom.api.models.Topic;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class TopicServiceWebImpl implements TopicService {

    private TopicDAO topicDAO;

    public TopicServiceWebImpl(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public List<Topic> getTopicsFromSchool(int school) {
        if(school < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return topicDAO.getTopicsFromSchool(school);
    }

    @Override
    public List<Topic> getWeakTopicsOfType(int _id, String type) {
        type = type.strip().toUpperCase();
        if(_id < 1 || !type.matches("TEACHER") || !type.matches("ADMIN") || !type.matches("STUDENT") || !type.matches("PARENT")) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return topicDAO.getWeakTopicsOfType(_id, type);
    }

    @Override
    public int AddNewTopic(String name, int school) {
        if(school < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return topicDAO.AddNewTopic(name, school);
    }

    @Override
    public int deleteTopic(int topic_id) {
        if(topic_id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return topicDAO.deleteTopic(topic_id);
    }

    @Override
    public int updateTopic(String name, int topic_id) {
        if(topic_id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return topicDAO.updateTopic(name, topic_id);
    }
}
