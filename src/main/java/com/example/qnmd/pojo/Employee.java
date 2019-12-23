package com.example.qnmd.pojo;

import java.io.File;
import java.sql.Date;

/**
 * 员工实体
 * 
 * @author xxm
 *
 */
public class Employee {

	String eid;//员工号
	String ename;//员工姓名
	String wid;//职位ID
	Date entryDate;//入职时间
	String phone;//电话
	String email;//邮箱
	String picture;
	
	public Employee() {
		
	}

	
	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
