package com.next.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.springboot.cruddemo.entity.Employee;
import com.next.springboot.cruddemo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImplWithJpaRepo implements EmployeeService{
	
	private EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeServiceImplWithJpaRepo(EmployeeRepository theEmployeeRepo) {
		empRepo = theEmployeeRepo;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		Optional<Employee> result = empRepo.findById(employeeId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee id : " + employeeId);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmploye) {
		empRepo.save(theEmploye);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		empRepo.deleteById(employeeId);
	}

}
