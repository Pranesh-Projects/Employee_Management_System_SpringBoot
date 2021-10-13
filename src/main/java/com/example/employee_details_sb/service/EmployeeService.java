package com.example.employee_details_sb.service;

import com.example.employee_details_sb.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee findEmployeeById(long id);
}
