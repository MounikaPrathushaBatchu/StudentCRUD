package com.example.std.model;

import com.example.std.config.AesEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;

//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import jakarta.persistence.UniqueConstraint;

@Data
@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String email_id;
	@Convert(converter = AesEncryptor.class)
	@GeneratedValue
	private String Password;
	@GeneratedValue
	public boolean active = true;
	@GeneratedValue
	private boolean delete_status = false;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinTable(
				name = "Student_Courses",
				joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
	private Course courses;
	
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isDelete_status() {
		return delete_status;
	}
	public void setDelete_status(boolean delete_status) {
		this.delete_status = delete_status;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
//	public List<Course> getCourse() {
//		return courses;
//	}
//	public void setCourse(List<Course> course) {
//		this.courses = course;
//	}
	
}
