package com.example.qnmd.control;

import java.util.List;

import com.example.qnmd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 得到部门列表
	 * @return
	 */
	@GetMapping("/department")
	public List<String> findDepartmentName() {
		System.out.println(departmentService.findDepartmentName());
		return departmentService.findDepartmentName();
	}
	
}
