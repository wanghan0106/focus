package com.roy.core.web;

import java.util.ArrayList;
import java.util.List;

import com.roy.core.dao.Pager;
import com.roy.core.dao.Sorter;
import com.roy.core.dao.cond.Cond;

public class Params {
	private int page = 1;
	private int rows = 10;
	private String sort;
	private String order;
	
	private Pager pager;
	private Sorter sorter;
	private Cond cond;
	private List<QueryParam> queryParams = new ArrayList<QueryParam>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public Pager getPager() {
		if(pager==null) {
			pager = new Pager(page,rows);
		}
		return pager;
	}
	
	public Sorter getSorter() {
		if(sorter==null) {
			if(sort!=null && sort.length()>0) {
				sorter = new Sorter(sort,order);
			}
		}
		return sorter;
	}
	public void setQueryParams(List<QueryParam> queryParams) {
		this.queryParams = queryParams;
	}
	
	public List<QueryParam> getQueryParams() {
		return queryParams;
	}
	public Cond getCond() {
		if(cond==null && queryParams.size()>0) {
			for(QueryParam param : queryParams) {
				Cond subCond = param.getCond();
				if(subCond!=null) {
					if(cond==null) {
						cond = subCond;
					} else {
						cond = cond.and(subCond);
					}
				}
			}
		}
		return cond;
	}
}
