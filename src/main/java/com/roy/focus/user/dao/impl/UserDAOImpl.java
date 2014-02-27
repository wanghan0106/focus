package com.roy.focus.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.roy.core.dao.impl.BaseDAOImpl;
import com.roy.focus.user.dao.UserDAO;
import com.roy.focus.user.model.User;

@Repository("userDao")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

}
