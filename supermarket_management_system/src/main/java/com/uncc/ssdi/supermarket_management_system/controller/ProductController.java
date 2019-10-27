package com.uncc.ssdi.supermarket_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uncc.ssdi.supermarket_management_system.entity.Product;
import com.uncc.ssdi.supermarket_management_system.service.ProductService;
import com.uncc.ssdi.supermarket_management_system.vo.ProductVo;

@RestController
@RequestMapping({ "/api" })
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/addproduct", method = { RequestMethod.POST })
	public ResponseEntity<ProductVo> addProduct(@RequestBody ProductVo productVo) {
		System.out.println(productVo);
		
		return productService.addProduct(productVo);
	}
	
	@RequestMapping(value="/products/all", method= RequestMethod.GET)
	public List<ProductVo> getAllProducts(){							
		return productService.getAllProducts();		
	}
	
	@RequestMapping(value="/products/{pid}",method=RequestMethod.GET)
	public ProductVo getProductById(@PathVariable int pid) throws Exception{
		
		return productService.getProductById(pid);
	}
	
}
