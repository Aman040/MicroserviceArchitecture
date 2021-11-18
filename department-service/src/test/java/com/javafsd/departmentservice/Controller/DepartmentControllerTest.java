package com.javafsd.departmentservice.Controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.javafsd.departmentservice.Entity.Department;
import com.javafsd.departmentservice.Service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp(){
		
		department = Department.builder()
				.departmentAddress("Delhi")
				.departmentName("HR")
				.departmentCode("007")
				.departmentId(1L)
				.build();
	}

	@Test
	@DisplayName("Saves Department ")
	public void saveDepartment() throws Exception {
		Department departmentInput = Department.builder()
				.departmentAddress("Delhi")
				.departmentName("HR")
				.departmentCode("007")
				.build();
		
		Mockito.when(departmentService.saveDepartment(departmentInput))
			.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + 
						"	\"departmentName\":\"HR\",\n" + 
						"	\"departmentAddress\":\"Delhi\",\n" + 
						"	\"departmentCode\":\"007\"\n" + 
						"}\n" + 
						"")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	@Test
	void fetchDepartment() throws Exception {
		Mockito.when(departmentService.getDepartmentById(1L))
		.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
					.value(department.getDepartmentName()));
	}
}