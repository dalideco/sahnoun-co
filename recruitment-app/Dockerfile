# Use the official Maven image
FROM maven:3.8-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file
COPY ./recruitment-app/pom.xml .

# Copy the entire Spring Boot project
COPY ./recruitment-app/src ./src

# Build the application
RUN mvn package -DskipTests

# Final image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/target/recruitment-app.jar .

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "recruitment-app.jar"]
