package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CalcConsumer {
    @Incoming("calc-channel")
    public void consumeCalcMessage(CalcDto calcDto) {
        if(calcDto.number() < 0) {
            throw new RuntimeException("**** Number cannot be negative: " + calcDto.number());
        }
        System.out.println("**** Received: " + calcDto.number());
    }
}
