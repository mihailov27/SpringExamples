package com.mm.kafka_example.components;

import com.mm.kafka_example.model.Message;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static com.mm.kafka_example.PropertyNames.KAFKA_SERVERS;

@Component
public class ProducerComponentImpl implements ProducerComponent {

    private Producer<String, Serializable> producer;

    private boolean connectionEstablished = false;

    @Autowired
    private Environment environment;

    public void connect() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", Arrays.asList(environment.getProperty(KAFKA_SERVERS).split(",")));
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.mm.kafka_example.common.MessagePayloadSerializer");

        producer = new KafkaProducer<String, Serializable>(properties);
        connectionEstablished = true;
    }

    public void disconnect() {
        producer.close();
        connectionEstablished = false;
    }

    public void sendMessage(final Message message) {
        ProducerRecord<String, Serializable> producerRecord = new ProducerRecord<String, Serializable>(message.getTopic(), message.getPartition(), message.getKey(), message.getValue());
        producer.send(producerRecord, new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if(exception!=null) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public int[] getPartitionsForTopic(String topic) {
        if(!connectionEstablished) {
            throw new IllegalStateException("Kafka producer is not connected.");
        }
        List<PartitionInfo> partitionInfoList= producer.partitionsFor(topic);
        return (partitionInfoList == null || partitionInfoList.isEmpty()) ?
                new int[]{} : getPartitionsIds(partitionInfoList);
    }

    private int[] getPartitionsIds(List<PartitionInfo> partitionInfoList) {
        int[] partitionsArr = new int[partitionInfoList.size()];
        int index = 0;
        for(PartitionInfo partitionInfo : partitionInfoList) {
            partitionsArr[index] = partitionInfo.partition();
            index+=1;
        }
        return partitionsArr;
    }
}
