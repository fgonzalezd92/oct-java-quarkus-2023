package com.herbalife;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class CalcDtoJsonDeserializer extends ObjectMapperDeserializer<CalcDto> {
    public CalcDtoJsonDeserializer() {
        super(CalcDto.class);
    }
}
