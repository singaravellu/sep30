package com.employee.emplpoyee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.emplpoyee.exceptions.RecordNotFoundException;
import com.employee.emplpoyee.pojo.Employee;
import com.employee.emplpoyee.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmpController {
	@Autowired
	EmployeeService empService;

	@PostMapping(value = "/insert")
	public Employee insert(@Valid @RequestBody Employee emp) {
		return empService.create(emp);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> update(@RequestBody Employee emp, @PathVariable int id) {
		 try {
			empService.update(id, emp);
		} catch (RecordNotFoundException e) {
			e.getMessage();
		      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  
		}
		return new ResponseEntity<Object>(emp, HttpStatus.OK);

	}

	@GetMapping(value = "/viewBy/{id}")
	public Optional<Employee> EmployeeViewByID(@PathVariable int id) {

		return empService.ViewById(id);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteByID(@PathVariable int id) {

		return empService.delete(id);
	}
	
	
	@GetMapping(value = "/viewAll")
	public List<Employee> ViewAll() throws Exception {

		return empService.viewAll();
	}
	
	//////////////////////////////////////////////
	/*
	 * @GetMapping(value = "/viewStatic") public Employee staticMethod(@RequestBody
	 * Employee emp) { return EmployeeService.staticMethod(emp);
	 * 
	 * }
	 */
	
}
