package com.ding.biz.manager;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	@Test
	public  void test() {
//		String host = "localhost";

		String host = "98.142.137.4";
		JedisPoolConfig	poolconfig =new JedisPoolConfig();
		JedisPool pool = new JedisPool(poolconfig,host,6379,10000,"123456");
		Jedis jedis= pool.getResource();
		
		jedis.auth("123456");
		
		System.out.println(jedis.get("dinglh"));
	}
	
	
	
}
