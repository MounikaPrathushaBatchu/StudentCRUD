package com.example.std.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.std.model.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
