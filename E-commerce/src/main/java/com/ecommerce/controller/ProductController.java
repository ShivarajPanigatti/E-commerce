package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.entity.MyProductList;
import com.ecommerce.entity.Product;
import com.ecommerce.service.MyProductistService;
import com.ecommerce.service.ProductService;

import java.util.*;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private MyProductistService myProductService;
	
	@GetMapping("/available_products")
	public ModelAndView getAllProducts() {
		List<Product>list=service.getAllProduct();
		return new ModelAndView("productList","products",list);
	}
	
	@PostMapping("/saveProduct")
	public String addProduct(@ModelAttribute Product b) {
		service.save(b);
		return "redirect:/available_products";
	}
	
	@GetMapping("/my_products")
	public String getMyProduct(Model model)
	{
		List<MyProductList>list=myProductService.getAllMyProducts();
		model.addAttribute("product",list);
		return "myProduct";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Product b=service.getProductById(id);
		MyProductList mb=new MyProductList(b.getId(),b.getName(),b.getCatagory(),b.getPrice());
		myProductService.savemyProducts(mb);
		return "redirect:/my_products";
	}
	
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id,Model model) {
		Product b=service.getProductById(id);
		model.addAttribute("product",b);
		return "productEdit";
	}
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_products";
	}
	
}




















// <form  th:action="@{/save}" method="post">
//        <div class="mb-3">
//            <label for="firstName" class="form-label">First Name</label>
//            <input type="text" class="form-control" name= fName required>
//        </div>
//        <div class="mb-3">
//            <label for="lastName" class="form-label">Last Name</label>
//            <input type="text" class="form-control" id="lastName" aria-describedby="lastNameHelp" required>
//        </div>
//        <div class="mb-3">
//            <label for="email" class="form-label">Email</label>
//            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" required>
//            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
//        </div>
//        <div class="mb-3">
//            <label for="phone" class="form-label">Phone Number</label>
//            <input type="tel" class="form-control" id="phone" aria-describedby="phoneHelp" required>
//        </div>
//        <button type="submit" class="btn btn-primary">Register</button>
//    </form>