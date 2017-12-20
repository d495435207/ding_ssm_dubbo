package com.ding.biz.manager;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
//		String host = "localhost";
		String host = "98.142.137.4";
		Jedis jedis = new Jedis(host);
		jedis.auth("123456");
		
		System.out.println(jedis.get("dinglh"));
	}
}
