package com.mm.kafka_example.components;

import java.util.Collection;
import java.util.Set;

public interface ConsumerComponent {

    void connect();

    void disconnect();

    void subscribe(String topic);

    void subscribe(Collection<String> topics);

    void poll();

    Set<String> subscription();

    void unsubscribe();
}

