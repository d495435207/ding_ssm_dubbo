package com.ding.biz.dao.shiro;

import java.util.List;
import java.util.Map;

import com.ding.biz.dao.shiro.bo.URoleBo;
import com.ding.biz.dao.shiro.data.UUser;
/**
* <p>Title: UUserMapper.java</p>  
* <p>package: com.ding.biz.dao.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public interface UUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUser record);

    int insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);

	UUser login(Map<String, Object> map);

	UUser findUserByEmail(String email);

	List<URoleBo> selectRoleByUserId(Long id);

}