package com.department.department_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.department_Service.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
