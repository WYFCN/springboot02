package com.example.qnmd.service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.qnmd.mapper.DepartmMapper;
import com.example.qnmd.mapper.EmployeeMapper;
import com.example.qnmd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 员工类页面操作控制
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeMapper emapper;
	@Autowired
	DepartmMapper departmentMapper;
	@Autowired
	WageconfigService wageService;
	/**
	 * 按部门查询员工
	 * @param DepartmentName
	 * @return 员工列表
	 */
	public List<Employee> showEmployees(String DepartmentName){
		
			System.out.println(DepartmentName);
			
			//通过部门名称，查询部门ID		
			String departmentID = departmentMapper.findDepartmentID(DepartmentName);
			
			//通过部门ID，查询部门所有员工
			List<Employee> employees = emapper.getEmployeeList(departmentID);
			for(Employee e:employees) {
				e.setWid(wageService.getId(e.getWid()));
				System.out.println(e.getWid());
			}
			return employees;
		
		
	}
	
	/**
	 * 添加员工
	 * @param e Employee对象
	 * @return
	 */
	public boolean addEmployee(Employee e) {
		return emapper.create(e);
	}
	
	//更新电话和邮箱
	public boolean setEmploy(String email,String phone,String eid,HttpSession session) {
		
		if( emapper.update2(email, phone, eid)) {
			session.setAttribute("EMAIL", email);
			session.setAttribute("PHONE", phone);

			return true;
		}else return false;
	}

	//获得所有员工
	public List<Employee> getEmployee() {
		
		return emapper.getEmployee();
	}
	//保存图片路径
	public void setPic(String picture,String eid,HttpSession session) {
		emapper.setPic(picture,eid);
		
		session.setAttribute("IMG", picture);
		 
	}
	
	public Employee getEm(String eid) {
		return emapper.findByEid(eid);
	}
	
	//删除员工
	public boolean delUser(String eid,String ename) {
		return  emapper.remove(eid, ename);
		
	}
}
