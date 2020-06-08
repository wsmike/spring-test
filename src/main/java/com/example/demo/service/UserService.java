package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;
import java.sql.Date;
import java.util.Map;

public interface UserService {
	
	/**
	 * 根据接口查询所用的用户
	 */
	public List<User> findAllUser();

	public User getUser(Integer id);

	public Integer insertUser(String name, String sex, Date birthday, String address);

	public Integer insert(String name, String sex, String birthday, String address);

	public Integer updateUser(Integer id, String name, String sex, Date birthday, String address);
}
