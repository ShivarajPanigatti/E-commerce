package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.entity.purchase;
import com.ecommerce.repository.PurchaseRepository;

@Controller
public class PurchaseController {
	
	   private PurchaseRepository prepo;
	

	 @GetMapping("/s21_fe")
	    public String showS21feForm() {
//	        model.addAttribute("purchase", new purchase());
	        return "s21fe";
	    }
//	    @PostMapping("/s21fe")
//	    public String submitS21feForm(@ModelAttribute purchaseForm purchase) {
//	       
//
//	        return "redirect:/success"; // Redirect to a success page
//	    }
//
//	    @GetMapping("/success")
//	    public String showSuccessPage() {
//	        return "success";
//	    }	 
}
