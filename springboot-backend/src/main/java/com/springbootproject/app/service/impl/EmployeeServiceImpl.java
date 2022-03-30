package com.springbootproject.app.service.impl;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.springbootproject.app.model.Employee;
import com.springbootproject.app.repository.EmployeeRepository;
import com.springbootproject.app.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id);
		employeeRepository.deleteById(id);
		
	}

	
}
