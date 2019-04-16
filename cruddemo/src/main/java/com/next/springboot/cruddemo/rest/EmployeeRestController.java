package com.next.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.springboot.cruddemo.entity.Employee;
import com.next.springboot.cruddemo.service.EmployeeService;
import com.next.springboot.cruddemo.service.EmployeeServiceImplWithJpaRepo;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// private EmployeeService employeeService;
	
	private EmployeeServiceImplWithJpaRepo service;

	// inject the DAO
	// use with service and Hibernate and Standard JPA DAO
//	public EmployeeRestController(EmployeeService theEmployeeService) {
//		employeeService = theEmployeeService;
//	}
	
	// use with service and JPA DAo
	public EmployeeRestController(EmployeeServiceImplWithJpaRepo theService) {
		service = theService;
	}


	// get the Employee List
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return service.findAll();
	}
	
	// add mapping 	for GET /employee/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = service.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found : " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		service.save(theEmployee);;
		
		return theEmployee;
	}
	
	// add mapping for PUST /employees
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		service.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping 	for DELETE /employee/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = service.findById(employeeId);
			
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found : " + employeeId);
		}
			
		service.deleteById(employeeId);
			
		return "Delete Employee Id : " + employeeId;
	}
	

}
