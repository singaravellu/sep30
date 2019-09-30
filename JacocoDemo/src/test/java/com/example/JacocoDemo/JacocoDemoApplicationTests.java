package com.example.JacocoDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.example.JacocoDemo.service.EmployeeService;

import com.example.JacocoDemo.pojo.Employee;
import com.example.JacocoDemo.controller.EmployeeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class JacocoDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService mockservice;

	Employee emp = new Employee(123, "dev", "dev@gmail.com", "blore");
	Employee emp2 = new Employee(123, "deva", "devareddy@gmail.com", "mumbai");
	Employee emp3= new Employee();

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void testCreateEmployee() throws Exception {

		String inputInJson = this.mapToJson(emp);
		Mockito.when(mockservice.create(Mockito.any(Employee.class))).thenReturn(true);

		// Test case for status code 200 and for correct output

		MvcResult result = mockMvc
				.perform(post("/addEmployee").accept(MediaType.APPLICATION_JSON).content(inputInJson)
						.contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertThat(result.getResponse().getContentAsString()).isEqualTo("true");
		assertEquals(HttpStatus.OK.value(), response.getStatus() );
		
		// test case if we want to add an employee with the id which is assigned to employee added earlier
		Mockito.when(mockservice.create(Mockito.any(Employee.class))).thenReturn(false);


		MvcResult result1 = mockMvc
				.perform(post("/addEmployee").accept(MediaType.APPLICATION_JSON).content(inputInJson)
						.contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response1 = result1.getResponse();
		assertThat(result1.getResponse().getContentAsString()).isEqualTo("false");
		assertEquals(HttpStatus.OK.value(), response1.getStatus() );	
		
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {

		Mockito.when(mockservice.delete(Mockito.anyInt())).thenReturn("deleted");

		// Test case for status code 200 and for correct output

		MvcResult result = mockMvc
				.perform(delete("/deleteEmployee/{id}",12).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertThat(result.getResponse().getContentAsString()).isEqualTo("deleted");
		assertEquals(HttpStatus.OK.value(), response.getStatus() );
		
		//if employee with id is not found
		Mockito.when(mockservice.delete(Mockito.anyInt())).thenReturn("employee with given id not found");

		MvcResult result1 = mockMvc
				.perform(delete("/deleteEmployee/{id}",12).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response1 = result.getResponse();
		assertThat(result1.getResponse().getContentAsString()).isEqualTo("employee with given id not found");
		assertEquals(HttpStatus.OK.value(), response1.getStatus() );
		
}
	@Test
	public void testViewEmployeeById() throws Exception {

		String inputInJson = this.mapToJson(emp);
		String inputInJson1 = this.mapToJson(emp3);

		Mockito.when(mockservice.ViewById(Mockito.anyInt())).thenReturn(emp);

		// Test case for status code 200 and for correct output

		MvcResult result = mockMvc
				.perform(get("/viewEmployee/{empID}",12).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertThat(result.getResponse().getContentAsString()).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus() );
		
		//if employee with id is not found
		Mockito.when(mockservice.ViewById(Mockito.anyInt())).thenReturn(emp3);

		MvcResult result1 = mockMvc
				.perform(get("/viewEmployee/{empID}",12).accept(MediaType.APPLICATION_JSON).content(inputInJson)
						.contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse response1 = result.getResponse();
		assertThat(result1.getResponse().getContentAsString()).isEqualTo(inputInJson1);
		assertEquals(HttpStatus.OK.value(), response1.getStatus() );
		
}
	
	
	
}