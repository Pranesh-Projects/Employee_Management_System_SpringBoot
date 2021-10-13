package com.example.employee_details_sb.controller;

import com.example.employee_details_sb.model.Employee;
import com.example.employee_details_sb.service.EmployeeService;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //    get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return service.findAllEmployees();
    }

    //   create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }
    
    //   get employee by 'Id'
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = service.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    
    //   update employee 
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeGot){  //  got employee - 'a'
        Employee employee = service.findEmployeeById(id);   //  transfer employee - 'temp'
        employee.setFirstName(employeeGot.getFirstName());
        employee.setLastName(employeeGot.getLastName());
        employee.setEmailId(employeeGot.getEmailId());
        Employee updateEmployee = service.saveEmployee(employee);  // final employee - 'b'
        return ResponseEntity.ok(updateEmployee);
        
    }

}
