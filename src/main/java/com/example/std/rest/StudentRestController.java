package com.example.std.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.std.model.Student;
import com.example.std.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	//@Autowired
	private Student student;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		Long id = service.saveStudent(student);
		return new ResponseEntity<String>("Student '"+id+"' saved",HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	@GetMapping("/get/page{number}")
	public ResponseEntity<List<Student>> getAllStudentsinPage(@PathVariable int number){
		List<Student> list = service.getAllStudentsinPage(number);
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Long id){
		Student student = service.getOneStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<Student> getOneStudent(@PathVariable String name){
		Student student = service.getOneStudent(name);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student student){
		Student studentdb = service.getOneStudent(id);
		studentdb.setName(student.getName());
		service.saveStudent(studentdb);
		return new ResponseEntity<String>("Student '"+id+"' updated",HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
//		service.deleteStudent(id);
		if(student.isDelete_status() == false) {
			student.setDelete_status(true);
		}
		return new ResponseEntity<String>("Student '"+id+"' deleted",HttpStatus.OK);
	}
	@GetMapping("/active")
	public ResponseEntity<List<Student>> getAllActiveStudents(){
		List<Student> list = null;
		while(student.getId() != null) {
			if(student.isActive() == true) 
				list = service.getAllStudents();
			else 
				return null;
		}
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
}
