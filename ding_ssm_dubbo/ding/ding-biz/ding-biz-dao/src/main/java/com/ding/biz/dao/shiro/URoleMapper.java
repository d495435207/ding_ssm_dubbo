package com.ding.biz.dao.shiro;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ding.biz.dao.shiro.data.URole;
/**
* <p>Title: URoleMapper.java</p>  
* <p>package: com.ding.biz.dao.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public interface URoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(URole record);

    int insertSelective(URole record);

    URole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URole record);

    int updateByPrimaryKey(URole record);

	Set<String> findRoleByUserId(Long id);

	List<URole> findNowAllPermission(Map<String, Object> map);
	
	void initData();
}