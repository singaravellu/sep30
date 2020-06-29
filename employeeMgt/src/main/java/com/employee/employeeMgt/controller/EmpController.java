package com.employee.employeeMgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeMgt.pojo.Employee;
import com.employee.employeeMgt.service.EmployeeService;



@RestController
public class EmpController {
	
	
	@Autowired
	EmployeeService empService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Employee insert( @RequestBody Employee employee) {
		System.out.println(employee.toString());
		
		Employee emp = new Employee(1, "dev", "d", "c");
		return empService.create(employee);

	}

	@PutMapping(value = "/update/{id}")
	public String update(@RequestBody Employee emp, @PathVariable int id) {
		
		return	empService.update(id, emp);
		

	}

	@GetMapping(value = "/viewBy/{id}")
	public Employee EmployeeViewByID(@PathVariable int id) {

		return empService.ViewById(id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteByID(@PathVariable int id) {

		return empService.delete(id);
	}
	
	
	@GetMapping(value = "/viewAll")
	public List<Employee> ViewAll()  {

		return empService.viewAll();
	}
	
}
