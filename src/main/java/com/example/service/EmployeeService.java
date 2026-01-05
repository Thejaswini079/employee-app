package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, int id);
    String deleteEmployee(int id);

}
