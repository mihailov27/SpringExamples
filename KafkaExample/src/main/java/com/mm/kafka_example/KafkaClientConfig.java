package com.mm.kafka_example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "com.mm.kafka_example.components")
@PropertySources({
   @PropertySource("classpath:kafka-config.properties")
})
@EnableScheduling
/**
 * Provide kafka.servers and kafka.client.id properties to initialize the configuration successfully.
 */
public class KafkaClientConfig {
}
