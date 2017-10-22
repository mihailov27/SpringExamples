package com.mm.mongo_spring.service;

import com.mm.mongo_spring.model.Employee;

public interface EmployeeService extends MongoCollectionService<Employee,Long> {

    void insertMockData();

    void deleteMockData();
}
