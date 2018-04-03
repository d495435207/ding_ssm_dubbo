package com.ding.biz.dao.shiro;

import java.util.List;
import java.util.Set;

import com.ding.biz.dao.shiro.bo.UPermissionBo;
import com.ding.biz.dao.shiro.data.UPermission;

/**
* <p>Title: UPermissionMapper.java</p>  
* <p>package: com.ding.biz.dao.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public interface UPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UPermission record);

    int insertSelective(UPermission record);

    UPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermission record);

    int updateByPrimaryKey(UPermission record);

	List<UPermissionBo> selectPermissionById(Long id);
	//根据用户ID获取权限的Set集合
	Set<String> findPermissionByUserId(Long id);
}