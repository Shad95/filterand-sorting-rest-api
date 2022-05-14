package com.sortingandpagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sortingandpagination.entity.Employee;
import com.sortingandpagination.entity.EmployeePage;
import com.sortingandpagination.entity.EmployeeSearchCriteria;
import com.sortingandpagination.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage,
			EmployeeSearchCriteria employeeSearchCriteria) {
		
		
		return new ResponseEntity<> (employeeService.getEmployees(employeePage, employeeSearchCriteria),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(Employee employee)  {
		
		return new ResponseEntity<> (employeeService.addEmployee(employee),HttpStatus.OK);
	}
	
}
