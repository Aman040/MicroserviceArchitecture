package com.javafsd.departmentservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long departmentId;
	@NotBlank(message = "Please enter Department Name")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
