package com.example.std.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.std.exception.CourseNotFoundException;
import com.example.std.model.Course;
import com.example.std.repo.CourseRepository;
import com.example.std.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository repo;

	@Override
	public Long saveCourse(Course course) {
		Long id= repo.save(course).getId();
		return id;
	}
	@Override
	public List<Course> getAllCourses() {
		List<Course> list =repo.findAll();
		return list;
	}

	@Override
	public Course getOneCourse(Long id) {
		Optional<Course> opt=repo.findById(id);
		Course course = opt.orElseThrow(()-> new CourseNotFoundException("Course Not Found"));
		return course;
	}

	@Override
	public void deleteCourse(Long id) {
		Course course = getOneCourse(id);
		repo.delete(course);
		
	}
	@Override
	public List<Course> getAllCoursesinPage(int number) {
		List<Course> list =repo.findAll();
		return list;
	}
}
