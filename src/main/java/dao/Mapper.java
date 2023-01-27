package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.std.model.Course;
import com.example.std.model.Department;
import com.example.std.model.Student;

import dao.ResponseDao.CourseResponseDao;
import dao.ResponseDao.DepartmentResponseDao;
import dao.ResponseDao.StudentResponseDao;

public class Mapper {
	@Autowired
	private static CourseResponseDao courseResponseDao;
	
	public static CourseResponseDao courseToCourseResponseDao(Course course) {
		courseResponseDao.setId(course.getId());
		courseResponseDao.setDepartment_name(course.getDepartment().getName());
		List<String> names = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		for(Student student:students) {
			names.add(student.getName());
		}
		courseResponseDao.setStudent_names(names);
		return courseResponseDao;
	}
	public static List<CourseResponseDao> coursesToCourseResponseDaos(List<Course> courses){
		List<CourseResponseDao> courseResponseDaos = new ArrayList<>();
		for(Course course:courses) {
			courseResponseDaos.add(courseToCourseResponseDao(course));
		}
		return courseResponseDaos;
	}
	@Autowired
	private static StudentResponseDao studentResponseDao;
	public static StudentResponseDao studentToStudentResponseDao(Student student) {
		studentResponseDao.setId(student.getId());
		studentResponseDao.setName(student.getName());
		List<String> names = new ArrayList<>();
		List<Course> courses = student.getCourse();
		for(Course course:courses) {
			names.add(course.getName());
		}
		studentResponseDao.setCourses(names);
		return studentResponseDao;
	}
	public static List<StudentResponseDao> studentToStudentResponseDao(List<Student> students){
		List<StudentResponseDao> studentResponseDaos = new ArrayList<>();
		for(Student student:students) {
			studentResponseDaos.add(studentToStudentResponseDao(student));
		}
		return studentResponseDaos;
	}
	@Autowired
	private static DepartmentResponseDao departmentResponseDao;
	public static DepartmentResponseDao departmentToDepartmentResponseDao(Department department) {
		departmentResponseDao.setId(department.getId());
		departmentResponseDao.setName(department.getName());
		List<String> names = new ArrayList<>();
		List<Course> courses = department.getCourses();
		for(Course course:courses) {
			names.add(course.getName());
		}
		return departmentResponseDao;
	}
	public static List<DepartmentResponseDao> departmentToDepartmentResponseDaos(List<Department> departments){
		List<DepartmentResponseDao> departmentResponseDaos = new ArrayList<>();
		for(Department department:departments) {
			departmentResponseDaos.add(departmentToDepartmentResponseDao(department));
		}
		return departmentResponseDaos;
	}
}
