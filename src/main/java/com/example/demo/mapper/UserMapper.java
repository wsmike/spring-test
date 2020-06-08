package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")
	List<User> findAll();

	@Select("SELECT * FROM user where id = #{id}")
	User getUser(Integer id);

	@Insert("INSERT INTO `user` (username,sex,birthday,address) VALUES (#{name},#{sex},#{birthday},#{address})")
	Integer insert(@Param("name")String name, @Param("sex")String sex,
				   @Param("birthday")String birthday, @Param("address")String address);


	@Insert("INSERT INTO `user` (username,sex,birthday,address) VALUES (#{username},#{sex},#{birthday},#{address})")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	Integer insertUser(User user);

	@Update("Update `user` set username = #{username},sex = #{sex},birthday = #{birthday},address = #{address} where id = #{id}")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	Integer updateUser(User user);

}
