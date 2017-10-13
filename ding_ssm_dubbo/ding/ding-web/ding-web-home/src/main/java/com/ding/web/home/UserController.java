package com.ding.web.home;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.handsome.rpc.share.test.TestService;
import org.handsome.rpc.share.test.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ding.biz.cache.GetCache;
import com.ding.biz.dao.user.data.UserDO;
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
	/*@Autowired
	private TestService testService;*/
	private final Log logger = LogFactory.getLog(getClass());
	
	@GetCache(name="redis_user",value="userId")
	@RequestMapping(value="/redis")
    public String redis(Integer userId,Model model){
		logger.info("试验redis0000000000000000");
    	 UserDO userDO = userManager.get(userId);
    	 model.addAttribute("user", userDO);
    	return "user/user";
    }
	@RequestMapping(value="/user")
    public String user(Integer userId,Model model){
		logger.info("00000000000000000000");
    	 UserDO userDO = userManager.get(userId);
    	 model.addAttribute("user", userDO);
    	return "user/user";
    }
	/*@RequestMapping(value="/test")
	public String test(Integer id,Model model){
		logger.info("-----------test-dubbo-");
		TestDTO testDTO = testService.get(id);
		model.addAttribute("test", testDTO);
		return "user/test";
	}*/
}
