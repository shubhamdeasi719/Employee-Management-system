package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	Employee save(Employee employee);
	List<Employee> findAll();
	Employee updateEmployee(Employee employee);
	Employee findById(Integer employeeId);
	void deleteById(Integer id);
}
