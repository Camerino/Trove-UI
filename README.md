#Trove UI Test Framework

This is a Java-Selenium based UI test Framework for Trove website. It is desigened with Page Object Model design pattern.

## Installation and Test Run

### Option 1

Install Java and Maven. add java and Maven to system path

Test Run:

go to project directory with command line and run

mvn clean test

### Option 2
(there is a small bug in this option, will be resolved later)

Install Docker

Test Run:

go to project directory with command line and run

docker build -t trove . (include dot)
docker run -it trove
