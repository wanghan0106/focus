package com.roy.core.service;

import java.io.Serializable;
import java.util.List;

import com.roy.core.dao.Pager;
import com.roy.core.dao.Sorter;
import com.roy.core.dao.cond.Cond;
import com.roy.core.web.Params;

public interface BaseService<T> {
	
	public void save(T object);
	
	public void delete(T object);
	
	public T get(Serializable id);
	
	public List<T> query(Params params);
	
	public List<T> query(Cond cond,Sorter sorter);
	
	public List<T> query(Cond cond);
	
	public T get(Cond cond);
}
