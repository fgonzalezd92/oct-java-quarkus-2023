package com.herbalife.publisher;

import com.herbalife.dto.CalculatorDto;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class CalculatorPublisher {
    @Inject
    @Channel("calculator-channel")
    Emitter<CalculatorDto> calculatorDtoEmitter;

    private static final String SQUARE = "square";
    private static final String INCREMENT = "increment";
    private static final String CUBE = "cube";
    private static final String DECREMENT = "decrement";
    private static final String DOUBLEIT = "doubleIt";

    @Scheduled(every = "5s")
    public void publishSquareMessage() {
        publish(SQUARE);
    }

    @Scheduled(every = "5s")
    public void publishCubeMessage() {
        publish(CUBE);
    }
    @Scheduled(every = "5s")
    public void publishDoubleItMessage() {
        publish(DOUBLEIT);
    }

    @Scheduled(every = "5s")
    public void publishDecrementMessage() {
        publish(DECREMENT);
    }

    @Scheduled(every = "5s")
    public void publishIncrementMessage() {
        publish(INCREMENT);
    }

    private void publish(String key) {
        int number = (int)(Math.random() * 1000);
        CalculatorDto calculatorDto = new CalculatorDto(number);
        Message<CalculatorDto> message = Message.of(calculatorDto);
        OutgoingKafkaRecordMetadata<Object> metadata = OutgoingKafkaRecordMetadata.builder()
                .withKey(key)
                .build();
        calculatorDtoEmitter.send(message.addMetadata(metadata));
        System.out.println("Published " + key + " message with number " + number);
    }

}
