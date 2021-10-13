package com.example.employee_details_sb.service.impl;

import com.example.employee_details_sb.exception.ResourceNotFoundException;
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

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

    @Override
    public Employee findEmployeeById(long id) {
        Employee employee = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee id not exist : " + id));
        return employee;
    }
}
