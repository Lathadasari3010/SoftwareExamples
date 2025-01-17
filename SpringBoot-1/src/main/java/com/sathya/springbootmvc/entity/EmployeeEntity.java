package com.sathya.springbootmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double salary;
	private int age;
	private String gender;
	private String department;
	private String experience;
	private double bonus;
	private double da;
	private double hra;
	private double pf;
	private double grossSalary;
	private double totalSalary;
	


}
