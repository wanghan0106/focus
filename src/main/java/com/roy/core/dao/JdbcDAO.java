package com.roy.core.dao;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.CallableStatementCallback;

public interface JdbcDAO {
	public List<Map<String, Object>> query(String sql);
	public List<Map<String, Object>> query(String sql,Object[] args);
	public Map<String, Object> querySingleResult(String sql,Object[] args);
	public int update(String sql);
	public int update(String sql,Object[] args);
	public void execute(String sql);
	public void batchUpdate(String[] sqls);
	public <T> T callProcedure(String callSql,CallableStatementCallback<T> callBack);
	
}
