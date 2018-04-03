package com.ding.biz.dao.shiro;

import java.util.List;
import java.util.Map;

import com.ding.biz.dao.shiro.data.UUserRole;
/**
* <p>Title: UUserRoleMapper.java</p>  
* <p>package: com.ding.biz.dao.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public interface UUserRoleMapper {
    int insert(UUserRole record);

    int insertSelective(UUserRole record);

	int deleteByUserId(Long id);

	int deleteRoleByUserIds(Map<String, Object> resultMap);

	List<Long> findUserIdByRoleId(Long id);
}