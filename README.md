# Call for tenders Web Service
This is the code to run a Web Service for creating Call for tenders 
submission on frequency reserves containment and restauration.


## Pre-requisites
Please have a JVM of Java 17 Temurin installed onto your machine prior to running the code.
If you don't have it yet, you can download the correct version for your OS from 
[Adoptium Website](https://adoptium.net/temurin/releases/).

When running the "prod" profile, please ensure you have a PostgreSQL service up and running on your
computer, on the default port 5432.


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
#### Missing features compared to Target App
In this demo version, all RTE market information are not persisted (transient purely).
Also, no authentication is needed since User management is supposed to be handled by the User Service, and delivered by 
the Gateway. The Swagger page, now available directly on this app without authentication, will have to be moved to the 
Gateway and concatenated to other App Swaggers to be accessed authenticated as a single common Swagger page (content would then
depend on the user ROLE). Until the fact, @Secured annotation on the endpoints of the controllers to restrict its use 
to a certain list of ROLEs are commented out.


#### Data Storage
As the Demo is expected to run with a simple JVM, H2 database is used for the demo profile "devdd". 
For the "prod" profile, a local PostGreSQL instance is required (version>=15.2).

#### Class Diagram of the Demo Version
Here comes the Demo class diagram:
![alt text](https://github.com/lincotaa/call/blob/feature/call_for_tenders/src/main/resources/images/call_service_classes_diagram.png?raw=true)

#### Simple repartition key for Demo
Min power agreement is what is to be given to I and II reserves at least. Max is the max power to be sold to those reserves for
the group of production. In case of pp1 or pp2 to 'true', then I and II are to receive the maximum power agreed if
possible. If not, they will only be garanted to receive the bare min power agreed with RTE. RR market will be served to 
the rest.

For the bottom price to sell the power for in the Call Offers, it is considered to be the max value of SPOT and 
productionCost during this step. 

In the future, a parametrizable margin (cf properties file) might be applied (ex : +10% on the max value).

### Target
#### Global architecture
At least, 4 other services are needed: 
- The Gateway (registry - only service to be accessible from the internet), 
- The User Service (or User, Role and Access Rights management),
- The (Power Production) Forecast Service for all the Groups of Production managed by Agregio,
- The RTE Service to retrieve the PP1/PP2 signals and Wholesale Market information the day before the fact from 
the [RTE DATA API](https://data.rte-france.com/).

![alt text](https://github.com/lincotaa/call/blob/feature/call_for_tenders/src/main/resources/images/global_architecture.png?raw=true)


#### Sequence diagram
Hereafter, the sequence diagram of the processes to take place for the call of tenders generation and access:

![alt text](https://github.com/lincotaa/call/blob/feature/call_for_tenders/src/main/resources/images/sequence_diagram.png?raw=true)

#### Repartition key for power offering optimization
Not specified yet...


#### Classes diagram of RTE Service
This is a first version of the classed diagram relative to the RTE Service:

![alt text](https://github.com/lincotaa/call/blob/feature/call_for_tenders/src/main/resources/images/rte_service_classes_diagram.png?raw=true)

