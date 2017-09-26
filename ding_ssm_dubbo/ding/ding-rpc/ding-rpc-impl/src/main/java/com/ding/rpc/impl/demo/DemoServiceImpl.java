package com.ding.rpc.impl.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.ding.biz.dao.user.data.DubboDO;
import com.ding.biz.manager.user.DubboManager;
import com.ding.rpc.share.demo.DemoService;
import com.ding.rpc.share.demo.dto.DemoDTO;

public class DemoServiceImpl implements DemoService{
	@Autowired
	private DubboManager dubboManager;
	
	public DemoDTO get(Integer id) {
		DubboDO dubboDO = dubboManager.get(id);
		DemoDTO demo = new DemoDTO();
		if(dubboDO==null){
			return demo;
		}
		demo.setId(dubboDO.getId());
		demo.setDubbo(dubboDO.getDubbo());
		return demo;
	}
	
}
