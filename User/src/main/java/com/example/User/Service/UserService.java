package com.example.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.User.Entity.User;
import com.example.User.Exception.UserNotFoundExceptions;
import com.example.User.Repository.Repository;
import com.example.User.Service.Vo.Department;
import com.example.User.Service.Vo.ResponseTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private static final String USERSERVICE="userService";
	
	@Autowired
	private Repository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	int attempt=1;
	Long fallbackId;
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Retry(name=USERSERVICE , fallbackMethod= "fallbackMethod_getUserWithDepartment")
	public ResponseTemplate getUserWithDepartmentId(Long userId) {
		log.info("Request Attemt : "+attempt++);
		fallbackId=userId;
		ResponseTemplate responseTemplate=new ResponseTemplate();
		User userResponse=userRepository.findByUserId(userId);
		Department departmentResponse=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+userResponse.getDepartmentId(), Department.class);
		if(userResponse==null ||departmentResponse==null ) {
			throw new UserNotFoundExceptions("User is not available in database for this user id");
			
		}else {
		
		responseTemplate.setUser(userResponse);
		responseTemplate.setDepartment(departmentResponse);
		
			 
		return responseTemplate;
		}
	}

	public ResponseTemplate fallbackMethod_getUserWithDepartment(Exception exception) {
		log.info("Indise fallback method ");
		ResponseTemplate responseTemplate=new ResponseTemplate();
		User userResponse=userRepository.findByUserId(fallbackId);
		if(userResponse==null ) {
			throw new UserNotFoundExceptions("User is not available in database for this user id");
			
		}
		responseTemplate.setUser(userResponse);
		Department department=new Department();
		department.setDepartmentName("Null");
		department.setDepartmentAddress("Null");
		department.setDepartmentCode("Null");
		department.setDepartmentId(0L);
		responseTemplate.setDepartment(department);
		return responseTemplate;
	}
	
}
