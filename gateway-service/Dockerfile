FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY gateway-service/build.gradle settings.gradle ./
COPY gateway-service/src/main ./src/main

RUN gradle clean build -x test

FROM openjdk:17

#RUN addgroup -S app-group && adduser -S app-user -G app-group

#USER app-user

WORKDIR /app

COPY --from=build /app/build/libs/*.jar gateway-service.jar

EXPOSE 8084

ENTRYPOINT ["java","-jar","gateway-service.jar"]