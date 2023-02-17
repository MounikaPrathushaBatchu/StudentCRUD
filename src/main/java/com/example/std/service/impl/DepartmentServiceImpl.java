package com.example.std.service.impl;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.std.model.Department;
import com.example.std.repo.DepartmentRepository;
import com.example.std.service.DepartmentService;

import dao.Mapper;
import dao.RequestDao.DepartmentRequestDao;
import dao.ResponseDao.DepartmentResponseDao;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department getDepartment(Long departmentId) {
		return departmentRepository.findById(departmentId).orElseThrow(()->
		new IllegalArgumentException("could not found deprtment with id: "+departmentId));
	}

	@Override
	public DepartmentResponseDao addDepartment(DepartmentRequestDao departmentRequestDao) {
		Department department = new Department();
		department.setName(departmentRequestDao.getName());
		return Mapper.departmentToDepartmentResponseDao(department);
	}

	@Override
	public DepartmentResponseDao getDepartmentById(Long departmentId) {
		Department department = getDepartment(departmentId);
		return Mapper.departmentToDepartmentResponseDao(department);
	}

	@Override
	public List<DepartmentResponseDao> getDepartments() {
		List<Department> departments = StreamSupport.stream(departmentRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.departmentsToDepartmentResponseDaos(departments);
	}

	@Override
	public DepartmentResponseDao deleteDepartment(Long departmentId) {
		Department department = getDepartment(departmentId);
		departmentRepository.delete(department);
		return Mapper.departmentToDepartmentResponseDao(department);
	}

	@Override
	public DepartmentResponseDao editDeprtment(Long departmentId, DepartmentRequestDao departmentRequestDao) {
		Department departmentToEdit = getDepartment(departmentId);
		departmentToEdit.setName(departmentRequestDao.getName());
		return Mapper.departmentToDepartmentResponseDao(departmentToEdit);
	}

//	@Override
//	public Long savedepartment(Department department) {
//		Long id= repo.save(department).getId();
//		return id;
//	}
//	@Override
//	public List<Department> getAllDepartments() {
//		List<Department> list =repo.findAll();
//		return list;
//	}
//	@Override
//	public Department getOneDepartment(Long id) {
//		Optional<Department> opt=repo.findById(id);
//		Department department = opt.orElseThrow(()-> new DepartmentNotFoundException("Department Not Found"));
//		return department;
//	}
//	@Override
//	public void deleteDepartment(Long id) {
//		Department department = getOneDepartment(id);
//		repo.delete(department);		
//	}
//	@Override
//	public List<Department> getAllDepartmentsinPage(int number) {
//		List<Department> list =repo.findAll();
//		return list;
//	}
}
