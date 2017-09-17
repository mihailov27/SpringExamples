package com.mm.kafka_example.model;

import java.io.Serializable;

public class Message<V extends Serializable> {

    private String topic;

    private String key;

    private V value;

    private Integer partition;

    public Message(String topic, V value) {
        this(topic, null, value);
    }

    public Message(String topic, String key, V value) {
        this(topic, key, value, null);
    }

    public Message(String topic, String key, V value, Integer partition) {
        this.topic = topic;
        this.key = key;
        this.value = value;
        this.partition = partition;
    }

    public String getTopic() {
        return topic;
    }

    public String getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }
}
