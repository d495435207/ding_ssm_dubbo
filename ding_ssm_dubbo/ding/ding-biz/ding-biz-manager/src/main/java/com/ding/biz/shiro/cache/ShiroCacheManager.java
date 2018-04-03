package com.ding.biz.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
* <p>Title: ShiroCacheManager.java</p>  
* <p>package: com.ding.biz.shiro.cache</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月3日  
* @version 1.0
 */
public interface ShiroCacheManager {

    <K, V> Cache<K, V> getCache(String name);

    void destroy();

}
