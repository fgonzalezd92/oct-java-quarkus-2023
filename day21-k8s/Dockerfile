FROM openjdk:17-alpine
COPY build/day21-k8s-1.0-SNAPSHOT-runner.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
