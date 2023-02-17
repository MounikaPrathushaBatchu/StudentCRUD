package com.example.std.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.std.model.Department;
import com.example.std.model.Student;
import com.example.std.repo.StudentRepository;
import com.example.std.service.DepartmentService;
import com.example.std.service.StudentService;

import dao.Mapper;
import dao.RequestDao.StudentRequestDao;
import dao.ResponseDao.StudentResponseDao;
import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository StudentRepository;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	public StudentServiceImpl(StudentRepository StudentRepository, DepartmentService departmentService) {
		this.StudentRepository = StudentRepository;
		this.departmentService = departmentService;
	}
	@Transactional
	@Override
	public StudentResponseDao addStudent(StudentRequestDao studentRequestDao) {
		Student student = new Student();
		student.setName(studentRequestDao.getName());
		if(studentRequestDao.getDepartment_id() == null) {
			throw new IllegalArgumentException("Student need Department_id");
		}
		Department department = departmentService.getDepartment(studentRequestDao.getDepartment_id());
		student.setDepartment(department);
		StudentRepository.save(student);
		return Mapper.studentToStudentResponseDao(student);
	}

	@Override
	public List<StudentResponseDao> getStudents() {
		List<Student> students = StreamSupport.stream(StudentRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return Mapper.studentsToStudentResponseDao(students);
	}

	@Override
	public StudentResponseDao getStudentById(Long studentId) {
		return Mapper.studentToStudentResponseDao(getStudent(studentId));
	}

	@Override
	public Student getStudent(Long studentId) {
		Student student = StudentRepository.findById(studentId).orElseThrow(
				()-> new IllegalArgumentException("Student with id: "+studentId+"could not found"));
		return student;
	}

	@Override
	public StudentResponseDao deleteStudent(Long studentId) {
		Student student = getStudent(studentId);
		StudentRepository.delete(student);
		return Mapper.studentToStudentResponseDao(student);
	}

	@Override
	public StudentResponseDao editStudent(Long studentId, StudentRequestDao studentRequestDao) {
		Student studentToEdit = getStudent(studentId);
		studentToEdit.setName(studentRequestDao.getName());
		studentToEdit.setEmail_id(studentRequestDao.getEmail_id());
		studentToEdit.setPassword(studentRequestDao.getPassword());
		if(studentRequestDao.getDepartment_id() != null) {
			Department department = departmentService.getDepartment(studentRequestDao.getDepartment_id());
			studentToEdit.setDepartment(department);
		}
		return Mapper.studentToStudentResponseDao(studentToEdit);
	}

	@Transactional
	@Override
	public StudentResponseDao addDepartmentToStudent(Long studentId, Long departmentId) {
		Student student = getStudent(studentId);
		Department department = departmentService.getDepartment(departmentId);
		if(Objects.nonNull(student.getDepartment())) {
			throw new RuntimeException("Student already has a department id");
		}
		student.setDepartment(department);
		return Mapper.studentToStudentResponseDao(student);
	}

	@Transactional
	@Override
	public StudentResponseDao deleteDepartmentFromStudent(Long studentId) {
		Student student = getStudent(studentId);
		student.setDepartment(null);
		return Mapper.studentToStudentResponseDao(student);
	}
	
//	@Autowired(required=true)
//	private StudentRepository repo;
//
//	@Override
//	public Long saveStudent(Student student) {
//		Long id= repo.save(student).getId();
//		return id;
//	}
//	
//	@Override
//	public List<Student> getAllStudents() {
//		List<Student> list =repo.findAll();
//		return list;
//	}
//	@Override
//	public List<Student> getAllStudentsinPage(int number) {
//		List<Student> list =repo.findAll();
//		return list;
//	}
//
//	@Override
//	public Student getOneStudent(Long id) {
//		Optional<Student> opt=repo.findById(id);
//		
//		Student student = opt.orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
//		
////		Student student = null;
////		if(opt.isPresent()) {
////			student=opt.get();
////		}
////		else {
////			throw new StudentNotFoundException("Student Not Found");
////		}
//		
//		return student;
//	}
//
//	
////	  @Override 
////	  public void deleteStudent(Long id) { 
////		  Student student =getOneStudent(id); repo.delete(student); 
////	}
//	 
//
//	@Override
//	public Student getOneStudent(String name) {
//		Optional<Student> opt = repo.findByName(name);
//		Student student = opt.orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
//		return student;
//	}
}
