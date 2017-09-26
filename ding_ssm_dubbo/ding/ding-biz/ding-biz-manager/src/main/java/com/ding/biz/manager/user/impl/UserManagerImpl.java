package com.ding.biz.manager.user.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ding.biz.dao.user.UserDAO;
import com.ding.biz.dao.user.data.UserDO;
import com.ding.biz.manager.user.UserManager;
public class UserManagerImpl implements UserManager{
	@Autowired
	private UserDAO userDAO;
	public UserDO get(Integer userId) {
		UserDO userDO = userDAO.get(userId);
		return userDO;
	}
}
