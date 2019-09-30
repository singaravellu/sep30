package com.example.JacocoDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JacocoDemo.pojo.Employee;
import com.example.JacocoDemo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empSerice;
	
	@PostMapping("/addEmployee")
	public boolean create(@RequestBody Employee emp) {
		return empSerice.create(emp);
	}
	
	@DeleteMapping("/deleteEmployee/{empID}")
	public String deleteEmployee(@PathVariable int empID) {
		return empSerice.delete(empID);
	}
	
	@GetMapping("/viewEmployee/{empID}")
	public Employee viewEmployee(@PathVariable int empID) {
		return empSerice.ViewById(empID);
	}
}
