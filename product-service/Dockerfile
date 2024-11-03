FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src/main ./src/main

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/build/libs/product-service-0.0.1-SNAPSHOT.jar product-service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","product-service.jar"]