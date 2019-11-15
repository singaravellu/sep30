package com.employee.employeeMgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeeMgt.pojo.Employee;

@Repository
public interface JpaRepos extends JpaRepository<Employee,Integer> {

	public Employee findByEMPLOYEID(int id);
	
}