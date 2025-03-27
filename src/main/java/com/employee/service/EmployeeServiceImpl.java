package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee save(Employee employee) {
		
		return repository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		
		return repository.findAll();
	}
	
	@Override
	public Employee findById(Integer employeeId)
	{
		Optional<Employee> emp = repository.findById(employeeId);
		if(emp.isEmpty())
		{
			throw new EmployeeNotFoundException("Invalid employee id: "+employeeId);
		}
		
		return emp.get();
	}
	
	@Override
	public Employee updateEmployee(Employee employee)
	{
		Optional<Employee> emp = repository.findById(employee.getEmployeeId());
		if(emp.isEmpty())
		{
			throw new EmployeeNotFoundException("Invalid employee id: "+employee.getEmployeeId());
		}
		
		Employee existingEmployee = emp.get();
		
		existingEmployee.setEmployeeId(employee.getEmployeeId());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setSalary(employee.getSalary());
		
		return repository.save(existingEmployee);
	}
	
	@Override
	public void deleteById(Integer employeeId)
	{
		Optional<Employee> emp = repository.findById(employeeId);
		if(emp.isEmpty())
		{
			throw new EmployeeNotFoundException("Invalid employee id: "+employeeId);
		}
		
		repository.deleteById(employeeId);
	}
}
