package com.ding.biz.cache.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
* @ClassName: RedisCache 
* @Description: 缓存实现类 
* @author dinglh
* @date 2017年10月13日 下午2:07:02 
*  
*/
public class RedisCache {
	@Autowired
	private JedisPool jedisPool = new JedisPool();
	/**
	 * 从redis缓存获取数据
	 * @param redisKey
	 * @return
	 */
	public Object getDataFromRedis(String redisKey){
		Jedis jedis = jedisPool.getResource();
		byte[] result = jedis.get(redisKey.getBytes());
		
		if(result ==null ){
			return null;
		}
		
		return SerializeUtil.unSerialize(result);
	}
	/**
	 * 设置数据到redis
	 * @param redisKey
	 * @param obj
	 * @param expire 
	 */
	public void setDataToRedis(String redisKey,Object obj, int expire){
		byte[] bytes = SerializeUtil.serialize(obj);
		Jedis jedis = jedisPool.getResource();
		String success = jedis.setex(redisKey,expire, new String (bytes));
		if("OK".equalsIgnoreCase(success)){
			System.out.println("保存成功");
		}
	}
}
