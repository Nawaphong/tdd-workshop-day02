package com.example.day02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.day02.employee.EmployeeController;
import com.example.day02.employee.EmployeeResponse;
import com.example.day02.employee.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void getById() throws Exception{
		//Arrange
		EmployeeResponse data = new EmployeeResponse(1,"nawaphong");
		when(employeeService.get("1")).thenReturn(data);
		
		//Act
		MvcResult mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		
		ObjectMapper mapper = new ObjectMapper();
		 EmployeeResponse result
         = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
                            EmployeeResponse.class);
		//Assert
		 assertEquals(1, result.getId());
		assertEquals("nawaphong", result.getName());
	}
	
}
