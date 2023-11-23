FROM openjdk:17-alpine
COPY build/weather-api-1.0-SNAPSHOT-runner.jar app.jar

EXPOSE 8080

ENV KAFKA_BOOTSTRAP_SERVERS=host.docker.internal:9094
ENV DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/training

ENTRYPOINT ["java","-jar","/app.jar"]
