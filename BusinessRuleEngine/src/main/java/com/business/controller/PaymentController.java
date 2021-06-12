package com.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.business.service.RuleProcessor;

@RestController
public class PaymentController {
	
	@Autowired
	RuleProcessor processRule;
	
	@GetMapping(value = "/payment/{productType}")
	public List<String> purchaseProduct(@PathVariable String productType) {
		return processRule.processReq(productType);
	}
	
	@GetMapping(value = "/payment/{productType}/{videoname}")
	public List<String> operateVideo(@PathVariable String productType,
			@PathVariable String videoname) {
		return processRule.processReq(productType, videoname);
	}
	
}
