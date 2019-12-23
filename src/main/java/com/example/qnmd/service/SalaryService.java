package com.example.qnmd.service;

import java.util.ArrayList;
import java.util.List;

import com.example.qnmd.mapper.EmployeeMapper;
import com.example.qnmd.mapper.SalaryMapper;
import com.example.qnmd.mapper.WageconfigMapper;
import com.example.qnmd.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
	@Autowired
	SalaryMapper smapper;
	
	@Autowired
	WageconfigMapper wmapper;
	
	@Autowired
	EmployeeMapper emapper;
	
	/**
	 * 添加薪资信息
	 * @param s
	 * @return
	 */
	public boolean addSalary(Salary s) {
		if(smapper.create(s)) {
			return true;
		}else 
			return false;
	}
	
	//获得全部月份的个人薪资（按个人查询）
	public List<Salary> getAll(String eid){
		return smapper.findByEid(eid);
	}
	
	//按月份查询个人薪资（按月份、个人查询）
	public Salary getSalary(String eid,int month) {
		Salary s =  smapper.findByEM(eid, month);
		
		return s;
	}

	public List<Salary> getSalary1(String month, String employeeID) {
		

			List<Salary> list = this.getAll(employeeID);
			int sum = 0;
			
			
			/**
			 * 如果为年底，发放年终奖，年终奖的计算：
			 * 年终奖 = (一年的总薪资/12)
			 * 12月发放年终奖
			 */
			for (Salary s : list) {
				
				sum+=s.getPaid();
				if(s.getMonth()==12) {
					s.setPaid(s.getPaid()+sum/12);
				}
			}
			
			System.out.println(list);
			
			if(month.equals("全部")) {
				return list;
			}else {
				int m = Integer.parseInt(month);
				//删除不相关的月份			
				for(int i = 0;i<list.size();i++) {
					if(list.get(i).getMonth()!=m) {
						list.remove(i--);
					}
				}
				return list;
			}
		}
	
	//全部总工资
	public double allPaid() {
		return smapper.sum();
	}
	
	//全部总工资
		public double avgPaid() {
			return smapper.aver();
		}
}
