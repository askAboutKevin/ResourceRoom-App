package com.theresourceroom.api.service.tutorial;

import com.theresourceroom.api.dal.dao.TutorialDAO;
import com.theresourceroom.api.models.Tutorial;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class TutorialServiceWebImpl implements TutorialService {

    private TutorialDAO tutorialDAO;

    public TutorialServiceWebImpl(TutorialDAO tutorialDAO) {
        this.tutorialDAO = tutorialDAO;
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialDAO.getAllTutorials();
    }

    @Override
    public List<Tutorial> getAllTutorialsForTopic(int topic_id) {
        if(topic_id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return tutorialDAO.getAllTutorialsForTopic(topic_id);
    }

    @Override
    public Tutorial getTutorialById(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return tutorialDAO.getTutorialById(id);
    }

    @Override
    public int AddTutorial(String name, String link_image, String link_story) {
        return tutorialDAO.AddTutorial(name, link_image, link_story);
    }

    @Override
    public int deleteTutorial(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return tutorialDAO.deleteTutorial(id);
    }

    @Override
    public int updateTutorial(String name, String link_image, String link_story, int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return tutorialDAO.updateTutorial(name, link_image, link_story, id);
    }
}
