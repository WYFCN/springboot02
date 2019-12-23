package com.example.qnmd.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	//
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	//添加员工
		@GetMapping("/addE")
		public String addE(HttpServletRequest req) {
			HttpSession session = req.getSession();
			String EmployeeID = (String) session.getAttribute("UID");
			System.out.println(EmployeeID);
			if(EmployeeID==null) {
				return "login";
			}
			return "addemployee";
		}
	
	//添加用户
	@GetMapping("/adduser")
	public String addAnddel(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		System.out.println(EmployeeID);
		if(EmployeeID==null) {
			return "login";
		}
		return "addUser";
	}
	
	@GetMapping("/m")
	public String manager(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "manager";
	}
	
	@GetMapping("/info")
	public String employeeinfo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "employeeinfo";
	}
	
	@GetMapping("/e")
	public String employee(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "employee";
	}
	
	@GetMapping("/position")
	public String duty(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "wageConfig";
	}
	
	@GetMapping("/salary")
	public String salary(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "salary";
	}
	
	@GetMapping("/salaryInfo")
	public String salaryInfo() {
		return "salaryInfo";
	}
	
	@GetMapping("/finddutys")
	public String finddutys() {
		return "finddutys";
	}
	
	@GetMapping("/findemployees")
	public String findemployees(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "findemployees";
	}
	
	@GetMapping("/mlogin")
	public String mlogin() {
		return "mlogin";
	}
	
	@GetMapping("/addcheckstat")
	public String addcheckstat(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "addcheckstat";
	}
	
	@GetMapping("/delUser")
	public String delUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "delUser";
	}
	
	@GetMapping("/tables")
	public String getTables(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		if(EmployeeID==null) {
			return "login";
		}
		return "table";
	}
}
