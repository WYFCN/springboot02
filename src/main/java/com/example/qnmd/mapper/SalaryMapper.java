package com.example.qnmd.mapper;

import java.util.List;

import com.example.qnmd.pojo.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SalaryMapper {
	//统计总工资
	@Select("select sum(paid) from salarys")
	public double sum();
	
	//平均工资
		@Select("select avg(paid) from salarys")
		public double aver();
	
	/**
	 * 按日期查询
	 * @param month
	 * @return
	 */
	@Select("select * from salarys where month = #{month}")
	public List<Salary> findByDate(int month);
	
	/**
	 * 按员工号查询
	 * @param eid
	 * @return
	 */
	@Select("select * from salarys where eid = #{eid}")
	public List<Salary> findByEid(String eid);
	
	/**
	 * 按员工号和月份查询
	 * @param eid
	 * @param month
	 * @return
	 */
	@Select("select * from salarys where eid = #{eid} and month = #{month}")
	public Salary findByEM(@Param("eid") String eid, @Param("month") int month);
	
	/**
	 * 添加新员工的工资信息
	 * @param s Salary对象
	 * @return
	 */
	@Insert("insert into salarys(sid,eid,month,noattendance,allowance) values(#{sid},#{eid},#{month},#{noattendance},#{allowance})")
	public boolean create(Salary s);
	
	/**
	 * 删除员工工资信息
	 * @param eid 员工号
	 * @return
	 */
	@Delete("delete from salarys where eid=#{eid}")
	public boolean remove(String eid);
//	
//	//通过员工号获得对应的职位,再通过职位获得底薪
//	@Select("select baseWage from salarys,employee,wageconfig where salarys.eid=employee.eid and employee.wid=wageconfig.wid and employee.eid = #{eid}")
//	public double getBaseWage(String eid);
	
	//计算实发工资=基本工资+考勤+津贴
	@Update("update salarys s join (select salarys.eid,wageconfig.baseWage from salarys,employee,wageconfig where salarys.eid=employee.eid and employee.wid=wageconfig.wid) t \r\n" + 
			"set paid=(-noattendance*100+allowance+t.baseWage)where s.eid=t.eid and s.eid=#{eid} and month=#{month};")
	public boolean updateWage(@Param("eid") String eid, @Param("month") int month);
	
	
}
