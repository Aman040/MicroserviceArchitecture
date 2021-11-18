package com.javafsd.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafsd.departmentservice.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentId(Long departmentId);



}
