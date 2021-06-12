package com.business.rule.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;

import junit.framework.Assert;

@ExtendWith(MockitoExtension.class)
@EnableConfigurationProperties(value = ConfigUtil.class)
@TestPropertySource("classpath:application.yml")
public class ConfigUtilTest {
	
	@Mock
    private ConfigUtil configUtil;
	
	@Test
	public void processReq_dummy_Test() {
		List<String> l = new ArrayList<String>();
		Assert.assertEquals(configUtil.getProductnames(), l);
	}
}
