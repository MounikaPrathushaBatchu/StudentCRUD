package com.example.std.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.std.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
