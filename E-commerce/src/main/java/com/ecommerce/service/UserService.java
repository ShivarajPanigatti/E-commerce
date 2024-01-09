package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.userRepository;


@Service
public class UserService {

	@Autowired
	private userRepository uRepo;
	public void save(User user) {
		uRepo.save(user);
	}
	
	public List<User> getAllUser(){
		return uRepo.findAll();
	}
	
	
	
	
}
