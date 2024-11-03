FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY event-models/build.gradle ./
COPY event-models/src/main ./src/main

RUN gradle clean build -x test

COPY order-service/build.gradle settings.gradle ./
COPY order-service/src/main ./src/main

RUN gradle clean build -x test

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/build/libs/*.jar order-service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","order-service.jar"]