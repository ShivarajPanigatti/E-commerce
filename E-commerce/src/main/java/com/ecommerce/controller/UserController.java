package com.ecommerce.controller;
import java.util.*;




	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.entity.MyProductList;
import com.ecommerce.entity.User;
import com.ecommerce.repository.userRepository;
import com.ecommerce.service.UserService;

	

	@Controller
	public class UserController {

		@Autowired
		private UserService service;
		
		@Autowired
		private userRepository userRepo;
		
//		@Autowired
//		private MyProductList myProductService;
//		
		@GetMapping("/")
		public String home1() {
			return "home1";
		}
		

		@GetMapping("/user_Login")
		public String userLogin() {
			return "userLogin";
		}
		
		@GetMapping("/user_Registration")
		public String userRegistration() {
			return "userRegistration";
		}
		
		@PostMapping("/save")
		public String addItem(@ModelAttribute User user){
			service.save(user);
			return "redirect:/user_Login";
		}
		
		@RequestMapping("/verify_Login")
		public String verifyLogin(@RequestParam("eMail") String eMail, @RequestParam("password") String password, @RequestParam(name = "role", required = false, defaultValue = "defaultRole") String role,  ModelMap modelMap) {
			User user = userRepo.findByeMail(eMail);
			if(user.geteMail().equals(eMail) && user.getPassword().equals(password)&& user.getRole().equals(role="normal")) {
				return "redirect:/available_products";
			}else if( (user.geteMail().equals(eMail) && user.getPassword().equals(password)&& user.getRole().equals(role="admin"))) {
				return "admin";
				
			}
			else{modelMap.addAttribute("error", "Invalid username/password");
			return "home";
				
			}
		}
	}
		
			
//		@GetMapping("/book_register")
//		public String bookRegister() {
//			return "bookRegister";
//		}
	//	
//		@GetMapping("/available_books")
//		public ModelAndView getAllBook() {
//			List<Book>list=service.getAllBook();
////			ModelAndView m=new ModelAndView();
////			m.setViewName("bookList");
////			m.addObject("book",list);
//			return new ModelAndView("bookList","book",list);
//		}
	//	
//		@PostMapping("/save")
//		public String addBook(@ModelAttribute Book b) {
//			service.save(b);
//			return "redirect:/available_books";
//		}
//		@GetMapping("/my_books")
//		public String getMyBooks(Model model)
//		{
//			List<MyBookList>list=myBookService.getAllMyBooks();
//			model.addAttribute("book",list);
//			return "myBooks";
//		}
//		@RequestMapping("/mylist/{id}")
//		public String getMyList(@PathVariable("id") int id) {
//			Book b=service.getBookById(id);
//			MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
//			myBookService.saveMyBooks(mb);
//			return "redirect:/my_books";
//		}
	//	
//		@RequestMapping("/editBook/{id}")
//		public String editBook(@PathVariable("id") int id,Model model) {
//			Book b=service.getBookById(id);
//			model.addAttribute("book",b);
//			return "bookEdit";
//		}
//		@RequestMapping("/deleteBook/{id}")
//		public String deleteBook(@PathVariable("id")int id) {
//			service.deleteById(id);
//			return "redirect:/available_books";
//		}
	//	
	//}



