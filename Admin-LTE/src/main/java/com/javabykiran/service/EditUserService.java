package com.javabykiran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.EditUserDao;
import com.javabykiran.model.Users;


@Service
public class EditUserService {
	
	@Autowired
	EditUserDao editUserDao;
		
	public List<Users> editdata(int id) {
		System.out.println("i am in edit Service");
		return editUserDao.getData(id);
		
	}
	public boolean updateUser(Users user) {
	    
	    return editUserDao.updateUser(user);
	
}
		
	}
	

