package com.theresourceroom.api;

import com.theresourceroom.api.service.article.ArticleService;
import com.theresourceroom.api.service.article.ArticleServiceWebImpl;
import com.theresourceroom.api.service.license.LicenseService;
import com.theresourceroom.api.service.license.LicenseServiceWebImpl;
import com.theresourceroom.api.service.message.MessageService;
import com.theresourceroom.api.service.message.MessageServiceImpl;
import com.theresourceroom.api.service.rating.RatingService;
import com.theresourceroom.api.service.rating.RatingServiceWebImpl;
import com.theresourceroom.api.service.school.SchoolService;
import com.theresourceroom.api.service.school.SchoolServiceWebImpl;
import com.theresourceroom.api.service.session.SessionService;
import com.theresourceroom.api.service.session.SessionServiceWebImpl;
import com.theresourceroom.api.service.student.StudentService;
import com.theresourceroom.api.service.student.StudentServiceWebImpl;
import com.theresourceroom.api.service.topic.TopicService;
import com.theresourceroom.api.service.topic.TopicServiceWebImpl;
import com.theresourceroom.api.service.tutorial.TutorialService;
import com.theresourceroom.api.service.tutorial.TutorialServiceWebImpl;
import com.theresourceroom.api.service.user.UserService;
import com.theresourceroom.api.service.user.UserServiceWebImpl;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.theresourceroom.api.dal.dao.*;
import com.theresourceroom.api.resource.*;
import org.jdbi.v3.core.Jdbi;


// Main entry point for the application
public class TheResourceRoomApp extends Application<Configuration> {
	
	public static void main(String[] args) throws Exception {
        new TheResourceRoomApp().run(args);
    }
	
    @Override
    public String getName() {
        return "The Resource Room";
    }


    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }
    
    
    // This method is run via the main method to get the server up and running and register objects
    @Override
    public void run(Configuration configuration, Environment environment) {

	    // Create database connection object
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        // Initialize DAOs for all tables
        final ArticleDAO articleDAO = jdbi.onDemand(ArticleDAO.class);
        final LicenseDAO licenseDAO = jdbi.onDemand(LicenseDAO.class);
        final RatingDAO ratingDAO = jdbi.onDemand(RatingDAO.class);
        final SchoolDAO schoolDAO = jdbi.onDemand(SchoolDAO.class);
        final SessionDAO sessionDAO = jdbi.onDemand(SessionDAO.class);
        final StudentDAO studentDAO = jdbi.onDemand(StudentDAO.class);
        final TopicDAO topicDAO = jdbi.onDemand(TopicDAO.class);
        final TutorialDAO tutorialDAO = jdbi.onDemand(TutorialDAO.class);
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final MessageDAO messageDAO = jdbi.onDemand(MessageDAO.class);

        // Initialize the services for the api
        final ArticleService articleService = new ArticleServiceWebImpl(articleDAO);
        final LicenseService licenseService = new LicenseServiceWebImpl(licenseDAO);
        final RatingService ratingService = new RatingServiceWebImpl(ratingDAO);
        final SchoolService schoolService = new SchoolServiceWebImpl(schoolDAO);
        final SessionService sessionService = new SessionServiceWebImpl(sessionDAO);
        final StudentService studentService = new StudentServiceWebImpl(studentDAO);
        final TopicService topicService = new TopicServiceWebImpl(topicDAO);
        final TutorialService tutorialService = new TutorialServiceWebImpl(tutorialDAO);
        final UserService userService = new UserServiceWebImpl(userDAO);
        final MessageService messageService = new MessageServiceImpl(messageDAO);

        // Register the resources for the endpoints
        environment.jersey().register(new ArticleResource(articleService));
        environment.jersey().register(new LicenseResource(licenseService));
        environment.jersey().register(new RatingResource(ratingService));
        environment.jersey().register(new SchoolResource(schoolService));
        environment.jersey().register(new SessionResource(sessionService));
        environment.jersey().register(new StudentResource(studentService));
        environment.jersey().register(new TopicResource(topicService));
        environment.jersey().register(new TutorialResource(tutorialService));
        environment.jersey().register(new UserResource(userService));
        environment.jersey().register(new MessageResource(messageService));
    }

}
