package com.ding.biz.dao.shiro;

import java.util.List;
import java.util.Map;

import com.ding.biz.dao.shiro.data.URolePermission;
/**
* <p>Title: URolePermissionMapper.java</p>  
* <p>package: com.ding.biz.dao.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public interface URolePermissionMapper {
    int insert(URolePermission record);

    int insertSelective(URolePermission record);

	List<URolePermission> findRolePermissionByPid(Long id);
	
	List<URolePermission> findRolePermissionByRid(Long id);
	
	List<URolePermission> find(URolePermission entity);
	
	int deleteByPid(Long id);
	int deleteByRid(Long id);
	int delete(URolePermission entity);

	int deleteByRids(Map<String,Object> resultMap);
}