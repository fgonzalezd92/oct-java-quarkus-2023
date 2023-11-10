package com.herbalife;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class CalcProducer {
    @Inject
    @Channel("calc-pub-channel")
    Emitter<CalcDto> calcDtoEmitter;

    //@Scheduled(every = "5s")
    public void produceCalcMessage() {
        CalcDto calcDto = new CalcDto((int)(Math.random() * 1000));
        calcDtoEmitter.send(calcDto);
        System.out.println("Published: " + calcDto.number());
    }
}
