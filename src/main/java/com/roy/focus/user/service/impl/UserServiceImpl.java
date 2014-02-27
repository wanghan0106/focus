package com.roy.focus.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roy.core.dao.BaseDAO;
import com.roy.core.service.impl.BaseServiceImpl;
import com.roy.focus.user.dao.UserDAO;
import com.roy.focus.user.model.User;
import com.roy.focus.user.service.UserService;

@Repository("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public BaseDAO<User> getDao() {
		return userDao;
	}

}
