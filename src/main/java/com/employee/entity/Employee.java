package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@NotBlank(message="first can't be null")
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min=2, message="Atleast have 2 charcters")
	private String firstName;
	

	@NotBlank(message="last name can't be null")
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min=2, message="Atleast have 2 charcters")
	private String lastName;	

	@NotBlank(message="department can't be null")
	@Pattern(regexp = "^[A-Za-z]+$")
	@Size(min=2, message="Atleast have 2 charcters")
	private String department;
	
	@NotBlank(message="designation can't be null")
	@Pattern(regexp = "^[A-Za-z ]+$")
	@Size(min=2, message="Atleast have 2 charcters")
	private String designation;
	
	@NotNull(message= "Salary can't be null")
	@Min(100)
	private Double salary;
	
	public Employee() {}
	
	public Employee(
			String firstName,
			String lastName,
			String department,
			String designation,
			Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId =  employeeId;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", designation=" + designation + ", salary=" + salary + "]";
	}
	
	
}
