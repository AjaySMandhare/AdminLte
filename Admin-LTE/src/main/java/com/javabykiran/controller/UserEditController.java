package com.javabykiran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.service.EditUserService;
import com.javabykiran.service.User_Service;



@Controller
public class UserEditController {
	
	@Autowired
	EditUserService editUser;
	
	@Autowired
	User_Service userservice;
	
	@RequestMapping("/editData")
	public ModelAndView doEdit(@RequestParam("id") int id) {
		ModelAndView mv= new ModelAndView();
		System.out.println("i am edit controller >> "+ id);
		List<Users> user= editUser.editdata(id);
		 mv.setViewName("updated");
		 mv.addObject("user", user);
		return mv;
	}

	
@RequestMapping("/updateData")
public ModelAndView update(@ModelAttribute Users user) {
	ModelAndView mv= new ModelAndView();
	System.out.println("i am edit controller >> "+ user);
	boolean check= editUser.updateUser(user);
	if(check)
	{
		ArrayList<Users> list=userservice.loadUsers();
		System.out.println("updated");
		mv.setViewName("dashboard");
		mv.addObject("userlist", list);
	}
	else
	{
		mv.setViewName("updated");
		mv.addObject("user", "not updated");
	}
	 return mv;
}
}


