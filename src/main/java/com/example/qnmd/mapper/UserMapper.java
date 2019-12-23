package com.example.qnmd.mapper;

import java.util.List;

import com.example.qnmd.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

	/**
	 * 根据用户账号和密码查询用户信息
	 * @param uid 账号
	 * @param password 密码
	 * @return
	 */
	@Select("select * from user where uid=#{uid} and password=#{password}")
	public User findUser(@Param("uid") String uid, @Param("password") String password);
	
	//根据账号查询用户
	@Select("select * from user where uid=#{uid}")
	public User find(@Param("uid") String uid);
	
	
	/**
	 * 根据账号删除用户
	 * @param uid 账号
	 */
	@Delete("delete from user where uid=#{uid}")
	public boolean remove(String uid);
	
	/**
	 * 查询所有用户信息
	 * @return 用户列表
	 */
	@Select("select * from user")
	public List<User> findAll();
	
	/**
	 * 添加新的用户
	 * @param u
	 */
	@Insert("insert into user(uid,eid,password,permission) values(#{uid},#{eid},#{password},#{permission})")
	public void create(User u);
	
	//获得密码
	@Select("select password from user where uid=#{uid} ")
	public String getpwd(String uid);
	
	//修改密码
	@Update("update user set password=#{password} where uid=#{uid}")
	public int changepwd(@Param("uid") String uid, @Param("password") String password);
}
