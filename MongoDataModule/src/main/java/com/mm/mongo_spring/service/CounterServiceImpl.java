package com.mm.mongo_spring.service;

import com.mm.mongo_spring.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private MongoOperations mongoOperations;

    public long nextSequence(String collectionName) {
        if(!mongoOperations.collectionExists(Counter.COUNTER_COLLECTION_NAME)) {
            mongoOperations.createCollection(Counter.COUNTER_COLLECTION_NAME);
        }

        Query query = query(Criteria.where("_id").is(collectionName));
        Counter counter = mongoOperations.findOne(query, Counter.class);
        if(counter==null){
            counter=new Counter();
            counter.setId(collectionName);
            counter.setSequence(0l);
            mongoOperations.insert(counter, Counter.COUNTER_COLLECTION_NAME);
        }
        Update update = new Update().inc("sequence", 1);
        counter = mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Counter.class);
        return counter.getSequence();
    }

    public Counter findById(String id) {
        throw new UnsupportedOperationException("findById() is not supported for counters service.");
    }

    public long count() {
        throw new UnsupportedOperationException("Count() is not supported for counters service.");
    }
}
