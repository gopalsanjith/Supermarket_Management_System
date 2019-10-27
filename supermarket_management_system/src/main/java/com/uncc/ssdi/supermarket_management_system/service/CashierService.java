package com.uncc.ssdi.supermarket_management_system.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.uncc.ssdi.supermarket_management_system.entity.Cashier;
import com.uncc.ssdi.supermarket_management_system.vo.CashierVo;

public interface CashierService {

	List<Cashier> findAllCashiers();

	ResponseEntity<CashierVo> addCashier(CashierVo cashierVo);
	

}
