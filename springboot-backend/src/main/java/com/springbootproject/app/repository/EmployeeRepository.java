package com.springbootproject.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee> findAll();

	Employee save(Employee employee);

	Employee findById(long id);

}
