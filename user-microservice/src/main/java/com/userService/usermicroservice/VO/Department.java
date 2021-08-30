package com.userService.usermicroservice.VO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder 
public class Department {
	
	private Long id;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
