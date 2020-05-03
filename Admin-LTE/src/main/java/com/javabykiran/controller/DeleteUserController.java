package com.javabykiran.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.service.DeleteUserService;
import com.javabykiran.service.User_Service;


@Controller
public class DeleteUserController {
	
	@Autowired
	DeleteUserService deleleUserService;
	
	@Autowired
	User_Service user_service;
	
	
	
	@RequestMapping(value="/deleteData")
	public ModelAndView doDelete(@RequestParam int id) {
		
		System.out.println("I am in delete servlet");
		System.out.println(id);
		ModelAndView mv= new ModelAndView();
		deleleUserService.deleteData(id);
		
		ArrayList<Users> list=user_service.loadUsers();
		mv.addObject("listusers", list);
		System.out.println("View Resolver");
		mv.setViewName("dashboard");
		return mv;
		
	}
	@RequestMapping("/multipleDelete")
	public ModelAndView doMultiDelete(@RequestParam(value = "id[]", required = false) int[] id ) {
		
		ModelAndView mv= new ModelAndView();
		if(id!=null) {
			System.out.println("checkbox is checked " +id.length);
		}
		
		System.out.println("controller");
		deleleUserService.deleteMultiData(id);
		
		ArrayList<Users> list=user_service.loadUsers();
		mv.addObject("userlist", list);
		mv.setViewName("dashboard");
		return mv;
		
	}
	
	}

