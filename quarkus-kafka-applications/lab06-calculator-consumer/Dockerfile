FROM openjdk:17-jdk-alpine
COPY build/lab06-calculator-consumer-1.0-SNAPSHOT-runner.jar app.jar
ENTRYPOINT ["java","-jar","-Dkafka.bootstrap.servers=host.docker.internal:9094","-Dmp.messaging.incoming.calculator-channel.group.id=calculator-consumer-group-dev4","/app.jar"]