package com.uncc.ssdi.supermarket_management_system.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.uncc.ssdi.supermarket_management_system.SupermarketManagementSystemApplication;
import com.uncc.ssdi.supermarket_management_system.entity.Product;
import com.uncc.ssdi.supermarket_management_system.repository.ProductRepository;
import com.uncc.ssdi.supermarket_management_system.util.JSONUtil;
import com.uncc.ssdi.supermarket_management_system.vo.ProductVo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SupermarketManagementSystemApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class ProductControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Before
    public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        //this.teamRepository.deleteAllInBatch();
       
    }
	
	@Test
	public void getAllProductsTest() throws Exception{
		  mockMvc.perform(get("/api/products/all"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void addProductTest() throws Exception {
		
		ProductVo product = new ProductVo(1, "testProductName1", "10", "testDescription1", "100");
		mockMvc.perform(post("/api/addproduct")
				.content(JSONUtil.asJSONString(product))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	public void getProductByIdTest() throws Exception{
			
		Product product = new Product(1, "testProductName1", "10", "testDescription1", "100");
		
		product = productRepository.save(product);
			
			mockMvc.perform(get("/api/products/all")
					.content(JSONUtil.asJSONString(product))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
					
			List<Product> products = productRepository.findAll();
			
			mockMvc.perform(get("/api/productWithId/{pid}",products.get(0).getProduct_id())).andExpect(status().isOk());
	          			
		}
	
	@Test
	public void updateProductTest() throws Exception {
		
		ProductVo product = new ProductVo(1, "testProductName1", "10", "testDescription1", "100");
		mockMvc.perform(post("/api/updateproduct")
				.content(JSONUtil.asJSONString(product))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	@Ignore
	public void deleteProductTest() throws Exception {
		
		Product product = new Product(5, "testProductName1", "10", "testDescription1", "100");
		
				productRepository.delete(product);
		
		mockMvc.perform((RequestBuilder) ((ResultActions) delete("/api/deletecashier/{id}")).andExpect(status().isOk()));
		
//		mockMvc.perform(get("/api/productWithId/{pid}", products.get(0).getProduct_id())).andExpect(status().isOk());
		
	}
	
		
}
