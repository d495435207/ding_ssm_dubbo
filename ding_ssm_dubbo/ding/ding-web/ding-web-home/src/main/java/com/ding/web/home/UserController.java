package com.ding.web.home;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ding.biz.cache.GetCache;
import com.ding.biz.dao.user.data.DubboDO;
import com.ding.biz.dao.user.data.UserDO;
import com.ding.biz.manager.user.DubboManager;
import com.ding.biz.manager.user.UserManager;

/**
 * Hello world!
 *
 */
@Controller
public class UserController 
{
	@Autowired
	private UserManager userManager;
	@Autowired
	private DubboManager dubboManager;
	private final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value="/redis")
	@ResponseBody
    public DubboDO redis(Integer id,Model model){
		logger.info("试验redis0000000000000000");
    	 DubboDO dubbo = dubboManager.get(id);
    	return dubbo;
    }
	@RequestMapping(value="/user")
    public String user(Integer userId,Model model){
		logger.info("00000000000000000000");
    	 UserDO userDO = userManager.get(userId);
    	 model.addAttribute("user", userDO);
    	return "user/user";
    }
}
