FROM openjdk:17-jdk-slim

# Copier le fichier JAR de l'application dans le conteneur
COPY target/stock-service.jar ./stock-service.jar

ENTRYPOINT ["java", "-jar", "application.jar"]