package com.example.std.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.std.model.Course;
import com.example.std.model.Department;
import com.example.std.model.Student;
import com.example.std.repo.CourseRepository;
import com.example.std.service.CourseService;
import com.example.std.service.DepartmentService;
import com.example.std.service.StudentService;

import dao.Mapper;
import dao.RequestDao.CourseRequestDao;
import dao.ResponseDao.CourseResponseDao;
import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentService studentServive;
	@Autowired
	private DepartmentService departmentService;

	@Transactional
	@Override
	public CourseResponseDao addCourse(CourseRequestDao courseRequestDao) {
		Course course = new Course();
		course.setName(courseRequestDao.getName());
		if(courseRequestDao.getStudent_id() == null) {
			throw new IllegalArgumentException("need atleat one student");
		}
		else {
			List<Student> students = new ArrayList<>();
//			for(Long studentId: courseRequestDao.getStudent_id()){
			while(courseRequestDao.getStudent_id() != null) {
				Long studentId = courseRequestDao.getStudent_id();
				Student student = studentServive.getStudent(studentId);
				students.add(student);
			}
			course.setStudents(students);
		}
			if(courseRequestDao.getDepartment_id() == null) {
				throw new IllegalArgumentException("course has atleast one department");
			}
			Department department = departmentService.getDepartment(courseRequestDao.getDepartment_id());
			course.setDepartment(department);
			
			Course course1 = courseRepository.save(course);
			return Mapper.courseToCourseResponseDao(course1);
	}

	@Override
	public CourseResponseDao getCourseById(Long courseId) {
		Course course = getCourse(courseId);
		return Mapper.courseToCourseResponseDao(course);
	}

	@Override
	public Course getCourse(Long courseId) {
		Course course = courseRepository.findById(courseId).orElseThrow(
				()-> new IllegalArgumentException("cannot finf course with id: "+courseId));
		return course;
	}

	@Override
	public List<CourseResponseDao> getCourses() {
		List<Course> courses = StreamSupport.stream(courseRepository.findAll().spliterator(),false).collect(Collectors.toList());
		return Mapper.coursesToCourseResponseDaos(courses);
	}

	@Override
	public CourseResponseDao deleteCourse(Long courseId) {
		Course course = getCourse(courseId);
		courseRepository.delete(course);
		return Mapper.courseToCourseResponseDao(course);
	}

	@Transactional
	@Override
	public CourseResponseDao editCourse(Long courseId, CourseRequestDao courseRequestDao) {
		Course courseToEdit = getCourse(courseId);
		courseToEdit.setName(courseRequestDao.getName());
		if(!(courseRequestDao.getStudent_id() != null)) {
			List<Student> students = new ArrayList<>();
//			for(Long studentId:courseRequestDao.getStudent_id()) {
			while(courseRequestDao.getStudent_id() != null) {
				Long studentId = courseRequestDao.getStudent_id();
				Student student = studentServive.getStudent(studentId);
				students.add(student);
			}
			courseToEdit.setStudents(students);
		}
		if(courseRequestDao.getStudent_id()!= null) {
			Department department = departmentService.getDepartment(courseRequestDao.getDepartment_id());
			courseToEdit.setDepartment(department);
		}
		return Mapper.courseToCourseResponseDao(courseToEdit);
	}

	@Override
	public CourseResponseDao addStudentToCourse(Long courseId, Long studentId) {
		Course course = getCourse(courseId);
		Student student = studentServive.getStudent(studentId);
		if(student.getCourses().contains(course)) {
			throw new IllegalArgumentException("This Student is already assigned to this Course");
		}
		course.addStudent(student);
		student.addCourse(course);
		return Mapper.courseToCourseResponseDao(course);
	}

	@Override
	public CourseResponseDao removeStudentFromCourse(Long courseId, Long studentId) {
		Course course = getCourse(courseId);
		Student student = studentServive.getStudent(studentId);
		if(!(student.getCourses().contains(course))) {
			throw new IllegalArgumentException("Student is already removed form this Course");
		}
		student.removeCourse(course);
		course.removeStudent(student);
		return Mapper.courseToCourseResponseDao(course);
	}

	@Override
	public CourseResponseDao addDepartmentToCourse(Long courseId, Long departmentId) {
		Course course = getCourse(courseId);
		Department department = departmentService.getDepartment(departmentId);
		if(Objects.nonNull(course.getDepartment())) {
			throw new IllegalArgumentException("This Department is already assigned to this Course");
		}
		course.setDepartment(department);
		department.addCourse(course);
		return Mapper.courseToCourseResponseDao(course);
	}

	@Override
	public CourseResponseDao removeDepartmentFromCourse(Long courseId, Long departmentId) {
		Course course = getCourse(courseId);
		Department department = departmentService.getDepartment(departmentId);
		if(!(Objects.nonNull(course.getDepartment()))) {
			throw new IllegalArgumentException("Course doesnot have a category to remove");
		}
		course.setDepartment(department);
		department.removeCourse(course);
		return Mapper.courseToCourseResponseDao(course);
	}

//	@Override
//	public Long saveCourse(Course course) {
//		Long id= repo.save(course).getId();
//		return id;
//	}
//	@Override
//	public List<Course> getAllCourses() {
//		List<Course> list =repo.findAll();
//		return list;
//	}
//	@Override
//	public Course getOneCourse(Long id) {
//		Optional<Course> opt=repo.findById(id);
//		Course course = opt.orElseThrow(()-> new CourseNotFoundException("Course Not Found"));
//		return course;
//	}
//
//	@Override
//	public void deleteCourse(Long id) {
//		Course course = getOneCourse(id);
//		repo.delete(course);
//	}
//	@Override
//	public List<Course> getAllCoursesinPage(int number) {
//		List<Course> list =repo.findAll();
//		return list;
//	}
}
