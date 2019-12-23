# The Resource Room - Backend

A mobile application that gives parents a resource they can use to empower themselves and foster good communication with their child. This repo will be used entirely for the backend infrastructure of the application. This RESTful API will provide services to the UIs that fetch data from it.

## Getting started

Pull down the repository with `Git` then run `make tools` to see what else you are missing to run the application.
```
git clone https://github.com/askAboutKevin/TheResourceRoom.git
```
### Drop Wizard

This applications main dependency in the `pom.xml` file is the `dropwizard-core` dependency. 
[DropWizard](https://www.dropwizard.io/1.3.12/docs/index.html) is a set of Java libraries that make it easy to build and develop RESTful web services. 
With DropWizard you get a ton of production ready features for free out-of-the-box. 
Stuff such as:
* An embadded HTTP web server (Jetty)
* Jersey for REST
* Jackson for JSON
* Metrics
* Logging
* Health Check
* Administrator Port

 ### Local Development
 Requirements for building this project on a terminal:
* Java (Minimum Version Java 1.8)
* Maven (Minimum Version Apache Maven 3.X.X)
* Run `make tools` to see if you are missing any tools required for running the applications

Requirements for running this project are:
* MySQL running on it's default port 3306

### Running the application

After running `make tools` and installing the necessary tools, run `make server` to start the API running on port 8080. See Makefile for other targets.

### Stopping the application

Use CTRL+C in the terminal to stop the server at any time

### Logs are stored in the directly to `/path/to/target/logs/` 


#### Developed By Kevin Dowdy - 2019

