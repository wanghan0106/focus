package com.roy.core.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roy.core.dao.BaseDAO;
import com.roy.core.dao.Sorter;
import com.roy.core.dao.cond.Cond;
import com.roy.core.service.BaseService;
import com.roy.core.web.Params;

@Transactional(propagation=Propagation.REQUIRED)
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	public abstract BaseDAO<T> getDao();

	@Override
	public void save(T object) {
		getDao().save(object);
	}

	@Override
	public void delete(T object) {
		getDao().delete(object);
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Serializable id) {
		return getDao().get(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> query(Params params) {
		return getDao().query(params.getCond(), params.getPager(), params.getSorter());
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> query(Cond cond, Sorter sorter) {
		return getDao().query(cond, sorter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> query(Cond cond) {
		return getDao().query(cond);
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Cond cond) {
		return getDao().get(cond);
	}

}
