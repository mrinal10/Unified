package com.altimetrik.ee.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class DummyBean {
	String data="This is Dummy Data";
	String value = "this is Dummy Value";
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
