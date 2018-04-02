package com.ding.web.home;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.ding.web.util.DecriptUtil;

@Controller
public class UserShiroController {

	@RequestMapping("/index.jhtml")
	public ModelAndView getIndex(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("/exceptionForPageJumps.jhtml")
	public ModelAndView exceptionForPageJumps(HttpServletRequest request) throws Exception {
		throw new Exception();
	}
	
	@RequestMapping(value="/businessException.json", method=RequestMethod.POST)
	@ResponseBody  
	public String businessException(HttpServletRequest request) throws Exception {
		throw new Exception();
	}
	
	@RequestMapping(value="/otherException.json", method=RequestMethod.POST)
	@ResponseBody  
	public String otherException(HttpServletRequest request) throws Exception {
		throw new Exception();
	}
	
	//登录
	@RequestMapping("/login.jhtml")
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	//登录成功页面
	@RequestMapping("/loginsuccess.jhtml")
	public ModelAndView loginsuccess() throws Exception {
		ModelAndView mav = new ModelAndView("loginsuccess");
		return mav;
	}
	
	@RequestMapping("/newPage.jhtml")
	public ModelAndView newPage() throws Exception {
		ModelAndView mav = new ModelAndView("newPage");
		return mav;
	}
	
	@RequestMapping("/newPageNotAdd.jhtml")
	public ModelAndView newPageNotAdd() throws Exception {
		ModelAndView mav = new ModelAndView("newPageNotAdd");
		return mav;
	}
	
	/** 
     * 验证用户名密码
     * @param String username,String password
     * @return 
	 * @throws Exception 
     */  
    @RequestMapping(value="/checkLogin.json",method=RequestMethod.POST)  
    @ResponseBody  
    public String checkLogin(String username,String password) throws Exception {  
    	Map<String, Object> result = new HashMap<String, Object>();
    	try{
    		UsernamePasswordToken token = new UsernamePasswordToken(username, DecriptUtil.MD5(password));  
            Subject currentUser = SecurityUtils.getSubject();  
            if (!currentUser.isAuthenticated()){
            	//ʹ��shiro����֤  
                token.setRememberMe(true);  
                currentUser.login(token);//��֤��ɫ��Ȩ��  
            } 
    	}catch(Exception ex){
//    		throw new BusinessException(LuoErrorCode.LOGIN_VERIFY_FAILURE);
    			throw ex;
    	}
        result.put("success", true);
        return JSON.toJSONString(result);  
    }  
	
    /** 
     * 退出登录
     */  
    @RequestMapping(value="/logout.json",method=RequestMethod.POST)    
    @ResponseBody    
    public String logout() {   
    	Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        Subject currentUser = SecurityUtils.getSubject();       
        currentUser.logout();    
        return JSON.toJSONString(result);
    }  
}
