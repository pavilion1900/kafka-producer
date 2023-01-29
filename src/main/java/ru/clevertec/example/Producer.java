package ru.clevertec.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Slf4j
public class Producer {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try (KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 10_000; i++) {
                ProducerRecord<Integer, String> record = new ProducerRecord<>("demo-topic3", i % 3, "" + i);
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        log.info("received new metadata, topic " + metadata.topic() + " partition " +
                                metadata.partition() + " offsets " + metadata.offset() + " time " + metadata.timestamp());
                    } else {
                        log.error("error producing", exception);
                    }
                });
                Thread.sleep(1000);
            }
            producer.flush();
        }
    }
}
