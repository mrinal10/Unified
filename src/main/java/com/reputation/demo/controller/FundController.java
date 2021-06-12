package com.reputation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reputation.demo.model.ResponseData;
import com.reputation.demo.service.FundService;

@RestController
public class FundController {
	
	@Autowired
	FundService fundService;
	
	@RequestMapping("calculatereturn/{fundId}/{horizon}/{investementPeriod}")
    public List<ResponseData> getDetails(@PathVariable("fundId") String fundId,
    		@PathVariable("horizon") String horizon, @PathVariable("investementPeriod") String investementPeriod) {		
		return fundService.getFundData(fundId, horizon, investementPeriod);
    }

}
