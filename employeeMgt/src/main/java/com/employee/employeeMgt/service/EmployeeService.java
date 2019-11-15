package com.employee.employeeMgt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeMgt.dao.JpaRepos;
import com.employee.employeeMgt.pojo.Employee;



@Service
public class EmployeeService  {
	@Autowired
	JpaRepos repo;
	

	public Employee create(Employee emp) {
		List<Employee> list = repo.findAll();
		
		if(list.isEmpty()) {
			return repo.save(emp);

			
		}
		for (Employee employee : list) {

			if (employee.getEmployeID() == emp.getEmployeID()) {
          return null;			}
		}
		return repo.save(emp);
	}

	public String update(int empId, Employee employee)  {
			List<Employee> list = repo.findAll();
			for (Employee emp : list) {

				if (emp.getEmployeID() == empId) {
					 repo.save(employee);
					 return "Employee with id " +empId+ "updated";
				}
			}
			 repo.save(employee);

			 return "Employee with id " +empId+ "not found";
		
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

	public Employee ViewById(int id) {
		return repo.findByEMPLOYEID(id);
	}

	public List<Employee> viewAll()  {
		List<Employee> empList= repo.findAll();
		if(empList.isEmpty()) {
			
			return null;
			}
		else 
			return empList;
	
	}

}
