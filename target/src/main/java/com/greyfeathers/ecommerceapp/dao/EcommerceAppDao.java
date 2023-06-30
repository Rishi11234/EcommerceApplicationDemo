package com.greyfeathers.ecommerceapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.greyfeathers.ecommerceapp.model.Product;

@Repository
public class EcommerceAppDao {
	
	List<Product> product = new ArrayList<>();

	public List<Product> allProduct() {
		return product;
		
	}

	public boolean addProduct(Product item) {
		
		return product.add(item);
	}

	public void addAllProduct(List<Product> items) {
		product = items;
	}

	

	
	
	
	
       
}
