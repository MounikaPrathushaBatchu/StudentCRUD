package com.example.std.service;

import java.util.List;

import com.example.std.model.Department;

public interface DepartmentService {
	
	int savedepartment(Department department);
	
	List<Department> getAllDepartments();
	
	Department getOneDepartment(Integer id);
	
	void deleteDepartment(Integer id);

	List<Department> getAllDepartmentsinPage(int number);

}
