package com.sortingandpagination.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sortingandpagination.entity.Employee;
import com.sortingandpagination.entity.EmployeePage;
import com.sortingandpagination.entity.EmployeeSearchCriteria;
import com.sortingandpagination.repository.EmployeeCriteriaRepository;
import com.sortingandpagination.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	 private final EmployeeRepository employeeRepository;
	 private final EmployeeCriteriaRepository employeeCriteriaRepository;
	 
	public EmployeeService(EmployeeRepository employeeRepository,
			EmployeeCriteriaRepository employeeCriteriaRepository) {
		this.employeeRepository = employeeRepository;
		this.employeeCriteriaRepository = employeeCriteriaRepository;
	}
	
	public Page <Employee> getEmployees(EmployeePage employeePage , EmployeeSearchCriteria employeeSearchCriteria)  {
		
		return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
