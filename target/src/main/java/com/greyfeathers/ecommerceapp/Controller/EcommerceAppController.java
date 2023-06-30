package com.greyfeathers.ecommerceapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyfeathers.ecommerceapp.model.Product;
import com.greyfeathers.ecommerceapp.service.EcommerceAppService;

@RestController
@RequestMapping("/greyfeather/admin")
public class EcommerceAppController {
	
	@Autowired
	private EcommerceAppService ecommerceAppService;
	
	@GetMapping("/allProduct")
	public List<Product> allProduct() {
		
		return ecommerceAppService.allProduct();
		
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		
		return ecommerceAppService.getProductById(id);
		
	}
	
	@GetMapping("/getProductByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return ecommerceAppService.getProductByName(name);

	}
	
	@GetMapping("/getProductByCategery/{categery}")
	public List<Product> getProductByCategery(@PathVariable String categery) {
		
		return ecommerceAppService.getProductByCategery(categery);
	}
	
	@PostMapping("/addProduct")
	public  String addProduct(@RequestBody Product product) {
		
		if(ecommerceAppService.addProduct(product)) {
			return "Successfully new product add";
		}
		
		return "Something went wrong";

	}
	
	@PutMapping("/changeProductPriceById/{id}/{price}")
	public String changeProductPriceById(@PathVariable int id , @PathVariable double price) {
		 
         if(ecommerceAppService.changeProductPriceById(id,price)) {
        	 return "Successfully updated";
         }
         return "something went wrong , check your id "+ id;
	}
	
	@PutMapping("/changeProductstockById/{id}/{stock}")
	public String changeProductstockById(@PathVariable int id , @PathVariable int stock) {
		 if(ecommerceAppService.changeProductstockById(id,stock)) {
			 return "Successfully updated";
		 }
		 return "something went wrong , check your id "+ id;
	}
	
	@DeleteMapping("/removeProductById/{id}")
	public String removeProductByName(@PathVariable int id) {
		if(ecommerceAppService.removeProductByName(id)) {
			return "sucessfully removed";
		}
		 return "something went wrong , check your id "+ id;
	}

}
