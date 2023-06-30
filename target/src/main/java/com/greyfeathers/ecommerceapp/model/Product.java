package com.greyfeathers.ecommerceapp.model;

public class Product {
	
	private int id;
	private String product_Name;
	private double price;
	private int stock;
	private String categery;
	
	public Product(int id, String product_Name, double price, int stock, String categery) {
		this.id = id;
		this.product_Name = product_Name;
		this.price = price;
		this.stock = stock;
		this.categery = categery;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategery() {
		return categery;
	}
	public void setCategery(String categery) {
		this.categery = categery;
	}
	

}
