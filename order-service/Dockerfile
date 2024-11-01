FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src/main ./src/main

RUN gradle clean build

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/build/libs/order-service-0.0.1-SNAPSHOT.jar order-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","order-service.jar"]