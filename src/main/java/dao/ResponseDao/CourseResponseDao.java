package dao.ResponseDao;

import java.util.List;

public class CourseResponseDao {
	
	private Long id;
	private String name;
	private boolean active;
	private boolean delete_status;
	private String department_name;
	private List<String> student_names;
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
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public List<String> getStudent_names() {
		return student_names;
	}
	public void setStudent_names(List<String> student_names) {
		this.student_names = student_names;
	}
}
