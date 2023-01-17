package com.example.std.service;

import java.util.List;

import com.example.std.model.Student;

public interface StudentService {
	
	Integer saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getOneStudent(Integer id);
	
	void deleteStudent(Integer id);

}
