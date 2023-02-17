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

import com.example.std.service.StudentService;

import dao.RequestDao.StudentRequestDao;
import dao.ResponseDao.StudentResponseDao;

@RestController
@RequestMapping("/students")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<StudentResponseDao> addStudent(@RequestBody StudentRequestDao studentRequestDao){
		StudentResponseDao studentResponseDao = studentService.addStudent(studentRequestDao);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<StudentResponseDao> getStudent(@PathVariable Long id){
		StudentResponseDao studentResponseDao = studentService.getStudentById(id);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<StudentResponseDao>> getStudents(){
		List<StudentResponseDao> studentResponseDaos = studentService.getStudents();
		return new ResponseEntity<>(studentResponseDaos,HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<StudentResponseDao> deleteStudent(@PathVariable Long id){
		StudentResponseDao studentResponseDao = studentService.deleteStudent(id);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<StudentResponseDao> edittStudent(@PathVariable Long id, @RequestBody StudentRequestDao studentRequestDao){
		StudentResponseDao studentResponseDao = studentService.editStudent(id, studentRequestDao);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	@PostMapping("/addDepartment/{departmentId}/to/{studentId}")
	public ResponseEntity<StudentResponseDao> addDepartment(@PathVariable Long department_id,@PathVariable Long student_id){
		StudentResponseDao studentResponseDao = studentService.addDepartmentToStudent(student_id, department_id);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	@PostMapping("/removeDepartment/{id}")
	public ResponseEntity<StudentResponseDao> removeDepartment(@PathVariable Long id){
		StudentResponseDao studentResponseDao = studentService.deleteDepartmentFromStudent(id);
		return new ResponseEntity<>(studentResponseDao,HttpStatus.OK);
	}
	
	
//	//@Autowired
//	private Student student;
//	
//	@PostMapping("/save")
//	public ResponseEntity<String> saveStudent(@RequestBody Student student){
//		Long id = service.saveStudent(student);
//		return new ResponseEntity<String>("Student '"+id+"' saved",HttpStatus.OK);
//	}
//	@GetMapping("/get")
//	public ResponseEntity<List<Student>> getAllStudents(){
//		List<Student> list = service.getAllStudents();
//		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
//	}
//	@GetMapping("/get/page{number}")
//	public ResponseEntity<List<Student>> getAllStudentsinPage(@PathVariable int number){
//		List<Student> list = service.getAllStudentsinPage(number);
//		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
//	}
//	@GetMapping("/getbyid/{id}")
//	public ResponseEntity<Student> getOneStudent(@PathVariable Long id){
//		Student student = service.getOneStudent(id);
//		return new ResponseEntity<Student>(student, HttpStatus.OK);
//	}
//	@GetMapping("/getbyname/{name}")
//	public ResponseEntity<Student> getOneStudent(@PathVariable String name){
//		Student student = service.getOneStudent(name);
//		return new ResponseEntity<Student>(student,HttpStatus.OK);
//	}
//	@PutMapping("/update/{id}")
//	public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student student){
//		Student studentdb = service.getOneStudent(id);
//		studentdb.setName(student.getName());
//		service.saveStudent(studentdb);
//		return new ResponseEntity<String>("Student '"+id+"' updated",HttpStatus.OK);
//	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
////		service.deleteStudent(id);
//		if(student.isDelete_status() == false) {
//			student.setDelete_status(true);
//		}
//		return new ResponseEntity<String>("Student '"+id+"' deleted",HttpStatus.OK);
//	}
//	@GetMapping("/active")
//	public ResponseEntity<List<Student>> getAllActiveStudents(){
//		List<Student> list = null;
//		while(student.getId() != null) {
//			if(student.isActive() == true) 
//				list = service.getAllStudents();
//			else 
//				return null;
//		}
//		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
//	}
}
