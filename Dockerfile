# Use a suitable base image. For Spring Boot, OpenJDK is common.
FROM eclipse-temurin:21

# Copy the built JAR file into the image.
# The JAR file name will likely be different. Adjust accordingly.
# The build/libs/ folder is the standard location for the JAR created by Gradle
COPY build/libs/*.jar /app.jar

# Expose the port your Spring Boot app runs on (usually 8080).
EXPOSE 8080

# Specify the command to run when the container starts.
# -jar is used to execute the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]

# For a more optimized image size, consider using a multi-stage build:
#
# # Stage 1: Build the application
# FROM gradle:8.12-jdk21 AS build # Or appropriate gradle version
# COPY. /home/gradle/src
# WORKDIR /home/gradle/src
# RUN gradle build -x test

# # Stage 2: Create the final image
# FROM openjdk:21-jdk-slim
# COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar # Copy all jars
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/app.jar"]