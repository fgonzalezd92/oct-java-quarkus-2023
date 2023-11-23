# Install JDK 17
FROM openjdk:17-alpine
# Copy the jar file
COPY build/day13-container-db-1.0.0-runner.jar app.jar

ENV GREETINGS="Hello from Dockerfile"
ENV GOODBYE="Goodbye from Dockerfile"

# Run the jar file
ENTRYPOINT ["java", "-jar", "-Dwelcome.message=${GREETINGS}", "/app.jar"]
