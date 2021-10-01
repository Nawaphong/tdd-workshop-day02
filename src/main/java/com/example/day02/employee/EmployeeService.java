package com.example.day02.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public EmployeeResponse get(String id) {
		return new EmployeeResponse(Integer.parseInt(id), "nawaphong");
	}
	
}
