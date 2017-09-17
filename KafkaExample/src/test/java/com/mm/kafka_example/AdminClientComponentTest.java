package com.mm.kafka_example;

import com.mm.kafka_example.components.AdminClientComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KafkaClientConfig.class})
public class AdminClientComponentTest {

    @Autowired
    AdminClientComponent adminClientComponent;

    @Before
    public void setUp() {
        if(!adminClientComponent.isConnectionEstablished()) {
            adminClientComponent.connect();
        }
    }

    @After
    public void tearDown() {
        if(adminClientComponent.isConnectionEstablished()) {
            adminClientComponent.disconnect();
        }
    }

    @Test
    public void createAndDeleteTopic() {
        adminClientComponent.createTopic("Test-topic-1");
        adminClientComponent.deleteTopic("Test-topic-1");
    }
}
