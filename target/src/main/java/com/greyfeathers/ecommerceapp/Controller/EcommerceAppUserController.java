package com.greyfeathers.ecommerceapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyfeathers.ecommerceapp.service.EcommerceAppService;

@RestController
@RequestMapping("/greyfeathers/user")
public class EcommerceAppUserController {
	
     @Autowired
     private EcommerceAppService ecommerceAppService;
     
     @GetMapping("/buyProduct/{id}/{quantity}")
     public  String buyProduct(@PathVariable int id , @PathVariable int quantity) {
		 
    	if( ecommerceAppService.buyProduct(id,quantity)) {
    		return "Sucessfully order";
    	}
    	return "Something went wrong, ethier id is incorrect or out of stock";
     }
}
