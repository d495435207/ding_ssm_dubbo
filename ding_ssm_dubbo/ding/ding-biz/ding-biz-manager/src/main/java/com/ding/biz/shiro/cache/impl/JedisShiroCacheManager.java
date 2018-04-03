package com.ding.biz.shiro.cache.impl;

import org.apache.shiro.cache.Cache;

import com.ding.biz.shiro.cache.JedisManager;
import com.ding.biz.shiro.cache.JedisShiroCache;
import com.ding.biz.shiro.cache.ShiroCacheManager;
/**
* <p>Title: JedisShiroCacheManager.java</p>  
* <p>package: com.ding.biz.shiro.cache.impl</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月3日  
* @version 1.0
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
