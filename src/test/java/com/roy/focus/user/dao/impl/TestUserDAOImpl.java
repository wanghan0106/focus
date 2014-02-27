package com.roy.focus.user.dao.impl;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roy.core.dao.cond.Cond;
import com.roy.focus.TransactionalTestCase;
import com.roy.focus.user.dao.UserDAO;
import com.roy.focus.user.model.User;

public class TestUserDAOImpl extends TransactionalTestCase {
	
	@Autowired
	private UserDAO userDao;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("admin");
		user.setNumber("000001");
		userDao.save(user);
		User user2 = userDao.get(Cond.eq("name", "admin"));
		Assert.assertNotNull(user2);
	}
	
	//@Test
	public void batchAddUser() {
		for(int i=0;i<20;i++) {
			User user = new User();
			user.setName("admin"+(i+1));
			user.setNumber("00000"+(i+1));
			userDao.save(user);
		}
	}
	
}
