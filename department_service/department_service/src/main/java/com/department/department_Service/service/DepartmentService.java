package com.department.department_Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.department_Service.model.Department;
import com.department.department_Service.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		System.out.println("Inside saveDepartment of DepartmentService");

		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long departmentId) {
		System.out.println("Inside findDepartmentById of DepartmentService");

		return departmentRepository.findById(departmentId);
	}

}
