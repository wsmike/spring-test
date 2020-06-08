package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;


	public List<User> findAllUser() {
		System.out.println("查询!!!");
		List<User> list = userMapper.findAll();
		return list;
	}

	public User getUser(Integer id){
		System.out.println("查询单个!!!");
		User user = userMapper.getUser(id);
		return user;
	}

	public Integer insert(String name, String sex, String birthday, String address) {
		return userMapper.insert(name,sex,birthday,address);
	}

	public Integer insertUser(String name, String sex, Date birthday, String address) {
		User user = new User();

		user.setUsername(name);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setAddress(address);

		userMapper.insertUser(user);
		System.out.println(user);
		return user.getId();
	}

	public Integer updateUser(Integer id, String name, String sex, Date birthday, String address) {
		User user = new User();

		user.setId(id);
		user.setUsername(name);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setAddress(address);

		userMapper.updateUser(user);
		System.out.println(user);
		return user.getId();
	}
}
