# Core Gaming Game Logic Developer - Tech Test 

### Technology choices
 *Eclipse IDE
 *JUnit
 *Maven
 

### Setup and Details
 * Grab repository contents 
 * Save folder
 * Go to folder in command line and run:
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

 Required Tasks and Desirable Tasks Attempted. 
 
 In Desirable Tasks spreadsheet, I was getting a different value than the one in the table for '2 X ACE' I was getting 9.6 instead of 6.9. The test in the code checks if its 9.6 and passes it, however this was only done to show that the other WinRules were correct, that test should actually fail because it doesnt meet the expected chance or within the error margin.
 
 Thanks!
