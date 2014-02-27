package com.roy.core.web;

import java.util.List;

public class QueryResult implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int total;
	private List rows;
	
	public QueryResult() {
		
	}
	
	public QueryResult(int total,List rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

}
