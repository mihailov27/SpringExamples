package com.mm.boot.service;

import com.mm.boot.domain.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    public List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", ""),
            new Topic("javascript", "Javascript", "")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter( t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(Topic nextTopic : topics) {
            if(nextTopic.getId().equals(id)) {
                topics.set(topics.indexOf(nextTopic), topic);
            }
        }
    }
}
