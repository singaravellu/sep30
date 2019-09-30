package com.capgemini.tracker.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.tracker.ResourceTrackerApplication;
import com.capgemini.tracker.exceptionHandler.RecordNotFoundException;
import com.capgemini.tracker.pojo.EmployeePojo;
import com.capgemini.tracker.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	private static final Logger LOG = LoggerFactory.getLogger(ResourceTrackerApplication.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<EmployeePojo> insert(@Valid @RequestBody EmployeePojo employee) {
		empService.create(employee);
		return new ResponseEntity<EmployeePojo>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<EmployeePojo> update(@PathVariable int id, @RequestBody EmployeePojo employee1) {
		EmployeePojo employee = empService.findByemployeeId(id);
		System.out.println(employee);
		if (employee1.getCurrentAccount() != null)
			employee.setCurrentAccount(employee1.getCurrentAccount());

		if (employee1.getGrade() != null)
			employee.setGrade(employee1.getGrade());

		if (employee1.getLocalGrade() != null)
			employee.setLocalGrade(employee1.getLocalGrade());

		if (employee1.getLocation() != null)
			employee.setLocation(employee1.getLocation());

		if (employee1.getOfficeLocation() != null)
			employee.setOfficeLocation(employee1.getOfficeLocation());

		if (employee1.getgP() != null)
			employee.setgP(employee.getgP());

		if (employee1.getLevel3EngagementRole() != null)
			employee.setLevel3EngagementRole(employee1.getLevel3EngagementRole());

		if (employee1.getPrimarySkill() != null)
			employee.setPrimarySkill(employee1.getPrimarySkill());

		if (employee1.getProjectCode() != null)
			employee.setProjectCode(employee1.getProjectCode());

		if (employee1.getProjectEndDate() != null)
			employee.setProjectEndDate(employee1.getProjectEndDate());

		if (employee1.getProjectName() != null)
			employee.setProjectName(employee1.getProjectName());

		if (employee1.getProjectStartDate() != null)
			employee.setProjectStartDate(employee1.getProjectStartDate());

		if (employee1.getSeat() != null)
			employee.setSeat(employee1.getSeat());
		empService.update(employee);
		return new ResponseEntity<EmployeePojo>(employee, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
	public ResponseEntity<EmployeePojo> getEmployeeById(@PathVariable("id") int id) {
		EmployeePojo employee = empService.findByemployeeId(id);

		if (employee == null) {
			LOG.warn(" Record not found (function :getEmployeeById)",
					new RecordNotFoundException("Invalid employee id : " + id));
			throw new RecordNotFoundException("Invalid employee id : " + id);
		} else {

			LOG.info("record found for id:" + id);
		}
		return new ResponseEntity<EmployeePojo>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{employeeId}")
	public ResponseEntity<EmployeePojo> deleteById(@PathVariable int employeeId) {
		EmployeePojo employee = empService.findByemployeeId(employeeId);
		if (employee == null) {
			LOG.warn(" Record not found (function :deleteById)",
					new RecordNotFoundException("Invalid employee id : " + employeeId));
			throw new RecordNotFoundException("Invalid employee id : " + employeeId);
		} else {

			LOG.info("Deleted record with id:" + employeeId);
		}
		return new ResponseEntity<EmployeePojo>(employee, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteall")
	public void deleteAll() {
		LOG.info("Deleted all records");
		empService.deleteAll();
		

	}

	@RequestMapping(method = RequestMethod.GET, value = "/view")
	public ResponseEntity<List<EmployeePojo>> viewAll() {

		List<EmployeePojo> list = empService.findAllEmployee();

		if (list.isEmpty()==true) {
			LOG.warn(" Records not found (function :viewAll)");
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyGp/{location}")
	public ResponseEntity<List<EmployeePojo>> findbyLocation(@PathVariable String location) {

		List<EmployeePojo> list = empService.findByLocation(location);
		if (list.isEmpty()==true) {
			LOG.warn(" Records not found for the location(function :findbyLocation) :" + location);
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records with location " + location + " viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbylocation/{gp}")
	public ResponseEntity<List<EmployeePojo>> findbyGp(@PathVariable String gp) {

		List<EmployeePojo> list = empService.findbyGp(gp);
		if (list.isEmpty()==true) {
			LOG.warn(" Records not found for the gP(function :findbyGp) :" + gp);
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records with gp " + gp + " viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyname/{name}")
	public ResponseEntity<List<EmployeePojo>> findbyname(@PathVariable String name) {
		List<EmployeePojo> list = empService.findbyname(name);
		if (list.isEmpty()==true) {
			LOG.warn(" Records not found for the employee name(function :findbyname) :" + name);
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records with " + name + " contains in record's employee name is viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyPrimarySkill/{primarySkill}")
	public ResponseEntity<List<EmployeePojo>> findbyPrimarySkill(@PathVariable String primarySkill) {
		List<EmployeePojo> list = empService.findbyPrimarySkill(primarySkill);
		if (list.isEmpty()==true) {
			LOG.warn(" Records not found for the primarySkill(function :findbyPrimarySkill) :" + primarySkill);
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records with primary skill " + primarySkill + " viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findbyProjectcode/{pcode}")
	public ResponseEntity<List<EmployeePojo>> findbyProjectCode(@PathVariable String pcode) {
		List<EmployeePojo> list = empService.findbyProjectCode(pcode);
		if (list.isEmpty()==true) {
			LOG.warn(" Records not found for the project code(function :findbyProjectCode) :" + pcode);
			throw new RecordNotFoundException("No records found");
		} else {

			LOG.info("All records with project code " + pcode + " viewed");
		}
		return new ResponseEntity<List<EmployeePojo>>(list, HttpStatus.OK);

	}

}
