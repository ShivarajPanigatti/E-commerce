package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class purchase{
	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public purchase(String name, String email, String address, int quantity) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.quantity = quantity;
	}
	public purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
