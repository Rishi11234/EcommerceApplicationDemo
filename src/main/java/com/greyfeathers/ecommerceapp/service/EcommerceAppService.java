package com.greyfeathers.ecommerceapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greyfeathers.ecommerceapp.dao.EcommerceAppDao;
import com.greyfeathers.ecommerceapp.model.Product;

@Service
public class EcommerceAppService {

	
	@Autowired
	private EcommerceAppDao  ecommerceAppDao;
	
	
	public List<Product> allProduct() {
		List<Product> product = ecommerceAppDao.allProduct();
		return product;
		
	}


	public Product getProductById(int id) {
		List<Product> product = ecommerceAppDao.allProduct();
		for(Product item : product) {
			if(item.getId()==id) {
				return item;
			}
		}
		
		return null;
		
	}


	public Product getProductByName(String name) {
		List<Product> product = ecommerceAppDao.allProduct();
		for(Product item : product) {
			if(item.getProduct_Name().equals(name)) {
				return item;
			}
		}
		
		return null;
		
	}


	public List<Product> getProductByCategery(String categery) {
		List<Product> product = ecommerceAppDao.allProduct();
		List<Product> result = new ArrayList<>();
		for(Product item : product) {
			if(item.getCategery().equals(categery)) {
				 result.add(item);
			}
		}
		
		return result;
	}


	public boolean addProduct(Product product) {
		
		return ecommerceAppDao.addProduct(product);
	}


	public boolean changeProductPriceById(int id, double price) {
		List<Product> product = ecommerceAppDao.allProduct();
		
		for(Product item : product) {
			if(item.getId()==(id)) {
				 item.setPrice(price);
				 ecommerceAppDao.addAllProduct(product);
				 return true;
				 
			}
		}
		return false;
		
	}


	public boolean changeProductstockById(int id, int stock) {
		List<Product> product = ecommerceAppDao.allProduct();
		
		for(Product item : product) {
			if(item.getId()==(id)) {
				 item.setStock(stock);
				 ecommerceAppDao.addAllProduct(product);
				 return true;
				 
			}
		}
		return false;
		
	}


	public boolean removeProductByName(int id) {
        List<Product> product = ecommerceAppDao.allProduct();
		int index= -1,i=0;
		for(Product item : product) {
			if(item.getId()==(id)) {
				 index=i; 
			}
			i++;
		}
		if(index != -1) {
			product.remove(index);
			ecommerceAppDao.addAllProduct(product);
			return true;
		}
		return false;
		
	}


	public boolean buyProduct(int id, int quantity) {
		
		List<Product> product = ecommerceAppDao.allProduct();
		for(Product item : product) {
			if(item.getId()==id && item.getStock()>= quantity) {
				item.setStock(item.getStock()-quantity);
				ecommerceAppDao.addAllProduct(product);
				return true;
			}
		}
		
		return false;
	}
	


	


	


	
}
