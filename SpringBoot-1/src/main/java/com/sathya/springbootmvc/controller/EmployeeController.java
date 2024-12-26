package com.sathya.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.EmployeeEntity;
import com.sathya.springbootmvc.model.EmployeeModel;
import com.sathya.springbootmvc.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	
	EmployeeService employeeService;
	
	//To get the form data
	@GetMapping("/Employeeform")
	public String getEmployee()
	{
		return "add-employee";
	}
	//To display the view
	@PostMapping("/saveEmployee")
	public String saveEmployee(EmployeeModel employeeModel)
	{
		System.out.println(employeeModel);
		employeeService.saveEmployeeDetails(employeeModel);
		return "success";
	}
    //Get the list of Employee Details
	@GetMapping("/getalldetails")
	public String getAllEmployeeDetails(Model model)
	{
		List<EmployeeEntity> employees=employeeService.getEmployeeDetails();
		model.addAttribute("employees",employees);
		return "employee-list";
	}
	
	//Search Employee Details Based on Id
	@GetMapping("/searchemployee")
	public String getEmployeeId()
	{
		return "search-employee";
	}
	@PostMapping("/searchbyid")
	public String getEmployeeById(@RequestParam Long id,Model model)
	{
		EmployeeEntity employee=employeeService.searchByEmployeeId(id);
		model.addAttribute("employee", employee);
		
		return "search-employee";
	}
	//delete the employee details based on id.
	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam("id") Long id)
	{
		employeeService.deleteEmployeedetailsById(id);
		return "redirect:/getalldetails";
	}

}
