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

import com.example.std.service.CourseService;

import dao.RequestDao.CourseRequestDao;
import dao.ResponseDao.CourseResponseDao;


@RestController
@RequestMapping("/courses")
public class CourseRestController {
	@Autowired
	private CourseService CourseService;
	
	@PostMapping("/add")
	public ResponseEntity<CourseResponseDao> addCourse(@RequestBody CourseRequestDao courseRequestDao){
		CourseResponseDao courseResponseDao = CourseService.addCourse(courseRequestDao);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<CourseResponseDao> getCourse(@PathVariable Long id){
		CourseResponseDao courseResponseDao = CourseService.getCourseById(id);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<CourseResponseDao>> getCourses(){
		List<CourseResponseDao> courseResponseDaos = CourseService.getCourses();
		return new ResponseEntity<>(courseResponseDaos,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CourseResponseDao> deleteCourse(@PathVariable Long id){
		CourseResponseDao courseResponseDao = CourseService.deleteCourse(id);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<CourseResponseDao> editCourse(@RequestBody CourseRequestDao courseRequestDao,@PathVariable Long id){
		CourseResponseDao courseResponseDao = CourseService.editCourse(id, courseRequestDao);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@PostMapping("/addDepartment/{depaermentId}/to/{courseId}")
	public ResponseEntity<CourseResponseDao> addDepartment(@PathVariable Long departmentId,@PathVariable Long CourseId){
		CourseResponseDao courseResponseDao = CourseService.addDepartmentToCourse(CourseId,departmentId);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@PostMapping("/removeDepartment/{depaermentId}/from/{courseId}")
	public ResponseEntity<CourseResponseDao> removeDepartment(@PathVariable Long departmentId,@PathVariable Long CourseId){
		CourseResponseDao courseResponseDao = CourseService.removeDepartmentFromCourse(CourseId, departmentId);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@PostMapping("/addStudent/{depaermentId}/to/{courseId}")
	public ResponseEntity<CourseResponseDao> addStudent(@PathVariable Long studentId,@PathVariable Long CourseId){
		CourseResponseDao courseResponseDao = CourseService.addStudentToCourse(CourseId, studentId);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	@PostMapping("/removeStudent/{depaermentId}/from/{courseId}")
	public ResponseEntity<CourseResponseDao> removeStudent(@PathVariable Long studentId,@PathVariable Long CourseId){
		CourseResponseDao courseResponseDao = CourseService.removeStudentFromCourse(CourseId, studentId);
		return new ResponseEntity<>(courseResponseDao,HttpStatus.OK);
	}
	
	
////	@Autowired
//	private Course course;
//	
//	@PostMapping("/save")
//	public ResponseEntity<String> saveCourse(@RequestBody Course course){
//		Long id = service.saveCourse(course);
//		return new ResponseEntity<String>("Course '"+id+"' saved",HttpStatus.OK);
//	}
//	@GetMapping("/get")
//	public ResponseEntity<List<Course>> getAllCourses(){
//		List<Course> list = service.getAllCourses();
//		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
//	}
//	@GetMapping("/get/page{number}")
//	public ResponseEntity<List<Course>> getAllCoursesinPage(@PathVariable int number){
//		List<Course> list = service.getAllCoursesinPage(number);
//		return new ResponseEntity<List<Course>>(list,HttpStatus.OK);
//	}
//	@GetMapping("/get/{id}")
//	public ResponseEntity<Course> getOneDepartment(@PathVariable Long id){
//		Course course = service.getOneCourse(id);
//		return new ResponseEntity<Course>(course, HttpStatus.OK);
//	}
//	@PutMapping("/update/{id}")
//	public ResponseEntity<String> updateDepartment(@PathVariable Long id,@RequestBody Course course){
//		Course coursedb = service.getOneCourse(id);
//		coursedb.setName(course.getName());
//		service.saveCourse(coursedb);
//		return new ResponseEntity<String>("Course '"+id+"' updated",HttpStatus.OK);
//	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
////		service.deleteCourse(id);
//		if(course.isDelete_status() == false) {
//			course.setDelete_status(true);
//		}
//		return new ResponseEntity<String>("Course '"+id+"' deleted",HttpStatus.OK);
//	}
//	@GetMapping("/active")
//	public ResponseEntity<List<Course>> getAllActiveCourses(){
//		List<Course> list = null;
//		while(course.getId() != null) {
//			if(course.isActive() != false) 
//				list = service.getAllCourses();
//			else 
//				return null;
//		}
//		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
//	}
}
