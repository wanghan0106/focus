package com.roy.core.web;

import java.util.List;

import com.roy.core.service.BaseService;

public class QueryResult implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List rows;
	private int total;
	
	public QueryResult() {
		
	}
	
	public QueryResult(List rows,int total) {
		this.rows = rows;
		this.total = total;
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static QueryResult getQueryResult(BaseService service,Params params) {
		return new QueryResult(service.query(params),params.getTotal());
	}

}
