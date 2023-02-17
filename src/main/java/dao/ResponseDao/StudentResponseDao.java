package dao.ResponseDao;

import java.util.List;

import lombok.Data;

@Data
public class StudentResponseDao {
	
	private Long id;
	private String name;
	private String email_id;
	private String Password;
	private boolean active;
	private boolean delete_status;
	private String departmentName;
	private List<String> courseNames;
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
	public List<String> getCourseNames() {
		return courseNames;
	}
	public void setCourseNames(List<String> courseNames) {
		this.courseNames = courseNames;
	}
	
}
