package com.ding.rpc.share.demo.dto;

import java.io.Serializable;

public class DemoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7895456668982574338L;
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
