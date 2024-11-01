FROM gradle:8.10.2-jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src/main ./src/main

RUN gradle clean build

FROM openjdk:17

#RUN addgroup -S app-group && adduser -S app-user -G app-group

#USER app-user

WORKDIR /app

COPY --from=build /app/build/libs/product-service-0.0.1-SNAPSHOT.jar product-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","product-service.jar"]