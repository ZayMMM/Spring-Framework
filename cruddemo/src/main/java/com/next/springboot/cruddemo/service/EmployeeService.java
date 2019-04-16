package com.next.springboot.cruddemo.service;

import java.util.List;

import com.next.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int employeeId);
	
	public void save(Employee theEmploye);
	
	public void deleteById(int employeeId);

}
