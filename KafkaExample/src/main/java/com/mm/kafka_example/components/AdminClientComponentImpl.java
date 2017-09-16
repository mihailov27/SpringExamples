package com.mm.kafka_example.components;

import com.mm.kafka_example.model.KafkaOperationError;
import com.mm.kafka_example.model.KafkaOperationResult;
import com.mm.kafka_example.model.Topic;
import com.mm.kafka_example.model.TopicsInfo;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.admin.AdminClientConfig.CLIENT_ID_CONFIG;

@Component
public class AdminClientComponentImpl implements AdminClientComponent {

    private static final Logger logger= Logger.getLogger(AdminClientComponentImpl.class.getName());

    private AdminClient adminClient;

    private boolean isConnectionEstablished;

    @Autowired
    private Environment environment;

    public KafkaOperationResult<TopicsInfo> getTopicsInfo() {
        try {
            Set<String> topicsNames = adminClient.listTopics().names().get();
            return KafkaOperationResult.success(new TopicsInfo(topicsNames));
        } catch(Exception e) {
            String errMsg = String.format(environment.getProperty(PropertyNames.ERROR_GET_TOPICS), new Object[]{e.getMessage()});
            logger.severe(errMsg);
            return KafkaOperationResult.error(new KafkaOperationError(errMsg, e));
        }
    }

    public KafkaOperationResult<Topic> createTopic(String topicName) {
        return createTopic(topicName, (short)1, (short)1);
    }

    public KafkaOperationResult<Topic> createTopic(String topicName, short partitions, short replicas) {
        try {
            NewTopic newTopic = new NewTopic(topicName, partitions, replicas);
            adminClient.createTopics(Arrays.asList(newTopic)).all().get();
            return KafkaOperationResult.success(new Topic(topicName));
        } catch(Exception e) {
            String errMsg = String.format(environment.getProperty(PropertyNames.ERROR_CREATE_TOPIC), new Object[]{topicName, e.getMessage()});
            logger.log(Level.SEVERE, errMsg);
            return KafkaOperationResult.error(new KafkaOperationError(errMsg));
        }
    }

    public KafkaOperationResult<String> deleteTopic(String topicName) {
        try {
            adminClient.deleteTopics(Arrays.asList(topicName)).all().get();
            return KafkaOperationResult.success("Topic '" + topicName + "' was deleted.");
        } catch(Exception e) {
            String errMsg = String.format(environment.getProperty(PropertyNames.ERROR_DELETE_TOPIC), new Object[]{topicName, e.getMessage()});
            logger.log(Level.SEVERE, errMsg);
            return KafkaOperationResult.error(new KafkaOperationError(errMsg,e));
        }
    }

    public void openConnection() {
        Map<String, Object> config = new HashMap<String, Object>();
        //config.put(BOOTSTRAP_SERVERS_CONFIG, Arrays.asList("127.0.0.1:9092"));
        //config.put(CLIENT_ID_CONFIG, "Client");
        String kafkaServers = environment.getProperty(PropertyNames.KAFKA_SERVERS);
        logger.info("Connecting to kafka cluster - "+kafkaServers);
        config.put(BOOTSTRAP_SERVERS_CONFIG, Arrays.asList(kafkaServers.split(",")));
        String clientId = environment.getProperty(PropertyNames.KAFKA_CLIENT_ID);
        config.put(CLIENT_ID_CONFIG, clientId);
        adminClient = KafkaAdminClient.create(config);
        isConnectionEstablished = true;
    }

    public void closeConnection() {
        logger.info("Closing the kafka client.");
        adminClient.close();
        isConnectionEstablished = false;
    }

    public boolean isConnectionEstablished() {
        return isConnectionEstablished;
    }

    public final class PropertyNames {

        private PropertyNames() {}

        public static final String KAFKA_SERVERS =          "kafka.servers";
        public static final String KAFKA_CLIENT_ID =        "kafka.client.id";
        public static final String ERROR_GET_TOPICS =       "kafka.error.get.topics";
        public static final String ERROR_CREATE_TOPIC =     "kafka.error.create.topic";
        public static final String ERROR_DELETE_TOPIC =     "kafka.error.delete.topic";
    }
}
