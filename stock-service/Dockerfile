FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml ./
COPY src/main ./src/main

RUN mvn clean package

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/stock-service-0.0.1-SNAPSHOT.jar stock-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "stock-service.jar"]