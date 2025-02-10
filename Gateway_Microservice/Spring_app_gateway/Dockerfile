# Use a base image for Java applications
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Define the argument for the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the container
COPY ${JAR_FILE} app.jar

# Expose the port used by the gateway
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
