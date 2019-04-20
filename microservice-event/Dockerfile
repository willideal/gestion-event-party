#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_IMAGE
#WORKDIR /tmp/
#COPY pom.xml /tmp/pom.xml
#COPY src /tmp/src
#RUN ["mvn", "package"]


FROM openjdk:8-jre-alpine
COPY target/microservice-event-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8087


CMD ["java", "-Xmx200m", "-jar", "/app/microservice-event-0.0.1-SNAPSHOT.jar"]
