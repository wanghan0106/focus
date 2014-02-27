package com.roy.core.web;

import com.roy.core.dao.cond.Cond;

public class QueryParam {
	private String name;
	private Object value;
	private String exp = "like"; //默认模糊匹配
	private Cond cond;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public Cond getCond() {
		if(cond == null && name!=null && value!=null) {
			if("eq".equals(exp)) {
				cond = Cond.eq(name, value);
			} else {
				cond = Cond.like(name, "%"+value+"%");
			}
		}
		return cond;
	}
	
}