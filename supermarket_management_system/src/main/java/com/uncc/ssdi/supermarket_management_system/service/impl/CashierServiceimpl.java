package com.uncc.ssdi.supermarket_management_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uncc.ssdi.supermarket_management_system.entity.Admin;
import com.uncc.ssdi.supermarket_management_system.entity.Cashier;
import com.uncc.ssdi.supermarket_management_system.repository.AdminRepository;
import com.uncc.ssdi.supermarket_management_system.repository.CashierRepository;
import com.uncc.ssdi.supermarket_management_system.service.CashierService;
import com.uncc.ssdi.supermarket_management_system.vo.CashierVo;

@Service
public class CashierServiceimpl implements CashierService {

	@Autowired
	CashierRepository cashierRepository ;
	
	@Autowired
	AdminRepository adminRepository ;
	
//	@Autowired
//	LoginService loginService;
	
	private final Logger m_logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public List<Cashier> findAllCashiers() {
		List<Cashier> listofcashiers = cashierRepository.findAll();
		
		return listofcashiers;
	}

	@Override
	public ResponseEntity<CashierVo> addCashier(CashierVo cashierVo) {
		m_logger.info("saving the user to database");
		HttpStatus status=HttpStatus.OK;
		Cashier cashier =new Cashier();
		
		try {
			
				Admin admin = adminRepository.getOne(cashierVo.getAdmin_id());
				cashier.setAdmin(admin);
				cashier.setContact(cashierVo.getContact());
				cashier.setName(cashierVo.getName());
				cashier.setPassword(cashierVo.getPassword());
				cashier.setUsername(cashierVo.getUsername());
				cashier.setEmail(cashierVo.getEmail());
				
				System.out.println(cashier);
				cashierRepository.save(cashier);
				
		}
		
		catch(Exception e) {
	    	System.out.println(e.toString());
	    	status=HttpStatus.INTERNAL_SERVER_ERROR;
	    }
		
		m_logger.info("user saved to database");
	    return ResponseEntity.status(status).body(cashierVo);
	}
	


}
