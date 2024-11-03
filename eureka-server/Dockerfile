FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY eureka-server/build.gradle settings.gradle ./
COPY eureka-server/src/main ./src/main

RUN gradle clean build -x test

FROM openjdk:17

#RUN addgroup -S app-group && adduser -S app-user -G app-group

#USER app-user

WORKDIR /app

COPY --from=build /app/build/libs/*.jar eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","eureka-server.jar"]