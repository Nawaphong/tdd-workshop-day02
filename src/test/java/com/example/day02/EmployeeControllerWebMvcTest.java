package com.example.day02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.day02.employee.EmployeeController;
import com.example.day02.employee.EmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getById() throws Exception{
		MvcResult mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
		
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeResponse employee = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);
		assertEquals("nawaphong", employee.getName());
		assertEquals(1, employee.getId());
	}
	
}
