package com.hcl.department.service;

import java.util.List;

import com.hcl.department.dto.DepartmentDTO;
import com.hcl.department.entity.Department;


public interface IDepartmentService {
	
	
	public Department  addDepartment(DepartmentDTO departmentDTO);
	
	public Department   getDeptById(long id);
	
	public List<Department> getAllDepartment();

	public Department updateDepartment(DepartmentDTO departmentDTO, long id);

	public void deleteDepartment(long id);

}
