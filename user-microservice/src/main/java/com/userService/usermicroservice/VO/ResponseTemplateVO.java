package com.userService.usermicroservice.VO;

import com.userService.usermicroservice.entity.User;

import lombok.Data;

@Data
public class ResponseTemplateVO {

	private User user;
	private Department department;
}
