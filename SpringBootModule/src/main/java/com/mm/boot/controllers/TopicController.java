package com.mm.boot.controllers;

import com.mm.boot.domain.Topic;
import com.mm.boot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable("id") String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
        topicService.updateTopic(id, topic);
    }
}
