package com.mm.kafka_example.components;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

@Component
public class ConsumerComponentImpl implements ConsumerComponent {

    private static final Logger logger = Logger.getLogger(ConsumerComponentImpl.class.getName());

    private boolean connectionEstablished = false;
    private Consumer<String, Serializable> consumer;

    public void connect() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.mm.kafka_example.common.MessagePayloadDeserializer");
        consumer = new KafkaConsumer<String, Serializable>(props);
        connectionEstablished = true;
    }

    public void disconnect() {
        consumer.close();
        connectionEstablished = false;
    }

    public void unsubscribe() {
        if(isConnectionEstablished()) {
            consumer.unsubscribe();
        }
    }

    public Set<String> subscription() {
        if(!isConnectionEstablished()) {
            throw new IllegalStateException("Kafka consumer is not connected.");
        }
        return consumer.subscription();
    }

    @Scheduled(fixedDelay = 1000)
    public void poll() {
        ConsumerRecords<String, Serializable> consumerRecords = consumer.poll(1000);
        int countOfMsgs = consumerRecords.count();
        logger.info("Count of messages:" + countOfMsgs);
        if(countOfMsgs>0) {
            Iterator<ConsumerRecord<String, Serializable>> iterator = consumerRecords.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next().value());
            }
        }
    }

    public void subscribe(String topic) {
        if(StringUtils.isBlank(topic)) {
            throw new IllegalArgumentException("Topic can not be blank.");
        }
        subscribe(Arrays.asList(topic));
    }

    public boolean isConnectionEstablished() {
        return connectionEstablished;
    }

    public void subscribe(Collection<String> topics) {
        if(topics==null || topics.isEmpty()) {
            throw new IllegalArgumentException("Topics list is empty.");
        }
        if(!isConnectionEstablished()) {
            throw new IllegalStateException("Kafka consumer is not connected.");
        }
        Set<String> existingSubscriptions = consumer.subscription();
        topics.removeAll(existingSubscriptions);
        Set<String> newSubscriptions = new HashSet<String>(topics);
        consumer.subscribe(newSubscriptions);
    }
}

