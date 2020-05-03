package com.javabykiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.User;
import com.javabykiran.model.Users;
import com.javabykiran.service.User_Service;

@Controller
public class User_Controller {

	@Autowired
	private User_Service user_Service;

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("model") User user, Model model) {
		System.out.println(user.getEmail());
		boolean b = user_Service.register(user);
		if (b == true) {
			model.addAttribute("msg", "Added Successfully");
			return new ModelAndView("login");
		} else {
			model.addAttribute("msg", "Not Added ");
			return new ModelAndView("register");
		}

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("model") Users user, Model model) {
		System.out.println(user);
		System.out.println(user.getEmail());
		boolean b = user_Service.addUser(user);
		if (b == true) {
			model.addAttribute("msg", "Added Successfully");
			return new ModelAndView("dashboard");
		} else {
			model.addAttribute("msg", "Not Added ");
			return new ModelAndView("add_user");
		}

	}

	@RequestMapping(value = "/userList")
	public ModelAndView userList(Model model) {
		ModelAndView mv = new ModelAndView();
		List<Users> userList = user_Service.userList();
		System.out.println(userList);
		if (userList != null) {

			mv.setViewName("users");
			mv.addObject("userList", userList);
			return mv;
		} else {
			mv.addObject("userList", "Record Not Found");
			return new ModelAndView("dashboard");
		}
	}

	
}
