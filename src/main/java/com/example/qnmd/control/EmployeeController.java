package com.example.qnmd.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.qnmd.pojo.Employee;
import com.example.qnmd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工类的相关操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//获得指定部门的员工
	@GetMapping("/findEmployee/{department}")
	@ResponseBody
	public List<Employee> getEmployee(@PathVariable String department){
		List <Employee> list = employeeService.showEmployees(department);
		return list;
	}
	
	//添加员工信息
	@PostMapping("/addemploy")
	@ResponseBody
	public String addEmployee(@RequestBody Employee e) {
		System.out.println(employeeService.addEmployee(e));
		if(employeeService.addEmployee(e)) {
			System.out.println("1_______"+e.getEid());
			return "ok";
		}
		else {
			System.out.println("2_______"+e.getEid());
			return "error";
		}
	}
	
	//获得员工列表
	@GetMapping("/getE")
	@ResponseBody
	public List<Employee> getUsers(){
		return employeeService.getEmployee();
	}
	
	//删除指定的员工
	@PostMapping("/deluser")
	@ResponseBody
	public Map<String,Object> delUsers(@RequestBody Employee e){
		Map<String,Object> map = new HashMap<String, Object>();
		
		System.out.println(e.getEid());
		if((boolean)employeeService.delUser(e.getEid(), e.getEname())) {
			System.out.println(1);
			map.put("e",e);
			map.put("msg", "ok");
		}else {
			map.put("msg", "fail");
			System.out.println(2);
		}
			
		
		return map;
		
	}
	
	//获得员工人数
	//获得员工列表
		@GetMapping("/sumE")
		@ResponseBody
		public int getNum(){
			List<Employee> list=employeeService.getEmployee();
			int num=list.size();
			return num;
		}

}
