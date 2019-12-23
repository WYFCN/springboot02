package com.example.qnmd.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.qnmd.mapper.SalaryMapper;
import com.example.qnmd.pojo.Salary;
import com.example.qnmd.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 工资
 * 
 * @author xxm
 *
 */
@RestController

public class SalaryController {

	@Autowired
	SalaryService salaryService;
	@Autowired
	SalaryMapper smapper;
	
	//获得当前用户个人全部薪资信息
	@GetMapping("/salarylist")
	public Map<String,Object> getSalary(String month,HttpServletRequest req){
		//获得uid eid
		String employeeID = (String) req.getSession().getAttribute("UID");
		//存储容器
		Map<String,Object> map = new HashMap<String,Object>();
		List<Salary> list = this.getSalary(month, employeeID, req);
		
			map.put("list", list);
		
		return map;
	}
	

	@GetMapping("/salarylist/{employeeID}/{month}")
	public List<Salary> getSalary(@PathVariable String month,@PathVariable String employeeID,HttpServletRequest req){
		System.out.println(month + " "+employeeID);
		return salaryService.getSalary1(month, employeeID);
	}
	
	//添加薪资信息（eid，考勤，津贴，日期）
	@PostMapping("/addSalary")
	public boolean addSalary(@RequestBody Salary s) {
		return salaryService.addSalary(s);
	}
	
//	//管理员一键计算实发工资
//	@PostMapping("/caculate")
//	public boolean update() {
//		return smapper.updateWage();
//	}
	
	@PostMapping("/checkstat")
	public String  checkstat(@RequestBody Salary s) {
		if( salaryService.addSalary(s)) {
			smapper.updateWage(s.getEid(),s.getMonth());
			System.out.println(s.getPaid());
			return "ok";
		}else return "fail";
	}
	
	//获得薪资表全部薪资信息
	@GetMapping("/sumpaid")
	public double sum(){
		return salaryService.allPaid();
	}
	
	//获得平均薪资
		@GetMapping("/averpaid")
		public double aver(){
			return salaryService.avgPaid();
		}
}
