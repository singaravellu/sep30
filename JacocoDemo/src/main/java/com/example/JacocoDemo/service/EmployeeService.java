package com.example.JacocoDemo.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.example.JacocoDemo.pojo.Employee;

@Service
public class EmployeeService {
	ArrayList<Employee> empList = new ArrayList<Employee>();
	Employee employee1 = new Employee(1,"DEVA","deva@gmail.com","bengaluru"); 
	Employee employee2 = new Employee(2,"rakesh","rakesh@gmail.com","bengaluru"); 

	
	public EmployeeService() {
		empList.add(employee1);
		empList.add(employee2);

	}

	public boolean create(Employee emp) {
		if (empList.isEmpty()) {
			return empList.add(emp);

		}

		for (Employee temp : empList) {

			if (temp.getEmployeID() == emp.getEmployeID()) {
				return false;
			}
		}

		return empList.add(emp);
	}

	public String delete(int empID) {
		for (Employee emp : empList) {

			if (emp.getEmployeID() == empID) {
				empList.remove(empID);
				return "deleted";
			}
		}

		return "employee with given id not found";

	}

	public Employee ViewById(int id) {
		for (Employee emp : empList) {

			if (emp.getEmployeID() == id) {
				return	emp;
			}
		}

		return new Employee();
	}

}
