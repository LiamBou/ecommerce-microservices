FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app


COPY test-serv/build.gradle settings.gradle ./
COPY test-serv/src/main ./src/main

RUN gradle clean build -x test

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/build/libs/*.jar test-serv.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","test-serv.jar"]