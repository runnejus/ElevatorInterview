# ElevatorInterview

This code provides a simulation of the behavior of an elevator.

    ├── src                   # Contains source code and unit tests
    ├── docs                  # Additional architecture documents
    ├── cicd                  # Contains jenkinsfile for potentially building and deploying code
    ├── pom.xml               # Using maven, define java dependencies, leveraging spring boot to bring in junit libraries
    └── README.md

This application is written with Java 17 and leveraging maven to handle dependencies.
Junit5 is brought in with spring boot version 3.4.3.  The unit tests that I currently have in place cover 81% of the code in the main folder.
I have built a skelton of what the jenkinsfile would look like for building the jar file that could be potentially executed on the desired 

![Class Diagram](https://github.com/runnejus/ElevatorInterview/blob/main/docs/elevator.drawio.png?raw=true)

Have the Controller object take in requests from a user so there is a buffer between the service and the user.  I had originally created two different input objects one for controller and one for the service but merged them into a single objects since at this time I couldn't really differeniate them from being two different objects at this time.  Allows for translation in case anything were to go wrong between the different logical layers.

Leveraged Interfaces in a bunch of different places to allow for defining clear contracts between the different class and then each class would be responsible for its independent logic versus trying to put multiple responsibilities in the single file.
There is an opportunitiy to clean up these interfaces more, there should really be more clear communication between the different layers so its clear what occurs between the different object as well as more exception handling to handle unexpected values from the users.

