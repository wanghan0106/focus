package com.roy.core.dao;

import java.util.ArrayList;

public class Sorter extends ArrayList<Sort> {

	private static final long serialVersionUID = 1L;
	
	public Sorter() {
		super();
	}
	
	public Sorter(final String name,final String order) {
		super();
		if(name!=null) {
			if("desc".equals(order)) {
				this.add(new Sort(name,"desc"));
			} else {
				this.add(new Sort(name,"asc"));
			}
		}
	}
	
	public Sorter(Sort sort) {
		this();
		this.add(sort);
	}
	

}
