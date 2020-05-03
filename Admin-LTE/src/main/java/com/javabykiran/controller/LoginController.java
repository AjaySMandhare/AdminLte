package com.javabykiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.User;
import com.javabykiran.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	


	@RequestMapping(value = "/")
	public ModelAndView loginpage() {
		
		System.out.println("I am in Login Auto Page");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/registerpage")
	public ModelAndView registerpage() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/login")
	public ModelAndView checkLogin(@ModelAttribute User user) {
		System.out.println("user >>> " + user);
		System.out.println("checkLogin...........");
		ModelAndView mv = new ModelAndView();
		if (loginService.checkLogin(user)) {
			mv.setViewName("dashboard");
			
		} else {
			mv.addObject("msg", "your passwd is wrong..");
			mv.setViewName("login");
		}
		return mv;
	}
	
	
	


}
