FROM openjdk:17

ADD stock-service/target/stock-api.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]