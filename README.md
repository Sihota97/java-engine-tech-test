# Core Gaming Game Logic Developer - Tech Test 

## The Test 

Purpose of this test is to create a simple game logic based on detailed specification and prove it's correct.

We realise everyone has different levels of skill and experience when it comes to development, so we have split the test into 3 sections. If you do not have the knowledge to complete them all then that's ok, we just want to see how you approach the problem and get a feel for how you code. 

As a hint have a look for 'Slot Machine' in the search engine of your choice. If you have any questions, please feel free to get in touch with your point of contact. We’ll get back to you as soon as possible. 

### Requirements
 * Git
 * Java 8 (JDK 8).
 * Maven 3.5.4.
 * Ability to view *.xlsx files.

## Review Criteria 

We will be looking for: 

* Correct implementation of given tasks.
* Modular/ Code organization. 
* Generic code where appropriate. 
* Clarity/ Self documenting, comments.
* Unit tests usage.
* Data correctness.
* Code formatting.
* Exceptions and error handling. 
* Cool, exciting solutions/ideas.

## Submission 

Replace the contents of this README.md with: 

A covering note explaining the technology choices you have made. 

Any instructions required to run your solution. 

Email as an attachment or a link the git bundled repository showing your commit history with all your commits on the master branch: 

```
git bundle create <anything>.bundle --all --branches 
```

### Setup and Details
 * Grab repository contents either via zip or git pull.
 * If working with compressed file, unpack file contents to folder of your choice.
 * In command line move to 'test' folder.
 * To build all modules execute:
```
mvn clean install -DskipTests
```
 * To run a http web server execute: 
```
java -jar Server\target\Server-1.0.1-jar-with-dependencies.jar
```
 * To run tests, in another command line window, execute: 
```
mvn test
```
 * Watch the output for any test fail/ pass information.
 * All data tables can be found in 'profile.xlsx' file under titled tabs.

### Required Tasks 

* Find and familiarize yourself with Server, Client and unit tests source files. Hint: The 'test' is structured as a simple client - server application. The server is responsible for performing logic and generating responses to client requests. The client sends requests and contains a test suite which is used to validate given behaviours.
* Have default project up and running. Both defined 'helloRequest*' tests must succeed. Hint: That should be done without any changes to the code by following 'Setup and Details' steps.
* Add a 'table' client request and implement server response which will return randomly chosen 'Value' from 'BasicWeightTable' based on the percentage 'Chance'. Hint: For this task ignore data in '99% confidence level' column.
* Implement tests that would run multiple 'table' requests and check aggregated responses against the expected occurences defined in 'BasicWeightTable'. Hint: How many times do you think 'Value' 3 will be retuned from the server? You can use '100k runs error margin' value to compare the results with 99% confidence. 
* Improve communication protocol to use either Json or XML. Update your tests accordingly.

#### Desirable Tasks 

* Add a 'spin' request which will return a 3x3 matrix. Use 'Symbols' and 'Reels' tables. For every matrix draw one random position from each of the reels to stop at. 
* For each result where middle row of your matrix satisfies one of the rules defined in 'WinRules' return the associated value.
* Implement tests that would run multiple 'table' requests and check aggregated responses against the 'expected chance' defined in 'WinRules' table. Hint: use '100k runs error margin' value to compare the results with 99% confidence. 

#### Optional Tasks 

* Add 'Return To Player' value in percentage for both 'table' and 'spin'. Assuming each request cost '3.5'. We will not provide you with table to compare your results this time. Hint: To find the requested result compare total spent on initiating requests and total returned in responses. You can use 1% margin error for RTP comparison. 
* For extra fun, can you change the server - client to work with WebSockets?

