package com.example.qnmd.control;

import java.util.List;

import com.example.qnmd.pojo.WageConfig;
import com.example.qnmd.service.WageconfigService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基本工资设置
 * @author Administrator
 *
 */
@Controller

public class WageconfigController {

	@Autowired
	WageconfigService wageService;
	
	//添加新的工种
	@PostMapping("/position")
	public boolean addPosition(@RequestBody WageConfig wc) {
		return wageService.addDuty(wc);
	}
	
	/**
	 * 得到相应部门的岗位信息列表
	 * @param departmentName
	 * @return
	 */
	@GetMapping("/dutyList")
	public List<WageConfig> getWageList(String departmentName) {
		System.out.println(departmentName+"****");
		return wageService.getDutyList(departmentName);
	}
	
	/**
	 * 所有职位
	 */
	@GetMapping("/dutys")
	@ResponseBody
	public List<String> getWageList() {
		
		return wageService.getDutyList();
	}
	
}
