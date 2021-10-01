package com.example.day02.employee;

import lombok.Getter;
import lombok.Setter;

public class EmployeeResponse {
	@Getter @Setter private int id;
	@Getter @Setter private String name;
	
	public EmployeeResponse(){
	}
	
	public EmployeeResponse(int id,String name){
		this.id = id;
		this.name = name;
	}
}
