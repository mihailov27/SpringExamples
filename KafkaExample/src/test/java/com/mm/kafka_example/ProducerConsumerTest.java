package com.mm.kafka_example;

import com.mm.kafka_example.components.AdminClientComponent;
import com.mm.kafka_example.components.ConsumerComponent;
import com.mm.kafka_example.components.ProducerComponent;
import com.mm.kafka_example.model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KafkaClientConfig.class})
public class ProducerConsumerTest {

    @Autowired
    private AdminClientComponent adminClientComponent;

    @Autowired
    private ConsumerComponent consumerComponent;

    @Autowired
    private ProducerComponent producerComponent;

    @Before
    public void setUp() {
        adminClientComponent.connect();
        consumerComponent.connect();
        producerComponent.connect();
    }

    @Ignore
    @Test
    public void test() {
        adminClientComponent.createTopic("TEST");
        consumerComponent.subscribe("TEST");
        producerComponent.sendMessage(new Message<String>("TEST", "1", "test message 1"));
        producerComponent.sendMessage(new Message<String>("TEST", "1", "test message 2"));
        producerComponent.sendMessage(new Message<String>("TEST", "1", "test message 3"));

        try {
            Thread.currentThread().sleep(8500);
        }catch(InterruptedException ie) {}


        //adminClientComponent.deleteTopic("TEST");
    }

    @After
    public void tearDown() {
        adminClientComponent.disconnect();
        consumerComponent.disconnect();
        producerComponent.disconnect();
    }
}
