package com.mm.mongo_spring.service;

import java.io.Serializable;

public interface MongoCollectionService<T, I extends Serializable> {

    T findById(I id);

    long count();
}
