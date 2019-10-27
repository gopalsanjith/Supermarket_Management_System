package com.uncc.ssdi.supermarket_management_system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uncc.ssdi.supermarket_management_system.entity.Admin;
import com.uncc.ssdi.supermarket_management_system.entity.Cashier;
import com.uncc.ssdi.supermarket_management_system.entity.Product;
import com.uncc.ssdi.supermarket_management_system.repository.ProductRepository;
import com.uncc.ssdi.supermarket_management_system.service.ProductService;
import com.uncc.ssdi.supermarket_management_system.vo.CashierVo;
import com.uncc.ssdi.supermarket_management_system.vo.ProductVo;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	private final Logger m_logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ResponseEntity<ProductVo> addProduct(ProductVo productVo) {
		
		m_logger.info("saving the user to database");
		HttpStatus status=HttpStatus.OK;
		
		Product product = new Product();
		try {
			product.setName(productVo.getName());
			product.setDescription(productVo.getDescription());
			product.setPrice(productVo.getPrice());
			product.setQuantity(productVo.getQuantity());
			
			productRepository.save(product);
			
		}
		catch(Exception e) {
	    	System.out.println(e.toString());
	    	status=HttpStatus.INTERNAL_SERVER_ERROR;
	    }
		
		m_logger.info("user saved to database");
	    return ResponseEntity.status(status).body(productVo);
		
	}

	public List<ProductVo> getAllProducts() {		
		List<ProductVo> vos=new ArrayList<>();
		
		for(Product product:productRepository.findAll()) {
			
			ProductVo productVo = new ProductVo();
			productVo.setDescription(product.getDescription());
			productVo.setName(product.getName());
			productVo.setPrice(product.getPrice());
			productVo.setQuantity(product.getQuantity());
			vos.add(productVo);
		
		}
		return vos;
	}

	@Override
	public ProductVo getProductById(int pid) {
		
		System.out.println("prpduct for id: "+pid);
		
		Product product = new Product();
		
		product = productRepository.getOne(pid);
		ProductVo productVo = new ProductVo();
		productVo.setDescription(product.getDescription());
		productVo.setName(product.getName());
		productVo.setPrice(product.getPrice());
		productVo.setQuantity(product.getQuantity());
		
		return productVo;
		
	}
	
}
