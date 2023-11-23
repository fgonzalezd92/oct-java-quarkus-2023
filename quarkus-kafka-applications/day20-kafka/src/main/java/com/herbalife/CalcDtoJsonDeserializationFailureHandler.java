package com.herbalife;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.smallrye.common.annotation.Identifier;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.DeserializationFailureHandler;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.common.header.Headers;

@ApplicationScoped
@Identifier("calc-dto-deserialization-failure-handler")
public class CalcDtoJsonDeserializationFailureHandler implements DeserializationFailureHandler<CalcDto> {
    @Override
    public CalcDto decorateDeserialization(Uni<CalcDto> deserialization, String topic, boolean isKey, String deserializer, byte[] data, Headers headers) {
        System.out.println("**** DeserializationFailureHandler: called for " + new String(data));
        //HANDLE THE FAILURE HERE
        return new CalcDto(-1);
    }
}
