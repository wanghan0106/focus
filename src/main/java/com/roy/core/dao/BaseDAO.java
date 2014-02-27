package com.roy.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.type.Type;

import com.roy.core.dao.cond.Cond;

public interface BaseDAO<T> {
	public void save(T object);
	public void delete(T object);
	public T get(Serializable id);
	public List<T> query(Cond cond);
	public List<T> query(Cond cond,Sorter sorter);
	public List<T> query(Cond cond,Pager pager,Sorter sorter);
	public T get(Cond cond);
	@SuppressWarnings("rawtypes")
	public List find(String hql, Object[] values, Type[] types);
	
}
