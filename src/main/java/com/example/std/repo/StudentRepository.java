package com.example.std.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.std.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
