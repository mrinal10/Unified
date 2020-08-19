package com.altimetrik.ee.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.bean.DummyBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

	protected static Logger logger = LoggerFactory.getLogger(ServiceController.class.getName());

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	DummyBean dummyData;

	@GetMapping(value = "/getData")
	@ApiOperation(value = "Get service name and identifier", notes = "Get service details and its corresponding values for all paired services", response = DummyBean.class)
	public DummyBean findAll() {
		
		return dummyData;
	}

}
