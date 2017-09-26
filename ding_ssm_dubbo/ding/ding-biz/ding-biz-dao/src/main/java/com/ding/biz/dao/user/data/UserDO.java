package com.ding.biz.dao.user.data;

import java.io.Serializable;

public class UserDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6121735005188850456L;
	private Integer id;
	private String name;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
