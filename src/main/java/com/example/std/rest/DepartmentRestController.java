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

import com.example.std.service.DepartmentService;

import dao.RequestDao.DepartmentRequestDao;
import dao.ResponseDao.DepartmentResponseDao;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
	
	@Autowired
	private DepartmentService DepartmentService;
	
	@PostMapping("/add")
	public ResponseEntity<DepartmentResponseDao> addDepartment(@RequestBody DepartmentRequestDao departmentRequestDao){
		DepartmentResponseDao departmentResponseDao = DepartmentService.addDepartment(departmentRequestDao);
		return new ResponseEntity<>(departmentResponseDao,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<DepartmentResponseDao> getCategory(@PathVariable Long id){
		DepartmentResponseDao departmentResponseDao = DepartmentService.getDepartmentById(id);
		return new ResponseEntity<>(departmentResponseDao,HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<DepartmentResponseDao>> getDepartments(){
		List<DepartmentResponseDao> departmentResponseDaos = DepartmentService.getDepartments();
		return new ResponseEntity<>(departmentResponseDaos,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DepartmentResponseDao> deleteDepartment(@PathVariable Long id){
		DepartmentResponseDao departmentResponseDao = DepartmentService.deleteDepartment(id);
		return new ResponseEntity<>(departmentResponseDao,HttpStatus.OK);
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<DepartmentResponseDao> editDepartment(@RequestBody DepartmentRequestDao departmentRequestDao,@PathVariable Long id){
		DepartmentResponseDao departmentResponseDao = DepartmentService.editDeprtment(id, departmentRequestDao);
		return new ResponseEntity<>(departmentResponseDao,HttpStatus.OK);
	}
	
////	@Autowired
//	private Department department;
//	
//	@PostMapping("/save")
//	public ResponseEntity<String> saveDepartment(@RequestBody Department department){
//		Long id = service.savedepartment(department);
//		return new ResponseEntity<String>("department '"+id+"' saved",HttpStatus.OK);
//	}
//	@GetMapping("/get")
//	public ResponseEntity<List<Department>> getAllDepartments(){
//		List<Department> list = service.getAllDepartments();
//		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
//	}
//	@GetMapping("/get/page{number}")
//	public ResponseEntity<List<Department>> getAllDepartmentsinPage(@PathVariable int number){
//		List<Department> list = service.getAllDepartmentsinPage(number);
//		return new ResponseEntity<List<Department>>(list,HttpStatus.OK);
//	}
//	@GetMapping("/get/{id}")
//	public ResponseEntity<Department> getOneDepartment(@PathVariable Long id){
//		Department department = service.getOneDepartment(id);
//		return new ResponseEntity<Department>(department, HttpStatus.OK);
//	}
//	@PutMapping("/update/{id}")
//	public ResponseEntity<String> updateDepartment(@PathVariable Long id,@RequestBody Department department){
//		Department departmentdb = service.getOneDepartment(id);
//		departmentdb.setName(department.getName());
//		service.savedepartment(departmentdb);
//		return new ResponseEntity<String>("Department '"+id+"' updated",HttpStatus.OK);
//	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
////		service.deleteDepartment(id);
//		if(department.isDelete_status() == false) {
//			department.setDelete_status(true);
//		}
//		return new ResponseEntity<String>("Department '"+id+"' deleted",HttpStatus.OK);
//	}
//	@GetMapping("/active")
//	public ResponseEntity<List<Department>> getAllActiveDepartments(){
//		List<Department> list = null;
//		while(department.getId() != null) {
//		if(department.isActive() == true) 
//			list = service.getAllDepartments();
//		else 
//			return null;
//		}
//		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
//	}
}
