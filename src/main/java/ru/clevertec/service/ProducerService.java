//package ru.clevertec.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class ProducerService {
//
//    private final KafkaTemplate<String, Message> kafkaTemplate;
//
//    public void produce(Message message){
//        log.info("Producing thr Message " + message);
//        kafkaTemplate.send("demo-topic3", message);
//    }
//}
