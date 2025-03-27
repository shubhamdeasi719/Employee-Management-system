package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/add-employee")
	public String addEmployee(Model model)
	{
		model.addAttribute("employee",new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult br, RedirectAttributes redirectAttributes)
	{
		if(br.hasErrors())
		{
			return "addEmployee";
		}
		
		try {
			service.save(employee);
			redirectAttributes.addFlashAttribute("success","New employee added successfully");
			return "redirect:/all-employee";
		}catch(Exception e)
		{
			redirectAttributes.addFlashAttribute("error","Employee not able to add");
			return "redirect:/error";
		}
		
	}
	
	@GetMapping("/all-employee")
	public String getAllEmployee(Model model)
	{
		List<Employee> empList = service.findAll();
		model.addAttribute("allEmp",empList);
		return "allEmployee";
	}
	
	@GetMapping("/update-employee")
	public String updateEmployee(@RequestParam Integer employeeId, Model model)
	{
		Employee employee = service.findById(employeeId);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@PostMapping("/save-updated-employee")
	public String saveUpdateEmployee(@Valid @ModelAttribute Employee employee, BindingResult br,Model model,RedirectAttributes redirectAttributes)
	{
		System.out.println("Employee object received: " + employee); // Log the entire object
		System.out.println("Employee ID received: " + employee.getEmployeeId());
		
		if(br.hasErrors())
		{
			model.addAttribute("employee",employee);
			return "updateEmployee";
		}
		
		try {
			service.updateEmployee(employee);
			redirectAttributes.addFlashAttribute("success", "Employee data update successfully");
			return "redirect:/all-employee";
		}catch(Exception e)
		{
			redirectAttributes.addFlashAttribute("error", "employee not able to update");
			return  "redirect:/errorPage";
		}
		
			
	}
	
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam Integer employeeId, RedirectAttributes redirectAttributes)
	{
		try {
			service.deleteById(employeeId);
			redirectAttributes.addFlashAttribute("success", "Employee deleted successfully!!");
			return "redirect:/all-employee";
		}catch(Exception e)
		{
			redirectAttributes.addFlashAttribute("error", "Employee not found");
			return "redirect:/errorPage";
		}
	
	}
	
}
