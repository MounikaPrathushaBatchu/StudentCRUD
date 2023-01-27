package com.example.std.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.std.exception.DepartmentNotFoundException;
import com.example.std.model.Department;
import com.example.std.repo.DepartmentRepository;
import com.example.std.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repo;

	@Override
	public int savedepartment(Department department) {
		int id= repo.save(department).getId();
		return id;
	}
	@Override
	public List<Department> getAllDepartments() {
		List<Department> list =repo.findAll();
		return list;
	}
	@Override
	public Department getOneDepartment(Integer id) {
		Optional<Department> opt=repo.findById(id);
		Department department = opt.orElseThrow(()-> new DepartmentNotFoundException("Department Not Found"));
		return department;
	}
	@Override
	public void deleteDepartment(Integer id) {
		Department department = getOneDepartment(id);
		repo.delete(department);		
	}
	@Override
	public List<Department> getAllDepartmentsinPage(int number) {
		List<Department> list =repo.findAll();
		return list;
	}
}
