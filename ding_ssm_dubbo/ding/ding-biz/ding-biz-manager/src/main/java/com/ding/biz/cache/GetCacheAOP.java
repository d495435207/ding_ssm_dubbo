package com.ding.biz.cache;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ding.biz.cache.util.RedisCache;

@Component
@Aspect
public class GetCacheAOP {
	private final Log logger = LogFactory.getLog(getClass());

	private RedisCache redisCache = new RedisCache();

	@Pointcut(value = "execution(* com.ding.biz.manager.user.impl.*.get*(..))")
	public void getCache() {
		System.out.println("---这里是一个切点");
	}

	@Around("getCache()")
	public Object beforeExec(ProceedingJoinPoint joinPoint) {
		Map<String, Object> cacheMap = getCacheKey(joinPoint);
		logger.info("缓存key|"+JSON.toJSONString(cacheMap));
		String cacheKey = cacheMap.get("cacheKey").toString();
		int expire = (Integer) cacheMap.get("expire");
		Object objectFromRedis = redisCache.getDataFromRedis(cacheKey);
		if (null != objectFromRedis) {
			logger.info("redis中查到的数据|"+JSON.toJSONString(objectFromRedis));
			return objectFromRedis;
		}
		logger.info("redis中没有.. 这个要到数据库中查!!");
		Object proceed = null;
		try {
			proceed = joinPoint.proceed();
			logger.info("数据库中查到的数据|"+JSON.toJSONString(proceed));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("将从数据库中查询到的数据增加到缓存!");
		redisCache.setDataToRedis(cacheKey, proceed,expire);
		return proceed;
	}

	private Map<String, Object> getCacheKey(ProceedingJoinPoint joinPoint) {
		Map<String, Object> res =new HashMap<String, Object>();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String actionName = method.getAnnotation(GetCache.class).name();
//		String fieldList = method.getAnnotation(GetCache.class).value();
		Integer expire = method.getAnnotation(GetCache.class).expire();

		String id = null;
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			id = String.valueOf(args[0]);
		}
		actionName += "=" + id;
		String redisKey = signature + "." + actionName;
		res.put("cacheKey", redisKey);
		res.put("expire", expire);
		return res;
	}

}
