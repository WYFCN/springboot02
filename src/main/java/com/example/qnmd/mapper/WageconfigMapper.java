package com.example.qnmd.mapper;

import java.util.List;

import com.example.qnmd.pojo.WageConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface WageconfigMapper {

	//添加职位信息
	@Insert("insert into wageconfig(wid,position,dno,baseWage) values(#{wid},#{position},#{dno},#{baseWage})")
	public boolean addPosition(WageConfig wc);
	
	//部门号获得职位
	@Select("select * from wageconfig where dno=#{dno}")
	public List<WageConfig> getWid(@Param("dno") String dno);
	
	//获得职位信息
	@Select("select * from wageconfig where wid=#{wid}")
	public WageConfig getWageconfig(String wid);

	@Select("select position from wageconfig")
	public List<String> getWids();
	
	@Select("select * from wageconfig")
	public List<WageConfig> getWids2();
	
	@Select("select position from wageconfig where wid=#{wid}")
	public String getId(@Param("wid") String wid);
	
	
}
