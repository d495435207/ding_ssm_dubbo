package com.ding.biz.manager.user.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ding.biz.cache.GetCache;
import com.ding.biz.cache.enums.CacheExpireTimeEnum;
import com.ding.biz.dao.user.DubboDAO;
import com.ding.biz.dao.user.data.DubboDO;
import com.ding.biz.manager.user.DubboManager;

public class DubboManagerImpl implements DubboManager{
	@Autowired
	private DubboDAO dubboDAO;
	
	@GetCache(name="id",expire=CacheExpireTimeEnum.ONEMIN)
	public DubboDO get(Integer id) {
		return dubboDAO.get(id);
	}

}
