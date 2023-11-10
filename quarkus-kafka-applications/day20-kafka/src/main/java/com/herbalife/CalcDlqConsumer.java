package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CalcDlqConsumer {
    @Incoming("calc-dlq-channel")
    public void consumeCalcMessage(CalcDto calcDto) {
        System.out.println("================== Received from DLQ: " + calcDto.number());
    }
}
