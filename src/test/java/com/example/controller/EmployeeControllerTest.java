package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    public EmployeeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee emp = new Employee(1, "Thejaswini", "thejaswini@example.com", "Bengaluru", new Date());
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(emp));
        ResponseEntity<?> response = employeeController.getAllEmployees();
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(((java.util.List<?>) response.getBody()).size() == 1);
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(1, "Thejaswini", "thejaswini@example.com", "Bengaluru", new Date());
        when(employeeService.createEmployee(emp)).thenReturn(emp);
        ResponseEntity<Employee> response = employeeController.addEmployee(emp);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Thejaswini", response.getBody().getName());
    }

}
