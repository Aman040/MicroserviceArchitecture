package com.javafsd.departmentservice.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.javafsd.departmentservice.Entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
				.departmentName("HR")
				.departmentAddress("Delhi")
				.departmentCode("001")
				.build();
		testEntityManager.persist(department);
	}

	@Test
	public void whenFindById_theReturnDepartment() {
		
		Department department = departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(), "HR");
	}

}