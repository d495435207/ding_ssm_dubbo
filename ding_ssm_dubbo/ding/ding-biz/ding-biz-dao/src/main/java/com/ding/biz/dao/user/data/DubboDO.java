package com.ding.biz.dao.user.data;

import java.io.Serializable;
/**
* <p>Title: DubboDO.java</p>  
* <p>package: com.ding.biz.dao.user.data</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月2日  
* @version 1.0
 */
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
