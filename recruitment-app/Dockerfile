# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file
COPY ./pom.xml .

# Copy the entire Spring Boot project
COPY ./src ./src

# Build the application
RUN ["./mvnw", "package", "-DskipTests"]

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/recruitment-app.jar"]
