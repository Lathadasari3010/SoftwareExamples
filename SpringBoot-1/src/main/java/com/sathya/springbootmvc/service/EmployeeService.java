package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sathya.springbootmvc.entity.EmployeeEntity;
import com.sathya.springbootmvc.model.EmployeeModel;
import com.sathya.springbootmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
     
	//To save data in database
	public void saveEmployeeDetails(EmployeeModel employeeModel)
	{
		double hra;
		hra=employeeModel.getSalary()*employeeModel.getHra()/100;
		
		double da;
		da=employeeModel.getSalary()*employeeModel.getDa()/100;
		
		double pf;
		pf=employeeModel.getSalary()*employeeModel.getPf()/100;
		
		double bonus;
		bonus=employeeModel.getBonus()/100 *employeeModel.getSalary();
		
		double grossSalary;
		grossSalary=hra+da+employeeModel.getBonus()+employeeModel.getSalary();
		
		double totalSalary;
		totalSalary=grossSalary-pf;
		
		EmployeeEntity employeeEntity=new EmployeeEntity();
		
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setSalary(employeeModel.getSalary());
		employeeEntity.setAge(employeeModel.getAge());
		employeeEntity.setGender(employeeModel.getGender());
		employeeEntity.setDepartment(employeeModel.getDepartment());
		employeeEntity.setExperience(employeeModel.getExperience());
		employeeEntity.setBonus(employeeModel.getBonus());
		employeeEntity.setDa(employeeModel.getDa());
		employeeEntity.setHra(employeeModel.getHra());
		employeeEntity.setPf(employeeModel.getPf());
		employeeEntity.setGrossSalary(grossSalary);
		employeeEntity.setTotalSalary(totalSalary);
		
		employeeRepository.save(employeeEntity);
		
		
		
		
	}
    //get the list of details from repository class using findAll() method and return that details to controller layer.
	public List<EmployeeEntity> getEmployeeDetails() {
		List<EmployeeEntity> employees = employeeRepository.findAll() ;
		return employees;
	}
	
	//get the details based on id, if it is present hold that data and return to controller class,if not return null.
	public EmployeeEntity searchByEmployeeId(Long id)
	{
	    Optional<EmployeeEntity> optionalData = employeeRepository.findById(id);
	    if (optionalData.isPresent()) 
	    {
	    	EmployeeEntity employee=optionalData.get();
	        return employee;  // Return the employee if found
	    } else {
	        return null;  // Return null if not found
	    }
	}
	
	//delete the details based on id
	public void deleteEmployeedetailsById(Long id) {
		employeeRepository.deleteById(id);
		
	}


	

	

	
}
