package com.roy.core.dao.impl;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roy.core.dao.JdbcDAO;
import com.roy.focus.TransactionalTestCase;

public class TestJdbcDAOImpl extends TransactionalTestCase {
	
	@Autowired
	private JdbcDAO jdbcDao;
	
	@Test
	public void testQuery() {
		List<Map<String, Object>> result = jdbcDao.query("select * from user");
		Assert.assertEquals(20, result.size());
	}
}
