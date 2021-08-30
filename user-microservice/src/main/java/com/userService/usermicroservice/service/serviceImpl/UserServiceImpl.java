package com.userService.usermicroservice.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.usermicroservice.VO.Department;
import com.userService.usermicroservice.VO.ResponseTemplateVO;
import com.userService.usermicroservice.entity.User;
import com.userService.usermicroservice.exception.ResourceNotFoundException;
import com.userService.usermicroservice.repository.UserRepository;
import com.userService.usermicroservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User userCreate(User requertUser) {
		log.info("inside userCreate of UserService");
		return userRepository.save(requertUser);
	}

	@Override
	public ResponseTemplateVO getUserWithDepartment(Long id) {
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		log.info("inside findUserById of UserService");
		Optional<User> userGet = userRepository.findById(id);
		if (!userGet.isPresent()) {
			throw new ResourceNotFoundException("data not found!");
		}
		if (!userGet.isPresent()) {
			throw new ResourceNotFoundException("data not found!");
		}
		Long departmentId = userGet.get().getDepartmentId();
		Department departmentGet = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/getDepartment/" + departmentId,
				Department.class);
		responseTemplateVO.setUser(userGet.get());
		responseTemplateVO.setDepartment(departmentGet);
		return responseTemplateVO;
	}
}
