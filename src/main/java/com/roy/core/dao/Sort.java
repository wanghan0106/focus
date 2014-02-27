package com.roy.core.dao;

public class Sort implements java.io.Serializable {

	private static final long serialVersionUID = 1019739870962994124L;
	
	private String name;
	private String order;
	
	public Sort() {
		
	}
	
	public Sort(final String name,final String order) {
		this.name = name;
		this.order = order;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	

}
