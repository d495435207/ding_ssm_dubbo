package com.ding.biz.cache;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.ding.biz.cache.util.RedisCache;

@Component
@Aspect
public class GetCacheAOP {
	private RedisTemplate<Serializable, Object> redisTemplate;

	private RedisCache redisCache = new RedisCache();

	@Pointcut(value = "execution(* com.ding.biz.manager.user.impl..*.get*(..))")
	public void getCache() {
		System.out.println("---这里是一个切点");
	}

	@Around("getCache()")
	public Object beforeExec(ProceedingJoinPoint joinPoint) {
		String cacheKey = getCacheKey(joinPoint);
		Object objectFromRedis = redisCache.getDataFromRedis(cacheKey);
		if (null != objectFromRedis) {
			System.out.println("查到了呢!!");
			return objectFromRedis;
		}
		System.out.println("redis中没有.. 这个要到数据库中查!!");
		Object proceed = null;
		try {
			proceed = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		redisCache.setDataToRedis(cacheKey, proceed);
		return proceed;
	}

	private String getCacheKey(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String actionName = method.getAnnotation(GetCache.class).name();
		String fieldList = method.getAnnotation(GetCache.class).value();
		for (String field : fieldList.split(",")) {
			actionName += "." + field;
		}

		String id = null;
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			id = String.valueOf(args[0]);
		}
		actionName += "=" + id;
		String redisKey = signature + "." + actionName;
		return redisKey;
	}

	public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
