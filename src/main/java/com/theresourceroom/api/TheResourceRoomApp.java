package com.theresourceroom.api;

import com.theresourceroom.api.Configuration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


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
	    // nothing added yet
    }




}
