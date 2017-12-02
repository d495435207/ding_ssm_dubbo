package com.ding.web.home;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.handsome.rpc.share.test.TestService;
//import org.handsome.rpc.share.test.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
//	@Autowired
//	private TestService testService;
	private final Log logger = LogFactory.getLog(getClass());
	
	
	@RequestMapping(value="/user")
    public String user(Integer userId,Model model){
		logger.info("00000000000000000000");
    	 UserDO userDO = userManager.get(userId);
    	 model.addAttribute("user", userDO);
    	return "user/user";
    }
/*	@RequestMapping(value="/test")
	public String test(Integer id,Model model){
		logger.info("-----------test-dubbo-");
		TestDTO testDTO = testService.get(id);
		model.addAttribute("test", testDTO);
		return "user/test";
	}*/
}
