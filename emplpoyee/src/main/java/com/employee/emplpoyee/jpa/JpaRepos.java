package com.employee.emplpoyee.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.emplpoyee.pojo.Employee;
@Repository
public interface JpaRepos extends JpaRepository<Employee,Integer> {

}