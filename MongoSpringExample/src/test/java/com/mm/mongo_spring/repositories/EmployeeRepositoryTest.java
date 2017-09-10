package com.mm.mongo_spring.repositories;

import com.mm.mongo_spring.MongoConfiguration;
import com.mm.mongo_spring.model.Employee;
import com.mm.mongo_spring.model.EmployeeBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        employeeRepository.deleteAll();
        // insert data
        insertData();
    }

    private void insertData() {
        Employee employee1 = new EmployeeBuilder().id(1l).firstName("John").lastName("James").active(true).position("Project manager").get();
        Employee employee2 = new EmployeeBuilder().id(2l).firstName("Michael").lastName("Tomas").active(true).position("Software engineer").get();
        Employee employee3 = new EmployeeBuilder().id(3l).firstName("Tom").lastName("Davidson").active(true).position("Test engineer").get();
        Employee employee4 = new EmployeeBuilder().id(4l).firstName("Brigitte").lastName("Davidson").active(true).position("Project manager").get();
        Employee employee5 = new EmployeeBuilder().id(5l).firstName("Rick").lastName("Roberts").active(true).position("Software engineer").get();
        Employee employee6 = new EmployeeBuilder().id(6l).firstName("Prakash").lastName("Pangeni").active(true).position("Software engineer").get();

        employeeRepository.save(Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6));
    }

    @Test
    public void testCount() {
        Assert.assertEquals(6, employeeRepository.count());
    }

    @Test
    public void testFindOne() {
        Employee employee = employeeRepository.findOne(2l);
        Assert.assertNotNull(employee);
        Assert.assertTrue(employee.isActive());
        Assert.assertEquals("Michael", employee.getFirstName());
        Assert.assertEquals("Software engineer", employee.getPosition());
    }

    @Test
    public void testFindByLastName() {
        Page<Employee> employeesPage = employeeRepository.findByLastName("Davidson", new PageRequest(0, 5));
        Assert.assertNotNull(employeesPage);
        Assert.assertEquals(1, employeesPage.getTotalPages());
        Assert.assertEquals(2, employeesPage.getTotalElements());
    }

    @Test
    public void testFindByPosition() {
        Page<Employee> employeesPage = employeeRepository.findByPosition("Software engineer", new PageRequest(0, 5));
        Assert.assertNotNull(employeesPage);
        Assert.assertEquals(1, employeesPage.getTotalPages());
        Assert.assertEquals(3, employeesPage.getTotalElements());
    }

    @After
    public void tearDown() {
        employeeRepository.deleteAll();
    }

}
