package com.example.qnmd.mapper;

import java.util.List;

import com.example.qnmd.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface EmployeeMapper {
	
	/**
	 * 查询所有员工
	 * @return
	 */
	@Select("select *from employee")
	public List<Employee> getEmployee();

	
	/**
	 * 根据员工号查询
	 * @param eid 员工号
	 * @return
	 */
	@Select("select * from employee where eid=#{eid}")
	public Employee findByEid(String eid);

	/**
	 * 根据部门查询
	 * @param dno
	 * @return
	 */
	@Select("select *from employee,department,wageconfig where wageconfig.dno=department.dno  and employee.wid=wageconfig.wid and department.dno=#{dno} ")
	public List<Employee> findByDepart(String dno);
	
	/**
	 * 删除员工信息
	 * @param eid 员工号
	 */
	@Delete("delete from employee where eid=#{eid} and ename=#{ename}")
	public boolean remove(@Param("eid") String eid, @Param("ename") String ename);
	
	/**
	 * 添加新的员工
	 * @param e
	 * @return
	 */
	@Insert("insert into employee(eid,ename,wid,entryDate) values(#{e.eid},#{e.ename},#{e.wid},#{e.entryDate})")
	public boolean create(@Param("e") Employee e);
	
	//更新员工邮箱和电话
	@Update("update employee set email=#{email} ,phone=#{phone} where eid=#{eid}")
	public boolean update2(@Param("email") String email, @Param("phone") String phone, @Param("eid") String eid);

	//同一部门
	@Select("select eid,ename,employee.wid,entryDate,phone,email from employee,department,wageconfig  where employee.wid=wageconfig.wid and department.dno=wageconfig.dno and department.dno=#{dno}")
	public List<Employee> getEmployeeList(@Param("dno") String dno);

	//更新头像
	@Update("update employee set picture=#{picture} where eid=#{eid} ")
	public boolean setPic(@Param("picture") String picture, @Param("eid") String eid);
}
