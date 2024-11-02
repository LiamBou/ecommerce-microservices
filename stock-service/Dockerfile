FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy and build shared library
COPY event-models/pom.xml ./event-models/
COPY event-models/src ./event-models/src

RUN mvn -f ./event-models/pom.xml clean install -DskipTests=true

COPY stock-service/pom.xml ./
COPY stock-service/src/main ./src/main

RUN mvn clean install -DskipTests=true


FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/*.jar stock-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "stock-service.jar"]