package com.mm.kafka_example.common;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.Serializable;
import java.util.Map;

public class MessagePayloadDeserializer<T extends Serializable> implements Deserializer<T> {

    public void close() {

    }

    public T deserialize(String topic, byte[] data) {
        return SerializationUtils.deserialize(data);
    }

    public void configure(Map<String, ?> configs, boolean isKey) {

    }
}
