package com.mm.kafka_example.common;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
import java.util.Map;

public class MessagePayloadSerializer<T extends Serializable> implements Serializer<T> {

    public byte[] serialize(String topic, T data) {
        return SerializationUtils.serialize(data);
    }

    public void close() {

    }

    public void configure(Map<String, ?> configs, boolean isKey) {

    }
}
