package com.example.qnmd.control;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.qnmd.pojo.User;
import com.example.qnmd.service.EmployeeService;
import com.example.qnmd.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	//登录,验证身份跳转
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		return userService.checkUser(user.getUid(), user.getPassword(), session);
	}
	
	//添加新的用户信息
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//删除用户
	@PostMapping("/delUser")
	public boolean delUser(@RequestBody String uid) {
		return userService.delUser(uid);
	
	}
	
	//退出
	@GetMapping("/back")
	public String back(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("UID");
		return "login";
	}

	//修改密码
	@PostMapping("/changpwd")
	@ResponseBody
	public String changepwd(@RequestBody HashMap<String, String>map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		return userService.checkpwd(map,EmployeeID);
	}
	@GetMapping("/register")
	public String toRegister(){
		return "register";
	}
	@PostMapping(value = "/registerrr")
	public String register(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password,
						   @RequestParam(value = "email") String email,HttpServletRequest req){
		HttpSession session = req.getSession();
		session.setAttribute("us",username);
		session.setAttribute("pas",password);
		session.setAttribute("email11",email);
		int num = (int)(Math.random()*(9999-1111+1)+9999);
		String numm=String.valueOf(num);
		session.setAttribute("code",numm);
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件设置
		message.setSubject("验证码");
		message.setText(numm);
		message.setTo(email);
		message.setFrom("1270065107@qq.com");
		mailSender.send(message);
		return "activeSuccess";
	}
	@PostMapping("/yan")
	public String yanz(@RequestParam("code") String code,HttpServletRequest req)
	{
		System.out.println("#################");
		System.out.println(code);
		System.out.println("#################");
		HttpSession session = req.getSession();
		String numm= (String) session.getAttribute("code");
		String username= (String) session.getAttribute("us");
		String password= (String) session.getAttribute("pas");
		System.out.println(numm+" "+username+" "+password+" "+code);
		if(numm.equals(code)){
			User user=new User();
			user.setPassword(password);
			user.setPermission("yuangong");
			user.setUid(username);
			userService.addUser(user);
			return "success";
		}
		else
			return "error";
	}
}

