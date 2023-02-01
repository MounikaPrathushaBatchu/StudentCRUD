package com.example.std.rest;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.std.model.Department;
import com.example.std.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
	
	@Autowired
	private DepartmentService service;
//	@Autowired
//	private Department department;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveDepartment(@RequestBody Department department){
		Long id = service.savedepartment(department);
		return new ResponseEntity<String>("department '"+id+"' saved",HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<List<Department>> getAllDepartments(){
		List<Department> list = service.getAllDepartments();
		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
	}
	@GetMapping("/get/page{number}")
	public ResponseEntity<List<Department>> getAllDepartmentsinPage(@PathVariable int number){
		List<Department> list = service.getAllDepartmentsinPage(number);
		return new ResponseEntity<List<Department>>(list,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Department> getOneDepartment(@PathVariable Long id){
		Department department = service.getOneDepartment(id);
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateDepartment(@PathVariable Long id,@RequestBody Department department){
		Department departmentdb = service.getOneDepartment(id);
		departmentdb.setName(department.getName());
		service.savedepartment(departmentdb);
		return new ResponseEntity<String>("Department '"+id+"' updated",HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Department '"+id+"' deleted",HttpStatus.OK);
	}
//	@GetMapping("/active")
//	public ResponseEntity<List<Department>> getAllActiveDepartments(){
//		if(department.active != false) {
//			List<Department> list = service.getAllDepartments();
//		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
//		}
//		else {
//			return null;
//		}
//	}
}
