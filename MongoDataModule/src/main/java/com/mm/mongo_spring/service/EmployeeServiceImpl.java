package com.mm.mongo_spring.service;

import com.mm.mongo_spring.model.Employee;
import com.mm.mongo_spring.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private EmployeeJsonComponent employeeJsonComponent;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeJsonComponent employeeJsonComponent) {
        this.employeeRepository = employeeRepository;
        this.employeeJsonComponent = employeeJsonComponent;
    }

    public void insertMockData() {
        List<Employee> employeeList = employeeJsonComponent.readEmployees();
        employeeRepository.insert(employeeList);
    }

    public void deleteMockData() {
        employeeRepository.deleteAll();
    }

    public Employee findById(Long id) {
        return null;
    }

    public long count() {
        return employeeRepository.count();
    }
}
