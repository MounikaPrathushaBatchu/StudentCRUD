package com.example.std.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.std.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
