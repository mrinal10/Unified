package com.business.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.business.rule.util.ConfigUtil;

@ExtendWith(MockitoExtension.class)
public class RuleProcessorTest {

	@Mock
	private ConfigUtil configUtil;

	@Mock
	private UtilProcessor utilProcessor;

	@InjectMocks
	private RuleProcessor ruleProcessor;

	Map<String, List<String>> mapC;
	Map<String, String> map;

	@BeforeEach
	public void createMocks() {
		MockitoAnnotations.initMocks(this);
		mapC = new HashMap<String, List<String>>();
		List<String> li = new ArrayList<String>();
		li.add("test1");
		li.add("test2");
		
		mapC.put("book", li);
		mapC.put("def", li);
		
		map = new HashMap<String, String>();
		map.put("abc", "operation for ABC");
		map.put("def", "operation for DEF");
		
		utilProcessor.configUtil = configUtil;
		
	}

	@Test
	public void processReq_dummy_Test() {
		when(utilProcessor.isValidProductOnList("notaProduct")).thenReturn(false);
		ruleProcessor.processReq("notaProduct");
	}

	@Test
	public void processReq_Book_Test() {

		when(utilProcessor.isValidProductOnList("book")).thenReturn(true);
		when(utilProcessor.configUtil.getProductWiseOperationList()).thenReturn(mapC);
		when(utilProcessor.configUtil.getOperations()).thenReturn(map);
		ruleProcessor.processReq("book");
	}
}
