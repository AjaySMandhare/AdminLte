package com.javabykiran.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.User_Dao;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;


@Service
public class User_Service {
	
	@Autowired
	private User_Dao user_Dao;
	
	public boolean register(User user)
	{
		Serializable id=user_Dao.register(user);
		if(id!=null)
			return true;
		else
			return false;
		
	}
	
	public boolean addUser(Users users)
	{
		Serializable id=user_Dao.addUser(users);
		if(id!=null)
			return true;
		else
			return false;
		
	}
	
	public List<Users> userList()
	{
		List<Users>list=user_Dao.userList();
		return list;
	}
	
	public ArrayList<Users> loadUsers() {
		return (ArrayList<Users>) user_Dao.loadUser();
	}
	
	
	
	}
