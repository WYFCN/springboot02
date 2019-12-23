package com.example.qnmd.pojo;

/**
 * 底薪设置
 * @author Administrator
 *
 */
public class WageConfig {
	String wid;//职位ID
	String position;//职位
	double baseWage;//底薪
	String dno;//部门号
	
	public WageConfig() {
		
	}

	
	public String getWid() {
		return wid;
	}


	public void setWid(String wid) {
		this.wid = wid;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getBaseWage() {
		return baseWage;
	}

	public void setBaseWage(double baseWage) {
		this.baseWage = baseWage;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}
	
	
}
