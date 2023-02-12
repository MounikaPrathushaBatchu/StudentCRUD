package com.example.std.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;

import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.std.config.AesEncryptor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
	private String password;
	@GeneratedValue
	private boolean active = true;
	@GeneratedValue
	private boolean delete_status = false;
	
	@ManyToOne
	@JoinColumn(name = "department_id")//,insertable=false, updatable=false)
	private Department department;
	//private int department_id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
				name = "Student_Courses",
				joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
	private List<Course> courses;
	
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/*
	 * public int getDepartment_id() { return department_id; } public void
	 * setDepartment_id(int department_id) { this.department_id = department_id; }
	 */
	/*
	 * public Student(Long id, String name, String email_id, String password,
	 * boolean active, boolean delete_status, Department department,int
	 * department_id, List<Course> courses) { this.id = id; this.name = name;
	 * this.email_id = email_id; BCryptPasswordEncoder passwordEncoder = new
	 * BCryptPasswordEncoder(); this.password = passwordEncoder.encode(password);
	 * this.active = active; this.delete_status = delete_status; this.department =
	 * department; this.department_id = department_id; this.courses = courses; }
	 */
}
