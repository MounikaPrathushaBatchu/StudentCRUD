package com.example.std.service;

import java.util.List;

import com.example.std.model.Department;

import dao.RequestDao.DepartmentRequestDao;
import dao.ResponseDao.DepartmentResponseDao;

public interface DepartmentService {
	Department getDepartment(Long departmentId);
	DepartmentResponseDao addDepartment(DepartmentRequestDao departmentRequestDao);
	DepartmentResponseDao getDepartmentById(Long departmentId);
	List<DepartmentResponseDao> getDepartments();
	DepartmentResponseDao deleteDepartment(Long departmentId);
	DepartmentResponseDao editDeprtment(Long departmentId,DepartmentRequestDao departmentRequestDao);
	
//	Long savedepartment(Department department);
//	List<Department> getAllDepartments();
//	Department getOneDepartment(Long id);
//	void deleteDepartment(Long id);
//	List<Department> getAllDepartmentsinPage(int number);

}
