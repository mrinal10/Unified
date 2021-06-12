package com.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.rule.util.ConfigUtil;

@Service
public class UtilProcessor {
	
	@Autowired
	public ConfigUtil configUtil;
	
	public boolean isValidProductOnList(String productName) {
		return configUtil.getProductnames().contains(productName);
	}
	
}
