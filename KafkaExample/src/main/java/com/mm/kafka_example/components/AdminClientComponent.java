package com.mm.kafka_example.components;

import com.mm.kafka_example.model.KafkaOperationResult;
import com.mm.kafka_example.model.Topic;
import com.mm.kafka_example.model.TopicsInfo;

public interface AdminClientComponent {

    /** Open the connection */
    void connect();

    /** Closes the connection */
    void disconnect();

    /** Returns true, if a connection to the kafka cluster is established. */
    boolean isConnectionEstablished();

    /** Return topics info */
    KafkaOperationResult<TopicsInfo> getTopicsInfo();

    /** Creates a topic with given name. */
    KafkaOperationResult<Topic> createTopic(String topicName);

    /**
     * Creates a topic with given name, partitions and replicas values.
     * @param topicName
     * @param partitions
     * @param replicas
     * @return
     */
    KafkaOperationResult<Topic> createTopic(String topicName, short partitions, short replicas);

    /** Delete a topic with the given name. */
    KafkaOperationResult<String> deleteTopic(String topicName);
}
