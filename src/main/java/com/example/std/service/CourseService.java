package com.example.std.service;

import java.util.List;

import com.example.std.model.Course;

public interface CourseService {
	
	Long saveCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getOneCourse(Long id);
	
	void deleteCourse(Long id);

	List<Course> getAllCoursesinPage(int number);


}
