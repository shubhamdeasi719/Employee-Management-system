package com.employee.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public String employeeNotFoundExceptionHandler(EmployeeNotFoundException e,Model model)
	{
		model.addAttribute("error", e.getMessage());
		return "errorPage";
	}
	
	@ExceptionHandler(Exception.class)
	public String generalExceptionHandler(Exception e, Model model)
	{
		model.addAttribute("error", e.getMessage());
		return "errorPage";
	}
}
