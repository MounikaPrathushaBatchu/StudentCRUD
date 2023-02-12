package com.example.std.service;

import java.util.List;

import com.example.std.model.Student;

public interface StudentService {
	
	Long saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getOneStudent(Long id);
	
	Student getOneStudent(String name);
	
	//void deleteStudent(Long id);

	List<Student> getAllStudentsinPage(int number);

}
