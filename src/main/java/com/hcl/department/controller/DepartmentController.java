package com.hcl.department.controller;

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

import com.hcl.department.dto.DepartmentDTO;
import com.hcl.department.entity.Department;
import com.hcl.department.service.IDepartmentService;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

	@Autowired
	IDepartmentService service;

	@PostMapping("/add")
	public Department addDepartment(@RequestBody DepartmentDTO dto) {
		return service.addDepartment(dto);
	}
	
	@GetMapping("/get")
	public List<Department> getAllDepartmet(){
		return service.getAllDepartment();
	}
	
	@GetMapping("/get/{id}")
	public Department getDepartmentById(@PathVariable long id) {
		return service.getDeptById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDTO dto, @PathVariable("id") long id){
		return new ResponseEntity<Department>(service.updateDepartment(dto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Department deleted successfully", HttpStatus.OK);
	}
}
