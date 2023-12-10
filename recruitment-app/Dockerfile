# Use a base image with Maven and Java 11 installed
FROM maven:3.6-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file
COPY ./recruitment-app/pom.xml .

# Copy the entire Spring Boot project
COPY ./recruitment-app/src ./src

# Build the application
RUN mvn package -DskipTests

# Use a base image with Java 11 installed
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar .

# Set the entry point command to run the application
CMD ["java", "-jar", "recruitment-app-0.0.1-SNAPSHOT.jar"]