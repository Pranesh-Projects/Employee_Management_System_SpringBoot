package com.example.employee_details_sb.controller;

import com.example.employee_details_sb.model.Employee;
import com.example.employee_details_sb.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000/")
//@CrossOrigin(origins = "https://employee-management-app-react.herokuapp.com/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //    get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
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
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeGot) {  //  got employee - 'a'
        Employee employee = service.findEmployeeById(id);   //  transfer employee - 'temp'
        employee.setFirstName(employeeGot.getFirstName());
        employee.setLastName(employeeGot.getLastName());
        employee.setEmailId(employeeGot.getEmailId());
        Employee updateEmployee = service.saveEmployee(employee);  // final employee - 'b'
        return ResponseEntity.ok(updateEmployee);

    }

    //    Delete employee rest api
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
