package com.javafsd.departmentservice.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafsd.departmentservice.Entity.Department;
import com.javafsd.departmentservice.Exception.DepartmentNotFoundExceptions;
import com.javafsd.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		Department departmentResponse =departmentRepository.save(department);
		LOGGER.info("Department saved successfully : " + departmentResponse);
		return departmentResponse;
	}
	
	public Department getDepartmentById(Long departmentId) {
		 Department departmentResponse= departmentRepository.findByDepartmentId(departmentId);
		 if(departmentResponse == null) {
			 throw new DepartmentNotFoundExceptions("Department is not available in database for this department id");
			 }

			 return departmentResponse;
	}
}
