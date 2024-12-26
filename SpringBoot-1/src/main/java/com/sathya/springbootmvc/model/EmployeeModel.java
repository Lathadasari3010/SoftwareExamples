package com.sathya.springbootmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
	private long id;
	private String name;
	private double salary;
	private int age;
	private String gender;
	private String department;
	private String experience;
	private double da;
	private double hra;
	private double pf;
	private double bonus;

}
