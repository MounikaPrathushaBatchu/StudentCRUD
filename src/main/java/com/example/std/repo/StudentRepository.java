package com.example.std.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.std.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);

}
