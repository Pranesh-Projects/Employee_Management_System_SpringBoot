package com.example.employee_details_sb.controller;

import com.example.employee_details_sb.model.Employee;
import com.example.employee_details_sb.repository.EmployeeRepository;
import com.example.employee_details_sb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //    get all employee
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return service.findAllEmployees();
    }

}
