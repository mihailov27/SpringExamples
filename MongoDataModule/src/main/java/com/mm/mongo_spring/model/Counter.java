package com.mm.mongo_spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Counter.COUNTER_COLLECTION_NAME)
public class Counter {

    public static final String COUNTER_COLLECTION_NAME = "counters";

    @Id
    private String id;

    private long sequence;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
