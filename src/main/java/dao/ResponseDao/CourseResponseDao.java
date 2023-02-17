package dao.ResponseDao;

import java.util.List;

import lombok.Data;
@Data
public class CourseResponseDao {
	
	private Long id;
	private String name;
	private boolean active;
	private boolean delete_status;
	private String departmentName;
	private List<String> studentNames;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<String> getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}
	
}
