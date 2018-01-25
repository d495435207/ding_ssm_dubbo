package com.ding.biz.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ding.biz.dao.user.data.UserDO;
import com.ding.biz.manager.user.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/ding-mgr-context.xml"})
public class RedisTest {
	@Autowired
	private UserManager userManger;
	@Test
	public void test() {
		UserDO userDO = userManger.get(2);
		System.out.println(JSON.toJSONString(userDO));
	}
	
}
