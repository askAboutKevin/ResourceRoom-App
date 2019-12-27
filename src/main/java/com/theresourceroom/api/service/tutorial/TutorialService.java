package com.theresourceroom.api.service.tutorial;

import com.theresourceroom.api.models.Tutorial;
import java.util.List;

public interface TutorialService {

    List<Tutorial> getAllTutorials();

    List<Tutorial> getAllTutorialsForTopic(int topic_id);

    Tutorial getTutorialById(int id);

    int AddTutorial(String name, String link_image, String link_story);

    int deleteTutorial(int id);

    int updateTutorial(String name, String link_image, String link_story, int id);


}
