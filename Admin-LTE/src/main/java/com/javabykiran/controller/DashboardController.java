package com.javabykiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Users;
import com.javabykiran.service.User_Service;

@Controller
public class DashboardController {

	@Autowired
	private User_Service userService;

	@RequestMapping(value = "/userspage")
	public ModelAndView userspage(Model model) {
		List<Users> users = userService.userList();
		System.out.println(users + "*********************");

		return new ModelAndView("users", "userList", users);
	}

	@RequestMapping(value = "/add_user_page")
	public ModelAndView add_user_page() {
		return new ModelAndView("add_user");
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard() {
		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = "/useful_links")
	public ModelAndView UsefulLinks() {
		return new ModelAndView("links");
	}

	@RequestMapping(value = "/down_Page")
	public ModelAndView DownloadPage() {
		return new ModelAndView("downloads");
	}

	/*@RequestMapping(value = "/operators")
	public ModelAndView operatorspage() {
		return new ModelAndView("operators");
	}
*/
	@RequestMapping(value = "/logout")
	public ModelAndView Logout() {
		return new ModelAndView("logout");
	}
	
	
	

}
