package dao.RequestDao;

import java.util.List;

import com.example.std.model.Course;

import lombok.Data;

@Data
public class DepartmentRequestDao {
	
	private String name;
	private int student_id;
	private List<Course> courses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
