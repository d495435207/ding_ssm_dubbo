package com.ding.biz.dao.shiro.bo;

import java.io.Serializable;
/**
* <p>Title: RolePermissionAllocationBo.java</p>  
* <p>package: com.ding.biz.dao.shiro.bo</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */

public class RolePermissionAllocationBo implements Serializable {
	private static final long serialVersionUID = 1L;
	//角色ID
	private Long id;
	//角色type
	private String type;
	//角色Name
	private String name;
	//权限Name列转行，以,分割
	private String permissionNames;
	//权限Id列转行，以‘,’分割
	private String permissionIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPermissionNames() {
		return permissionNames;
	}

	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
	
	
}
