package com.example.std.service;

import java.util.List;

import com.example.std.model.Course;

public interface CourseService {
	
	int saveCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getOneCourse(Integer id);
	
	void deleteCourse(Integer id);

	List<Course> getAllCoursesinPage(int number);


}
