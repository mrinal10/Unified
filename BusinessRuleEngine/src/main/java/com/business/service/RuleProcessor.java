package com.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleProcessor {
	@Autowired
	public UtilProcessor validator;

	public List<String> processReq(String product) {
		List<String> response = new ArrayList<String>();
		if (!validator.isValidProductOnList(product)) {
			response.add("Invalid Product");
		} else {
			List<String> listOfOperations = validator.configUtil.getProductWiseOperationList().get(product);
			Map<String, String> mapOfOps = validator.configUtil.getOperations();
			for (String ops : listOfOperations) {
				response.add(mapOfOps.get(ops));
			}
		}
		return response;
	}

	public List<String> processReq(String product, String productname) {
		List<String> response = new ArrayList<String>();
		if (!validator.isValidProductOnList(product)) {
			response.add("Invalid Product");
		} else {
			List<String> listOfOperations = validator.configUtil.getProductWiseOperationList().get(product);
			Map<String, String> mapOfOps = validator.configUtil.getOperations();
			for (String ops : listOfOperations) {
				response.add(mapOfOps.get(ops));
			}
		}
		return response;
	}
}
