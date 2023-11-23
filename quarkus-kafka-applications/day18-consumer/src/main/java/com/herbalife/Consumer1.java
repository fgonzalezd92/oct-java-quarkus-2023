package com.herbalife;

import com.herbalife.library.MyLib;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Consumer1 {

    @Incoming("day18-channel")
    public void consumeMessages(ConsumerRecords<String, String> records) {
        System.out.println("**********START Received " + records.count() + " messages **********");
        MyLib.sayHello();
        records.forEach(record -> {
            long offset = record.offset();
            String value = record.value();
            System.out.println("======= Received Offset: %s, Value: %s"
                    .formatted(offset, value));
        });

        System.out.println("**********END " + records.count() + " messages **********");

    }


//    @Incoming("day18-channel")
//    public void consumeMessage(ConsumerRecord<String, String> record) {
//        long offset = record.offset();
//        String key = record.key();
//        String value = record.value();
//        String timestamp = record.timestamp() + "";
//        int partition = record.partition();
//        System.out.println("**** Received Offset: %s, Key: %s, Value: %s, Timestamp: %s, Partition: %s"
//                .formatted(offset, key, value, timestamp, partition));
//        record.headers().forEach(header -> {
//            System.out.println("**** Header: %s, Value: %s".formatted(header.key(), new String(header.value())));
//        });
//    }

//    @Incoming("day18-channel")
//    public void consumeMessage(String message) {
//        System.out.println("**** Received : " + message);
//    }
}
