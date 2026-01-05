package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
       return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee addedEmp = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmp);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        Employee updatedEmp = employeeService.updateEmployee(employee, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEmp);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String deletedMsg = employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedMsg);
    }



}
