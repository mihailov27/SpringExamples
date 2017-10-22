package com.mm.mongo_spring.repositories;

import com.mm.mongo_spring.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    Page<Employee> findByLastName(String lastName, Pageable pageable);

    Page<Employee> findByJobTitle(String position, Pageable pageable);
}
