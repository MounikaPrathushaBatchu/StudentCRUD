package com.example.std.service;

import java.util.List;

import com.example.std.model.Student;

import dao.RequestDao.StudentRequestDao;
import dao.ResponseDao.StudentResponseDao;

public interface StudentService {
	
//	Long saveStudent(Student student);
//	List<Student> getAllStudents();
//	Student getOneStudent(Long id);
//	Student getOneStudent(String name);
//	//void deleteStudent(Long id);
//	List<Student> getAllStudentsinPage(int number);
	
	StudentResponseDao addStudent(StudentRequestDao studentRequestDao);
	List<StudentResponseDao> getStudents();
	StudentResponseDao getStudentById(Long studentId);
	Student getStudent(Long studentId);
	StudentResponseDao deleteStudent(Long studentId);
	StudentResponseDao editStudent(Long studentId,StudentRequestDao studentRequestDao);
	StudentResponseDao addDepartmentToStudent(Long studentId,Long departmentId);
	StudentResponseDao deleteDepartmentFromStudent(Long studentId);
	
}
