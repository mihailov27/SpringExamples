package com.mm.kafka_example.components;

import com.mm.kafka_example.model.Message;

import java.io.Serializable;

public interface ProducerComponent {

    void connect();

    void disconnect();

    int[] getPartitionsForTopic(String topic);

    void sendMessage(Message<?> message);
}
