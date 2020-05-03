package com.javabykiran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Operatorlist;
import com.javabykiran.service.OperatorService;

@Controller
public class OperationController {
	
	@Autowired
	OperatorService operatorService;
	
	
	@RequestMapping(value = "/operators")
	public ModelAndView operatorspage(Model model) {
		System.out.println("I am in operation Controller");
		
		ModelAndView mv=new ModelAndView();
		
		List<Operatorlist> operatorList = operatorService.OperatorList();
		System.out.println(operatorList+ "*********************");
		
			
			mv.addObject("operatorList", operatorList);
			return new ModelAndView("operators","operatorList",operatorList);
	}
}
