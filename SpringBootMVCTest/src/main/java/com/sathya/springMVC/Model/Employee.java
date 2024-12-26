package com.sathya.springMVC.Model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Employee {
	
	int empId;
	String empName;
	double salary;
	public static void main(String[] args)
	{
		Employee emp=Employee.builder()
				.empId(111)
				.empName("Ratan")
				.salary(1116.4)
				.build();
		System.out.println(emp);
		
	}

}
