package com.example.std.service;

import java.util.List;

import com.example.std.model.Course;

import dao.RequestDao.CourseRequestDao;
import dao.ResponseDao.CourseResponseDao;

public interface CourseService {
	
	CourseResponseDao addCourse(CourseRequestDao courseRequestDao);
	CourseResponseDao getCourseById(Long courseId);
	Course getCourse(Long courseId);
	List<CourseResponseDao> getCourses();
	CourseResponseDao deleteCourse(Long courseId);
	CourseResponseDao editCourse(Long courseId,CourseRequestDao courseRequestDao);
	CourseResponseDao addStudentToCourse(Long courseId,Long studentId);
	CourseResponseDao removeStudentFromCourse(Long courseId,Long studentId);
	CourseResponseDao addDepartmentToCourse(Long courseId,Long departmentId);
	CourseResponseDao removeDepartmentFromCourse(Long courseId,Long departmentId);
	
//	Long saveCourse(Course course);
//	List<Course> getAllCourses();
//	Course getOneCourse(Long id);
//	void deleteCourse(Long id);
//	List<Course> getAllCoursesinPage(int number);
}
