package com.example.day02.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
//	public EmployeeResponse get(String id) {
//		return new EmployeeResponse(Integer.parseInt(id), "nawaphong");
//	}
	
	public EmployeeResponse get(int id) {
		Optional<Employee> data = employeeRepository.findById(id);
		if(data.isPresent()) {
			return new EmployeeResponse(id,data.get().getName());
		}
		throw new RuntimeException("Employee not found with id : " + id);
	}
}
