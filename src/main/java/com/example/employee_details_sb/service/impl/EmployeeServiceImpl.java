package com.example.employee_details_sb.service.impl;

import com.example.employee_details_sb.model.Employee;
import com.example.employee_details_sb.repository.EmployeeRepository;
import com.example.employee_details_sb.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return repo.findAll();
    }
}
