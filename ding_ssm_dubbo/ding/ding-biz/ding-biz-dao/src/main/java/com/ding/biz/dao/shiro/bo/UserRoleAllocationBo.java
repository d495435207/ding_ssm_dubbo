package com.ding.biz.dao.shiro.bo;

import java.io.Serializable;

import com.ding.biz.dao.shiro.data.UUser;
/**
 * 用户角色分配 查询列表BO
* <p>Title: UserRoleAllocationBo.java</p>  
* <p>package: com.ding.biz.dao.shiro.bo</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
public class UserRoleAllocationBo extends UUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Role Name列转行，以,分割
	private String roleNames;
	//Role Id列转行，以‘,’分割
	private String roleIds;
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
}
