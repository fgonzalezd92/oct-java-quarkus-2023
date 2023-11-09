package com.herbalife.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbalife.dto.CalculatorDto;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CalculatorConsumer {

    private static final String SQUARE = "square";
    private static final String INCREMENT = "increment";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Incoming("calculator-channel")
    public void consumeCalculatorMessage(ConsumerRecord<String, String> consumerRecord) {
        String message = consumerRecord.value();
        //extract the number from the message; WILL CHANGE IT TO JSON DESERIALIZATION LATER
        int number = Integer.parseInt(message.split(":")[1].split("}")[0].trim());
        CalculatorDto calculatorDto = new CalculatorDto(number);
        String key = consumerRecord.key();
        String result = switch (key) {
            case SQUARE -> {
                int square = calculatorDto.getNumber() * calculatorDto.getNumber();
                yield "Square of " + calculatorDto.getNumber() + " is " + square;
            }
            case INCREMENT -> {
                int increment = calculatorDto.getNumber() + 1;
                yield "Increment of " + calculatorDto.getNumber() + " is " + increment;
            }
            default -> {
                yield "Received message with unknown key " + key;
            }
        };
        System.out.println(result + " from partition " + consumerRecord.partition());
    }


//    @Incoming("calculator-channel")
//    public void consumeCalculatorMessage(ConsumerRecord<String, CalculatorDto> consumerRecord) {
//        CalculatorDto calculatorDto = consumerRecord.value();
//        String key = consumerRecord.key();
//        String result = switch (key) {
//            case SQUARE -> {
//                int square = calculatorDto.number() * calculatorDto.number();
//                yield "Square of " + calculatorDto.number() + " is " + square;
//            }
//            case INCREMENT -> {
//                int increment = calculatorDto.number() + 1;
//                yield "Increment of " + calculatorDto.number() + " is " + increment;
//            }
//            default -> throw new IllegalStateException("Unexpected value: " + key);
//        };
//        System.out.println(result);
//    }
}

