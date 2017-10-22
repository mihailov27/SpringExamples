package com.mm.mongo_spring.repositories;

import com.mm.mongo_spring.MongoModuleConfiguration;
import com.mm.mongo_spring.service.EmployeeService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoModuleConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeService.deleteMockData();
        employeeService.insertMockData();
    }

    @Ignore
    @Test
    public void testCount() {
        Assert.assertEquals(1000, employeeService.count());
    }

    @After
    public void tearDown() {
        employeeService.deleteMockData();
    }

}
