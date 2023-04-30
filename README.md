# Call for tenders Web Service
This is the code to run a Web Service for creating Call for tenders 
submission on frequency reserves containment and restauration.


## Pre-requisites
Please have a JVM of Java 17 Temurin installed onto your machine prior to running the code.
If you don't have it yet, you can download the correct version for your OS from 
[Adoptium Website](https://adoptium.net/temurin/releases/).


## How to run the app
Download the last release onto your machine, then run:
```
java -jar CallApplication_0.0.1-SNAPSHOT.jar -Pdev
```
Or clone the repository locally, checkout to the "feature/call_for_tenders" branch then run:
```
mvn package
```
Before running the app locally with the previous command.


## Documentation
### Call Service V0.0.1 - Demo
In this demo version, all RTE market information are not persisted (transient purely).
Also, no authentication is needed since User management is supposed to be handled by the User Service, and delivered by 
the Gateway. Until the fact, @Secured annotation on the endpoints of the controllers are commented out.
As the Demo is expected to run with a simple JVM, H2 database is used for the demo profile "dev". 
For the "prod" profile, a local PostGreSQL instance is required (version 10+).

Demo-version 0.0.1 classes diagram:
https://github.com/lincotaa/call/tree/main/src/main/resources/images/call_service_classes_diagram.png?raw=true)

### Target
#### Global architecture
At least, 4 other services are needed: 
- The Gateway (registry - only service to be accessible from the internet), 
- The User Service (or User, Role and Access Rights management),
- The (Power Production) Forecast Service for all the Groups of Production managed by Agregio,
- The RTE Service to retrieve the PP1/PP2 signals and Wholesale Market information the day before the fact from 
the [RTE DATA API](https://data.rte-france.com/).

![alt text](https://github.com/lincotaa/call/tree/main/src/main/resources/images/global_architecture.png?raw=true)
#### Sequence diagram
![alt text](https://github.com/lincotaa/call/tree/main/src/main/resources/images/sequence_diagram.png?raw=true)

![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)

``java -jar CallApplication.jar``