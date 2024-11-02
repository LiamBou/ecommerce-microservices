FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY eureka-server/pom.xml ./
COPY eureka-server/src/main ./src/main

RUN mvn clean install -DskipTests=true


FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "eureka-server.jar"]