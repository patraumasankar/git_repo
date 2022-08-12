package com.hcl.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.department.dto.DepartmentDTO;
import com.hcl.department.entity.Department;
import com.hcl.department.repository.DepartmentRepository;


@Service
public class DepartmentServiceImp implements IDepartmentService {

	@Autowired
	DepartmentRepository repo;

	@Override
	public Department addDepartment(DepartmentDTO departmentDTO) {

		Department dept = new Department();

		dept.setDepartmentName(departmentDTO.getDepartmentName());
		dept.setDepartmentAddress(departmentDTO.getDepartmentAddress());
		dept.setDepartmentCode(departmentDTO.getDepartmentCode());

		return repo.save(dept);
	}

	@Override
	public Department getDeptById(long id) {
		return repo.findById(id).orElse(new Department());
	}

	@Override
	public List<Department> getAllDepartment() {
		return repo.findAll();
	}

	@Override
	public Department updateDepartment(DepartmentDTO departmentDTO, long id) {
		
		Department updateDept = getDeptById(id);
		
		updateDept.setDepartmentName(departmentDTO.getDepartmentName());
		updateDept.setDepartmentAddress(departmentDTO.getDepartmentAddress());
		updateDept.setDepartmentCode(departmentDTO.getDepartmentCode());

		return repo.save(updateDept);
	}

	@Override
	public void deleteDepartment(long id) {
		repo.deleteById(id);
	}

	
}
