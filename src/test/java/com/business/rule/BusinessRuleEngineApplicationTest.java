package com.business.rule;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.business.controller.PaymentController;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class BusinessRuleEngineApplicationTest {
	
	@Autowired
	private PaymentController payController;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void paymentEndPointTest() throws Exception {  
		this.mockMvc.perform(get("/payment/book")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void paymentEndPoint_Video_Test() throws Exception {  
		this.mockMvc.perform(get("/payment/video/testVideo")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void paymentEndPoint_Dummy_Test() throws Exception {  
		this.mockMvc.perform(get("/payment/dummy/testVideo")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void contextLoads() {
		assertThat(payController).isNotNull();
	}
}
