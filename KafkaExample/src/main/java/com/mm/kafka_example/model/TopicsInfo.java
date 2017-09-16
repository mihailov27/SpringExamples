package com.mm.kafka_example.model;

import org.apache.kafka.clients.admin.TopicListing;

import java.util.*;

public class TopicsInfo {

    private final int count;
    private final Collection<Topic> topics;

    public TopicsInfo(Collection<String> topics) {
        count = topics!=null ? topics.size():0;
        this.topics = new ArrayList<Topic>(topics.size());
        for(String topic:topics) {
            this.topics.add(new Topic(topic));
        }
    }

    public int getCount() {
        return count;
    }

    public Collection<Topic> getTopics() {
        return topics;
    }
}
