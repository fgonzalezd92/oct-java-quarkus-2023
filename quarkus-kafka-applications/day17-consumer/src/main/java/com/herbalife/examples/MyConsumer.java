package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class MyConsumer {

    @Incoming("my-test-channel")
    public void consumeMessageFromTest(String message) {
        System.out.println("****** Message received from test channel: " + message);
    }

    @Incoming("hl-channel")
    public void consumeMessageFromHL(String message) {
        System.out.println("===== Message received from HL channel: " + message);
    }
}
