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
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		Integer id = service.saveStudent(student);
		return new ResponseEntity<String>("Student '"+id+"' saved",HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer id){
		Student student = service.getOneStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id,@RequestBody Student student){
		Student studentdb = service.getOneStudent(id);
		
		studentdb.setStdName(student.getStdName());
		studentdb.setStdCourse(student.getStdCourse());
		studentdb.setStdFee(student.getStdFee());
		
		service.saveStudent(studentdb);
		return new ResponseEntity<String>("Student '"+id+"' updated",HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		service.deleteStudent(id);
		return new ResponseEntity<String>("Student '"+id+"' deleted",HttpStatus.OK);
	}
}
