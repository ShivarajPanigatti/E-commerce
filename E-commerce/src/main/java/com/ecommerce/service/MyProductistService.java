package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.MyProductList;
import com.ecommerce.repository.MyProductRepository;

@Service
public class MyProductistService {
	
	@Autowired
	private MyProductRepository myProduct;
	
	public void savemyProducts(MyProductList product) {
		myProduct.save(product);
	}
	
	public List<MyProductList> getAllMyProducts(){
		return myProduct.findAll();
	}
	
	public void deleteById(int id) {
		myProduct.deleteById(id);
	}
}
