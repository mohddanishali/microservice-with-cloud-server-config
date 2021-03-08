package com.userservice.User_Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.User_Service.VO.Department;
import com.userservice.User_Service.VO.ResponseTemplateVO;
import com.userservice.User_Service.model.User;
import com.userservice.User_Service.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) 
	{
		System.out.println("Inside saveUser of UserService");
		
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) 
	{
		System.out.println("Inside getUserWithDepartment of UserService");
		
		Optional<User> user = userRepository.findById(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.get().getDepartmentId(),
				Department.class);
		
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		
		responseTemplateVO.setUser(user.get());
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
