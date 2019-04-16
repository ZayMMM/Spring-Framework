package com.next.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.next.springboot.cruddemo.dao.EmployeeDao;
import com.next.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	// inject DAO
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		return employeeDao.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee theEmploye) {
		employeeDao.save(theEmploye);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		employeeDao.deleteById(employeeId);
	}

}
