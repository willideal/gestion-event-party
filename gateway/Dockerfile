#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_IMAGE
#WORKDIR /tmp/
#COPY pom.xml /tmp/pom.xml
#COPY src /tmp/src
#RUN ["mvn", "package"]


FROM openjdk:8-jre-alpine
COPY target/gateway-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8095


CMD ["java", "-Xmx200m", "-jar", "/app/gateway-0.0.1-SNAPSHOT.jar"]
