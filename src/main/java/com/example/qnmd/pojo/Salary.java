package com.example.qnmd.pojo;

import java.sql.Date;

/**
 * 工资实体
 * 
 * @author xxm
 *
 */
public class Salary {
	int sid;//序号
	String eid;//员工号
	int month;//月
	
	int noattendance;//没有按时出勤de天数（一个月）
	double allowance;//津贴
	double paid;//实发工资
	
	public Salary() {
		
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getNoattendance() {
		return noattendance;
	}

	public void setNoattendance(int noattendance) {
		this.noattendance = noattendance;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	
	
}
