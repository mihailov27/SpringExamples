package com.mm.mongo_spring;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@ComponentScan(basePackages = "com.mm.mongo_spring.service")
@EnableMongoRepositories(basePackages = MongoModuleConfiguration.MONGO_REPOSITORIES_PACKAGE)
@PropertySource("classpath:application.properties")
public class MongoModuleConfiguration extends AbstractMongoConfiguration {

    protected static final String MONGO_REPOSITORIES_PACKAGE = "com.mm.mongo_spring.repositories";

    @Autowired
    private Environment environment;

    public Mongo mongo() throws UnknownHostException {
        return new MongoClient(environment.getProperty("mongo.server.host"));
    }

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("mongo.database");
    }
}
