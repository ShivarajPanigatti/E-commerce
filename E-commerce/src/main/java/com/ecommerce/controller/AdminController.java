package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

import java.util.*;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	@GetMapping("/admin")
	public String adminPanel(User user) {

		return "adminPanel";
	}

	@RequestMapping("/add_products")
	public String addProduts() {

		return "addProducts";
	}
	
	@GetMapping("/user_list")
	public String getMyBooks(Model model)
	{
		List<User>list =userService.getAllUser();
		model.addAttribute("user",list);
		return "userList";
	}
//	@GetMapping("/available_books")
//	public ModelAndView getAllBook() {
//		List<User>list=userService.getAllUser();
////		ModelAndView m=new ModelAndView();
////		m.setViewName("bookList");
////		m.addObject("book",list);
//		return new ModelAndView("bookList","book",list);
//	}
	
}
