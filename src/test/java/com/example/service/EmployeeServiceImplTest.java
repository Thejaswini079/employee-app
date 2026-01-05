package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setId(1);
        employee.setName("Thejaswini");
        employee.setEmail("thejaswini@example.com");
        employee.setLocation("Bengaluru");
        employee.setDob(new Date());
    }

    @Test
    void testGetAllEmployees() {
        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(1, employees.size());
        assertEquals("Thejaswini", employees.get(0).getName());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test void testCreateEmployee() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee saved = employeeService.createEmployee(employee);
        assertNotNull(saved);
        assertEquals("Thejaswini", saved.getName());
        verify(employeeRepository, times(1)).save(employee);
    }

}
