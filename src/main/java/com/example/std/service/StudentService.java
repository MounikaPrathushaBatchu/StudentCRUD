package com.example.std.service;

import java.util.List;

import com.example.std.model.Student;

public interface StudentService {
	
	int saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getOneStudent(Integer id);
	
	Student getOneStudent(String name);
	
	void deleteStudent(Integer id);

	List<Student> getAllStudentsinPage(int number);

}
