package com.powermock.example.pMock;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.powermock.example.pMock.staticMethod.StaticMethodClass;

@RunWith(PowerMockRunner.class)
public class PMockApplicationTests {

	
	
	@Mock
	StaticMethodClass sclass;
	
	@Autowired
	private MockMvc  mvc;
	@Test
	@PrepareForTest(StaticMethodClass.class)

	public void staticmethodtest() throws Exception {

		
		PowerMockito.mockStatic(StaticMethodClass.class);
		PowerMockito.when(StaticMethodClass.staticMethod()).thenReturn("static met");
		//String op=StaticMethodClass.staticMethod();
		//assertEquals(op, "static met");

		
		MvcResult result= mvc.perform(get("/static")).andReturn();
		System.out.println(result);
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		assertEquals(outputInJson, "static method");
	}

}
