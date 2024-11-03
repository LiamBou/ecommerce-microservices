# Stage 1: Build the application JAR
FROM gradle:8.10.2-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy Gradle configuration and source files
COPY build.gradle settings.gradle ./
COPY src ./src

# Build the project, skipping tests if you want faster build times
RUN gradle clean build -x test

# Stage 2: Create the final image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar product-service.jar

# Expose the application port
EXPOSE 8083

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "product-service.jar"]
