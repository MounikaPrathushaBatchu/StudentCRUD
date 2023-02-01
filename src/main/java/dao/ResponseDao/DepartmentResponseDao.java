package dao.ResponseDao;

import java.util.List;

public class DepartmentResponseDao {
	
	private Long id;
	private String name;
	private boolean active;
	private boolean delete_status;
	private List<Integer> student_id;
	private List<String> courses;
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
	public List<Integer> getStudent_id() {
		return student_id;
	}
	public void setStudent_id(List<Integer> student_id) {
		this.student_id = student_id;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
