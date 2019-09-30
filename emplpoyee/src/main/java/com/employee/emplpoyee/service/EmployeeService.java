package com.employee.emplpoyee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.emplpoyee.exceptions.RecordNotFoundException;
import com.employee.emplpoyee.jpa.JpaRepos;
import com.employee.emplpoyee.pojo.Employee;

@Service
public class EmployeeService  {
	@Autowired
	JpaRepos repo;
	
	public String name = "Deva";
	
	/*
	 * public static Employee staticMethod(Employee emp) { return emp; }
	 * 
	 * 
	 * 
	 * 
	 * private Employee privateMethod(Employee emp) {
	 * 
	 * return emp; }
	 */
	public Employee create(Employee emp) {
		if (name.equalsIgnoreCase("Deva")) {
			List<Employee> list = repo.findAll();
			if (list.isEmpty()) {
				return repo.save(emp);

			}

			for (Employee temp : list) {

				if (temp.getEmployeID() == emp.getEmployeID()) {
					return null;
				}
			}
		}
		return repo.save(emp);
	}

	public Employee update(int empId, Employee employee) throws RecordNotFoundException {
		if (name.equalsIgnoreCase("Deva")) {
			List<Employee> list = repo.findAll();
			for (Employee emp : list) {

				if (emp.getEmployeID() == empId) {
					return repo.save(employee);
				}
			}
		}
		throw new RecordNotFoundException("emp id not found :"+ empId);
		
		
	}

	public String delete(int empID) {
		List<Employee> list = repo.findAll();
		for (Employee emp : list) {

			if (emp.getEmployeID() == empID) {
				repo.deleteById(empID);
				return "deleted";
			}
		}

		return "employee with given id not found";

	}

	public Optional<Employee> ViewById(int id) {
		return repo.findById(id);
	}

	public List<Employee> viewAll() throws Exception {
		List<Employee> empList= (List<Employee>) repo.findAll();
		if(empList.isEmpty()) {
			
			throw new Exception("list is empty");
		}
		else 
			return empList;
	
	}

}
