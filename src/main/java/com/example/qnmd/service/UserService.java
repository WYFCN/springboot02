package com.example.qnmd.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.qnmd.mapper.EmployeeMapper;
import com.example.qnmd.mapper.UserMapper;
import com.example.qnmd.mapper.WageconfigMapper;
import com.example.qnmd.pojo.Employee;
import com.example.qnmd.pojo.User;
import com.example.qnmd.pojo.WageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * user页面跳转
 * 
 * @author xxm
 *
 */
@Service
public class UserService {

	//依赖注入
	@Autowired
	UserMapper umapper;
	
	@Autowired
	EmployeeMapper emapper;
	@Autowired
	WageconfigMapper wmapper;
	
	/**
	 * 检查用户登录    验证身份    并跳转页面
	 * @param uid 账号
	 * @param password 密码
	 * @param session
	 * @return
	 */
	public String checkUser(String uid,String password,HttpSession session) {
		//根据用户账号密码获得对应的用户

		User user = umapper.find(uid);
		
		//用户不存在user表中，重新登录
		if(user==null) {
			session.setAttribute("error", "用户不存在");
			return "login";
		}
		user = umapper.findUser(uid, password);
		if(user==null) {
			session.setAttribute("error", "密码错误");
			return  "login";
		}
		session.removeAttribute("error");
		//获得员工信息
		Employee employee = emapper.findByEid(user.getEid());
		//获得职位信息
		WageConfig wageconfig=wmapper.getWageconfig(employee.getWid());
	
		//不为空，将账号密码保存在session里
		session.setAttribute("UID", user.getUid());
		session.setAttribute("PASSWD", user.getPassword());
		session.setAttribute("QUA", user.getPermission());
		session.setAttribute("EMAIL", employee.getEmail());
		session.setAttribute("PHONE", employee.getPhone());
		session.setAttribute("IMG", employee.getPicture());
		System.out.println(user.getPermission());
		session.setAttribute("NAME", employee.getEname());
		session.setAttribute("DUTY", wageconfig.getPosition());
		session.setAttribute("DNO", wageconfig.getDno());
		session.setAttribute("BASEWAGE", wageconfig.getBaseWage());
		if(user.getPermission().equals("admin")) {
			return "mlogin";
		}
		else
			
				return "employee";

	}
	
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		if(user.getUid()=="") {
			return false;
		}
		else {
			user.setEid(user.getUid());
			user.setPassword(user.getUid());
			user.setPermission(user.getPermission()==""?"gener":"admin");
			//创建
			umapper.create(user);
			return true;
		}
	}

	/**
	 * 删除用户
	 * @param eid 员工号/账号
	 * @return
	 */
	public boolean delUser(String eid) {
		if(umapper.remove(eid)) {
			
			return true;
		}else {
			return false;
		}
	}


	/**
	 * 得到所有用户
	 * @return 用户列表
	 */
	public List<User> getUsers(){
		List<User> users = umapper.findAll();
		for(User user:users) {
			//密码保护
			user.setPassword("******");
		}
		return users;
	}
	
	/**
	 * 修改密码
	 * @param map
	 * @param employeeID
	 * @return
	 */
	public String checkpwd(HashMap<String, String> map, String employeeID) {
		String pwd = umapper.getpwd(employeeID);
		if (!map.get("oldpwd").equals(pwd)) {
			return "erropwd";
		}

		if (!map.get("pwd1").equals(map.get("pwd2"))) {
			return "noequal";
		}

		if (map.get("pwd1").equals(map.get("pwd2")))

			umapper.changepwd(employeeID, map.get("pwd2"));
		return "ok";
	}


}


