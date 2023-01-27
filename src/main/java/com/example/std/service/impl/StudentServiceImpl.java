package com.example.std.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.std.exception.StudentNotFoundException;
import com.example.std.model.Student;
import com.example.std.repo.StudentRepository;
import com.example.std.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public int saveStudent(Student student) {
		int id= repo.save(student).getId();
		return id;
	}
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> list =repo.findAll();
		return list;
	}
	@Override
	public List<Student> getAllStudentsinPage(int number) {
		List<Student> list =repo.findAll();
		return list;
	}

	@Override
	public Student getOneStudent(Integer id) {
		Optional<Student> opt=repo.findById(id);
		
		Student student = opt.orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
		
		/*Student student = null;
		if(opt.isPresent()) {
			student=opt.get();
		}
		else {
			throw new StudentNotFoundException("Student Not Found");
		}*/
		
		return student;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student student = getOneStudent(id);
		repo.delete(student);
	}

	@Override
	public Student getOneStudent(String name) {
		Optional<Student> opt = repo.findByName(name);
		Student student = opt.orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
		return student;
	}
}
