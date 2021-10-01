package com.example.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.day02.employee.Employee;
import com.example.day02.employee.EmployeeRepository;
import com.example.day02.employee.EmployeeResponse;
import static org.mockito.Mockito.when;

import java.util.Optional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest2 {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private EmployeeRepository EmployeeRepository;
	
	@Test
	public void getById() {
		//Arrange
		Employee data = new Employee();
		data.setName("nawaphong");
		when(EmployeeRepository.findById(1)).thenReturn(Optional.of(data));
		
		//Action
		EmployeeResponse employee = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
		assertEquals("nawaphong", employee.getName());
		//Assert
		assertEquals(1, employee.getId());
	}
}
