package com.herbalife;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.List;
import java.util.stream.IntStream;

@Path("/publisher")
public class PublisherResource {
    @Inject
    @Channel("day18-channel")
    Emitter<String> emitter;


    @GET
    @Path("/bulk/{count}")
    public String publishMessages(@PathParam("count") int count) {
        IntStream
                .range(0, count)
                .forEach(number -> {
                    emitter.send(Message.of("Message: " + number));
                });
        return count + " messages published successfully";
    }

    @GET
    @Path("/{key}/{value}")
    public String publishMessage(@PathParam("key") String key, @PathParam("value") String value) {
        Message<String> message = Message.of(value);
        List<RecordHeader> headers = List.of(
                new RecordHeader("trace_id", "trace39924974".getBytes()),
                new RecordHeader("module-id", "herbalife-vendor-module".getBytes())
        );
        OutgoingKafkaRecordMetadata<Object> metadata = OutgoingKafkaRecordMetadata.builder()
                .withKey(key)
                .withHeaders(headers)
                .build();
        emitter.send(message.addMetadata(metadata));
        return "Message published successfully";

    }
}
