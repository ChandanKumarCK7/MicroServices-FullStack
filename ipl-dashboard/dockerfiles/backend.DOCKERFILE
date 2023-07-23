





# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file to the container
COPY ../target/ipl-dashboard-0.0.1-SNAPSHOT.jar .

# Expose port 8080
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "ipl-dashboard-0.0.1-SNAPSHOT.jar"]
