package com.mm.mongo_spring.model;

import java.util.Date;

public class EmployeeBuilder {

    private final Employee employee;

    public EmployeeBuilder() {
        employee=new Employee();
    }

    public EmployeeBuilder id(Long id) {
        employee.setId(id);
        return this;
    }

    public EmployeeBuilder firstName(String firstName) {
        employee.setFirstName(firstName);
        return this;
    }

    public EmployeeBuilder lastName(String lastName) {
        employee.setLastName(lastName);
        return this;
    }

    public EmployeeBuilder position(String position) {
        employee.setPosition(position);
        return this;
    }

    public EmployeeBuilder startDate(Date startDate) {
        employee.setStartDate(startDate);
        return this;
    }

    public EmployeeBuilder active(boolean active) {
        employee.setActive(active);
        return this;
    }

    public EmployeeBuilder endDate(Date endDate) {
        employee.setEndDate(endDate);
        return this;
    }

    public Employee get() {
        return employee;
    }
}
