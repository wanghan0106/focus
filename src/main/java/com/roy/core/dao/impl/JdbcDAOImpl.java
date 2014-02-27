package com.roy.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.roy.core.dao.JdbcDAO;

public class JdbcDAOImpl extends JdbcDaoSupport implements JdbcDAO {

	public List<Map<String, Object>> query(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> query(String sql,Object[] args) {
		return this.getJdbcTemplate().queryForList(sql,args);
	}
	
	public Map<String, Object> querySingleResult(String sql,Object[] args) {
		return this.getJdbcTemplate().queryForMap(sql,args);
	}

	public int update(String sql) {
		return this.getJdbcTemplate().update(sql);
	}

	public int update(String sql,Object[] args) {
		return this.getJdbcTemplate().update(sql,args);
	}

	public void execute(String sql) {
		this.getJdbcTemplate().execute(sql);
	}

	public void batchUpdate(String[] sqls) {
		this.getJdbcTemplate().batchUpdate(sqls);
	}

	public <T> T callProcedure(String callSql,CallableStatementCallback<T> callBack) {
		return this.getJdbcTemplate().execute(callSql, callBack);
	}

}
