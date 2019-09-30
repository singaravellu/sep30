package com.capgemini.tracker.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.tracker.pojo.EmployeePojo;
import com.capgemini.tracker.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public EmployeePojo create(EmployeePojo employee) {

		List<EmployeePojo> list = findAllEmployee();
		for (EmployeePojo emp : list) {
			if (emp.getEmployeeId() == employee.getEmployeeId()) {
				return null;
			}
		}

		return repo.save(employee);

	}

	public EmployeePojo update(EmployeePojo employee) {

		return repo.save(employee);

	}

	public List<EmployeePojo> findAllEmployee() {
		return repo.findAll();
	}

	public EmployeePojo findByemployeeId(int employeeId) {
		return repo.findByemployeeId(employeeId);
	}

	public void delete(EmployeePojo emp) {
		repo.delete(emp);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public List<EmployeePojo> findByLocation(String location) {
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		List<EmployeePojo> main = repo.findAll();
		for (EmployeePojo index : main) {
			if (index.getLocation().equals(location)) {
				list.add(index);
			}
		}
		return list;

	}

	public List<EmployeePojo> findbyGp(@PathVariable String gp) {
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		List<EmployeePojo> main = repo.findAll();
		for (EmployeePojo index : main) {
			if (index.getgP().equals(gp)) {
				list.add(index);
			}
		}
		return list;

	}

	public List<EmployeePojo> findbyname(@PathVariable String name) {
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		List<EmployeePojo> main = repo.findAll();
		for (EmployeePojo index : main) {
			if (index.getEmployeeName().toLowerCase().contains(name.toLowerCase())) {
				list.add(index);
			}
		}
		return list;
	}

	public List<EmployeePojo> findbyPrimarySkill(@PathVariable String primarySkill) {
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		List<EmployeePojo> main = repo.findAll();
		for (EmployeePojo index : main) {
			if (index.getPrimarySkill().equals(primarySkill)) {
				list.add(index);
			}
		}
		return list;

	}

	public List<EmployeePojo> findbyProjectCode(@PathVariable String pcode) {
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		List<EmployeePojo> main = repo.findAll();
		for (EmployeePojo index : main) {
			if (index.getProjectCode().equals(pcode)) {
				list.add(index);
			}
		}
		return list;

	}

}