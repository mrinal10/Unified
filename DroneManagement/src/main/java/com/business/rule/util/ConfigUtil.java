package com.business.rule.util;

import com.business.bean.DroneBean;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
public class ConfigUtil {
	private Map<String, DroneBean> drones;

	public Map<String, DroneBean> getDrones() {
		return drones;
	}

	public void setDrones(Map<String, DroneBean> drones) {
		this.drones = drones;
	}
	
		
}
