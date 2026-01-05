package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee updateEmp = null;
        if(emp.isPresent()){
            updateEmp = emp.get();
            updateEmp.setName(employee.getName());
            updateEmp.setEmail(employee.getEmail());
            updateEmp.setLocation(employee.getLocation());
            updateEmp.setDob(employee.getDob());
        }
        return employeeRepository.save(updateEmp);
    }

    @Override
    public String deleteEmployee(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        String msg = "Employee deleted successfully";
        if(emp.isPresent()) {
            employeeRepository.delete(emp.get());
        }
        return msg;
    }
}
