package com.business.rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com" })
public class BusinessRuleEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessRuleEngineApplication.class, args);
	}
}
