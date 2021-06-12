package com.reputation.demo.model;

import java.util.List;

public class FundData {
	
	private MetaData meta;
	private List<Data> data;
	private String status;
	
	public MetaData getMeta() {
		return meta;
	}
	public List<Data> getData() {
		return data;
	}
	public String getStatus() {
		return status;
	}
	public void setMeta(MetaData meta) {
		this.meta = meta;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
