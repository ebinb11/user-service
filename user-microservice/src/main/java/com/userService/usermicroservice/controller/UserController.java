package com.userService.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.usermicroservice.VO.ResponseTemplateVO;
import com.userService.usermicroservice.entity.User;
import com.userService.usermicroservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("userCreate")
	public User userCreate(@RequestBody User requertUser) {
		log.info("inside userCreate of UserController");
		return userService.userCreate(requertUser);
	}

	@GetMapping("userGet/{id}")
	public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable Long id) {
		log.info("inside findUserById of UserController");
		ResponseTemplateVO responseTemplateVO = userService.getUserWithDepartment(id);
		return ResponseEntity.ok(responseTemplateVO);
	}
}
