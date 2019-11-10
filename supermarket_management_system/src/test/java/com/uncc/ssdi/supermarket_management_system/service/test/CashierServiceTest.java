package com.uncc.ssdi.supermarket_management_system.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uncc.ssdi.supermarket_management_system.SupermarketManagementSystemApplication;
import com.uncc.ssdi.supermarket_management_system.entity.Admin;
import com.uncc.ssdi.supermarket_management_system.entity.Cashier;
import com.uncc.ssdi.supermarket_management_system.repository.CashierRepository;
import com.uncc.ssdi.supermarket_management_system.service.impl.CashierServiceimpl;
import com.uncc.ssdi.supermarket_management_system.vo.CashierVo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SupermarketManagementSystemApplication.class)
public class CashierServiceTest {
	
	
	@Mock
	private CashierRepository cashierRepository; 
	
	@InjectMocks
	private CashierServiceimpl cashierServiceimpl;
	
	
	@Before
	public void setup() {
	
		MockitoAnnotations.initMocks(this);
		List<Cashier> cashiers = new ArrayList<Cashier>();
		
		Admin admin1= new Admin();
		admin1.setAmdin_id(1);
		admin1.setPassword("adminPassword1");
		admin1.setUsername("testAdminUsername1");
		
		Admin admin2= new Admin();
		admin2.setAmdin_id(2);
		admin2.setPassword("adminPassword2");
		admin2.setUsername("testAdminUsername2");
		
		Cashier cashier1 = new Cashier(1, "testUsername1", "testname1", "test1@gmail.com", "testPassword1", "1234567890", admin1);
		Cashier cashier2 = new Cashier(2, "testUsername2", "testname2", "test2@gmail.com", "testPassword2", "2345678901", admin2);
		Cashier cashier3 = new Cashier(3, "testUsername3", "testname3", "test3@gmail.com", "testPassword3", "3456789012", admin2);
			
		cashiers.add(cashier1);
		cashiers.add(cashier2);
		cashiers.add(cashier3);
		
		when(cashierRepository.findAll()).thenReturn(cashiers);
		when(cashierRepository.getOne(1)).thenReturn(cashier1);
		when(cashierRepository.getOne(2)).thenReturn(cashier2);
		when(cashierRepository.getOne(3)).thenReturn(cashier3);
		when(cashierRepository.save(cashier1)).thenReturn(cashier1);
		
	}
	
	
	@Test
	public void findAllProductsTest() throws Exception{
		
		List<Cashier> actual = cashierServiceimpl.findAllCashiers();
		
		assertEquals("testUsername1",actual.get(0).getUsername());
		assertEquals("testname2",actual.get(1).getName());
		assertEquals("test3@gmail.com",actual.get(2).getEmail());
		assertEquals("testAdminUsername1",actual.get(0).getAdmin().getUsername());
		
		assertNotEquals("adminPassword1", actual.get(2).getAdmin().getPassword());
		assertNotEquals("2345678901", actual.get(0).getContact());
		assertNotEquals("testPassword1", actual.get(2).getPassword());
		
	}
	
	@Test
	public void addCashierTest() throws Exception{
		
		CashierVo cashier = new CashierVo(1, "testUsername1", "testname1", "test1@gmail.com", "testPassword1", "1234567890", 1);
		
		ResponseEntity<CashierVo> actual = cashierServiceimpl.addCashier(cashier);
		
		assertNotNull(cashier.getName());
		assertTrue(cashier.getCashier_id() == 1);
		assertTrue(cashier.getAdmin_id() == 1);
		assertEquals("testUsername1",actual.getBody().getUsername());
		
	}
	
}
