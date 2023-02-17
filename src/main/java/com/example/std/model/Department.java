package com.example.std.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@GeneratedValue
	private boolean active = true;
	@GeneratedValue
	private boolean delete_status;
	
	
public Department() {
		super();
	}
public Department(String name, boolean active, boolean delete_status) {
		super();
		this.name = name;
		this.active = active;
		this.delete_status = delete_status;
	}
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Student> students;
	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Course> courses;
	public void addCourse(Course course) {
		courses.add(course);
	}
	public void removeCourse(Course course) {
		courses.remove(course);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isDelete_status() {
		return delete_status;
	}
	public void setDelete_status(boolean delete_status) {
		this.delete_status = delete_status;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}


