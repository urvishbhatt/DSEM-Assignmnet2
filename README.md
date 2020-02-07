HelloWorld for App Engine Standard (Java 8)
===================================================================================================================

Election System used Google App Engine as a hosting service and database management system service. 

Election system divide in three-part 

Election system divide in three-part 
    1. Backend 
    2. Voting system 
    3. Election Result 

1. Backend contains 4 functionality 
Date:- starting and ending date of Election 
Candidate Adding:- Add candidate with name, surname, and Faculty
Email Adding:- Import eligible votes voting id
Email reminder:- a reminder to all voters

Only owner of this project can access Backend

2. Voting System
Imported Email id by admin can access this page. the voter can vote their using their token. a token is nothing but their auto-generated  Id. voters even don't have to write by themself.
When Voters assign their vote, System Save Voters id with voted candidates id to the database.
Only once a vote is assigned by voter he or she no longer able to access that page

3. Result 
The result page shows the result of voting. it's not authenticated so anyone can access it.

//---------------------------------------------------------------------------------------------//
This sample demonstrates how to deploy an application on Google App Engine.

See the [Google App Engine standard environment documentation][ae-docs] for more
detailed instructions.

[ae-docs]: https://cloud.google.com/appengine/docs/java/


* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Gradle](https://gradle.org/gradle-download/) (optional)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (aka gcloud)

## Setup

• Download and initialize the [Cloud SDK](https://cloud.google.com/sdk/)

    gcloud init

* Create an App Engine app within the current Google Cloud Project

    gcloud app create

## Maven
### Running locally

    mvn appengine:run

To use vist: http://localhost:8080/

### Deploying

    mvn appengine:deploy

To use vist:  https://YOUR-PROJECT-ID.appspot.com

## Gradle
### Running locally

    gradle appengineRun

If you do not have gradle installed, you can run using `./gradlew appengineRun`.

To use vist: http://localhost:8080/

### Deploying

    gradle appengineDeploy

If you do not have gradle installed, you can deploy using `./gradlew appengineDeploy`.

To use vist:  https://YOUR-PROJECT-ID.appspot.com

## Testing

    mvn verify

 or

    gradle test

As you add / modify the source code (`src/main/java/...`) it's very useful to add [unit testing](https://cloud.google.com/appengine/docs/java/tools/localunittesting)
to (`src/main/test/...`).  The following resources are quite useful:

* [Junit4](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)
* [Truth](http://google.github.io/truth/)


Find port Number :- netstat -ano | findstr :yourPortNumber
Kill with Port Number :- taskkill /PID typeyourPIDhere /F