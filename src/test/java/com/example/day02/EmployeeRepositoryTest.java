package com.example.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.day02.employee.Employee;
import com.example.day02.employee.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Test
	public void case01() {
		//Arrange
		Employee data = new Employee();
		data.setName("Nawaphong");
		EmployeeRepository.save(data);
		//Act
		Optional<Employee> result = EmployeeRepository.findById(1);
		//Assert
		assertTrue(result.isPresent());
		assertEquals(1, result.get().getId());
	}
	
	@Test
	public void case02() {
		
	}
}
