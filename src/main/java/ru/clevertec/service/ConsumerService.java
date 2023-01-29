package ru.clevertec.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {

//    private final KafkaConsumer<Integer, String> consumer;

    @KafkaListener(topics = "demo-topic3", groupId = "group3")
    public void consume(Message message) {
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group3");
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest"); //earliest, none

//        try (KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(properties)) {
//            consumer.subscribe(Collections.singleton("demo-topic3"));
//            while (true) {
//                ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofMillis(100));
//                for (ConsumerRecord<Integer, String> record : records) {
//                    log.info("key " + record.key() + " value " + record.value() + " partition " +
//                            record.partition() + " offset" + record.offset());
//                }
//            }
//        }
        System.out.println("Consuming message " + message.toString());
    }
}
