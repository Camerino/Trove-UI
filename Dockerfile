FROM maven:3.6.0-jdk-11-slim AS build
RUN apt-get update
COPY pom.xml ./pom.xml
COPY testng.xml ./testng.xml
RUN ["mvn", "dependency:resolve"]

COPY src ./src
ENTRYPOINT ["mvn", "test"]