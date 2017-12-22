package com.ding.biz.manager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	public static void main(String[] args) {
//		String host = "localhost";

		String host = "98.142.137.4";
		JedisPoolConfig	poolconfig =new JedisPoolConfig();
		JedisPool pool = new JedisPool(poolconfig,host,6379,10000,"123456");
		Jedis jedis= pool.getResource();
		
		jedis.auth("123456");
		
		System.out.println(jedis.get("dinglh"));
	}
	
	
	
}
