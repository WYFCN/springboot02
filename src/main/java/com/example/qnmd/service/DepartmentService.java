package com.example.qnmd.service;

import java.util.ArrayList;
import java.util.List;

import com.example.qnmd.mapper.DepartmMapper;
import com.example.qnmd.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmMapper departmentMapper;
	
	/**
	 * 返回部门名称列表
	 * @return
	 */
	public List<String> findDepartmentName(){
		List<String> departmentNameList = new ArrayList<String>();
		List<Department> departmentList = departmentMapper.findDepartment();
		for (Department department : departmentList) {
			departmentNameList.add(department.getDname());
		}
		return departmentNameList;
	}
	
	public String getDepartmentID(String departmentName) {
		return departmentMapper.findDepartmentID(departmentName);
	}
}
