package com.powermock.example.pMock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powermock.example.pMock.pojo.Employee;

@Repository
public interface RepositotryClass extends JpaRepository<Employee, Integer>{

	
	
}
