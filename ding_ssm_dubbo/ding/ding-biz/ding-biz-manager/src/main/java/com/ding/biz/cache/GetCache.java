package com.ding.biz.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/** 
* @ClassName: GetCache 
* @Description: redis缓存自定义注解 
* @author dinglh
* @date 2017年10月13日 下午1:33:03 
*  
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetCache {
	String name() default "";
	//String value() default "";
	int expire() default 60;
}
