package com.mm.mongo_spring.service;

import com.mm.mongo_spring.model.Counter;

public interface CounterService extends MongoCollectionService<Counter,String> {

    long nextSequence(String collectionName);
}
