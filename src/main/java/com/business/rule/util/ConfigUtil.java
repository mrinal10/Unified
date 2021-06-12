package com.business.rule.util;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "config")
public class ConfigUtil {
	private List<String> productnames;
	private Map<String, String> operations;
	private Map<String, List<String>> productWiseOperationList;

	public List<String> getProductnames() {
		return productnames;
	}

	public void setProductnames(List<String> productnames) {
		this.productnames = productnames;
	}

	public Map<String, String> getOperations() {
		return operations;
	}

	public void setOperations(Map<String, String> operations) {
		this.operations = operations;
	}

	public Map<String, List<String>> getProductWiseOperationList() {
		return productWiseOperationList;
	}

	public void setProductWiseOperationList(Map<String, List<String>> productWiseOperationList) {
		this.productWiseOperationList = productWiseOperationList;
	}
}
