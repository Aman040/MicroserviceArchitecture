package com.javafsd.departmentservice.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.departmentservice.Entity.Department;
import com.javafsd.departmentservice.Service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("inside save department method");
		Department departmentResponse=departmentService.saveDepartment(department);
		return departmentResponse;
	}
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long departmentId) {
		log.info("inside get department method");
		return departmentService.getDepartmentById(departmentId);
	}
}
