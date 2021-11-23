# Build stage
FROM gradle:7.3.0-jdk11-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

MAINTAINER Richard Martikan (ric.martikan@gmail.com)

# Package stage
FROM openjdk:11-jre-slim

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /usr/local/lib/accountManagementApi.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/usr/local/lib/accountManagementApi.jar"]