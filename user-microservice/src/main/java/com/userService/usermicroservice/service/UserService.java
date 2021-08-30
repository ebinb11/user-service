package com.userService.usermicroservice.service;

import com.userService.usermicroservice.VO.ResponseTemplateVO;
import com.userService.usermicroservice.entity.User;

public interface UserService {

	User userCreate(User requertUser);

	ResponseTemplateVO getUserWithDepartment(Long id);

}
