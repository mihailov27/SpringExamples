package com.mm.mongo_spring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mm.mongo_spring.exception.DataException;
import com.mm.mongo_spring.model.Employee;
import com.mm.mongo_spring.model.Gender;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeJsonComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeJsonComponent.class);

    @Autowired
    private Environment env;

    @Autowired
    private CounterService counterService;

    public List<Employee> readEmployees() throws DataException {

        try {
            File file = new File(env.getProperty("mock.data.employee"));
            byte[] jsonBytes = FileUtils.readFileToByteArray(file);
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jsonBytes);
            List<Employee> employeeList = new ArrayList<Employee>();

            for(int i=0; i<arrayNode.size(); i++) {
                JsonNode jsonNode = arrayNode.get(i);
                Employee employee = new Employee();
                employee.setId(counterService.nextSequence(Employee.EMPLOYEE_COLLECTION_NAME));
                employee.setFirstName(jsonNode.get("first_name").asText());
                employee.setLastName(jsonNode.get("last_name").asText());
                employee.setEmail(jsonNode.get("email").asText());
                employee.setGender(Gender.valueOf(jsonNode.get("gender").asText()));
                employee.setCompany(jsonNode.get("company").asText());
                employee.setDepartment(jsonNode.get("department").asText());
                employee.setJobTitle(jsonNode.get("job_title").asText());
                employee.setAvatar(jsonNode.get("avatar").asText());
                employeeList.add(employee);
            }
            return employeeList;
        } catch(IOException ioe) {
            throw new DataException(ioe);
        }
    }
}
