package com.example.qnmd.pojo;

/**
 * 用户
 * 
 * @author xxm
 *
 */
public class User {

	String uid;//登录账号
	String password;//密码
	String permission;//权限：管理员、一般用户
	String eid;//员工号
	
	public User() {
		
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}


	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

}
