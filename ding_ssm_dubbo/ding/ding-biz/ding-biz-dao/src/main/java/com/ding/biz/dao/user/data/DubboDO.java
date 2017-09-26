package com.ding.biz.dao.user.data;

import java.io.Serializable;

public class DubboDO implements Serializable{
	private static final long serialVersionUID = 2994701709434403724L;
	private Integer id;
	private String dubbo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDubbo() {
		return dubbo;
	}
	public void setDubbo(String dubbo) {
		this.dubbo = dubbo;
	}
	
}
