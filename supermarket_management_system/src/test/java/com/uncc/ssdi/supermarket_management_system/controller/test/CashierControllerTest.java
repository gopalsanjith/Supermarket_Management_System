package com.uncc.ssdi.supermarket_management_system.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.uncc.ssdi.supermarket_management_system.SupermarketManagementSystemApplication;
import com.uncc.ssdi.supermarket_management_system.entity.Cashier;
import com.uncc.ssdi.supermarket_management_system.repository.CashierRepository;
import com.uncc.ssdi.supermarket_management_system.util.JSONUtil;
import com.uncc.ssdi.supermarket_management_system.vo.CashierVo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SupermarketManagementSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class CashierControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CashierRepository cashierRepository;
	
	
	@Before
    public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //this.teamRepository.deleteAllInBatch();
       
    }
	
	@Test
	public void getAllCashiersTest() throws Exception{
		  mockMvc.perform(get("/api/cashierdetails"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void addUserTest() throws Exception{
		
		CashierVo cashier = new CashierVo(1, "testUsername1", "testname1", "test1@gmail.com", "testPassword1", "1234567890", 1);
			
		mockMvc.perform(post("/api/addcashier")
				.content(JSONUtil.asJSONString(cashier))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		
		 
	}
       
	
	

}
