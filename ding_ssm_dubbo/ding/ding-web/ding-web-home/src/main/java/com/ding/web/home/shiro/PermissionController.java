package com.ding.web.home.shiro;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ding.biz.dao.shiro.data.UPermission;
import com.ding.biz.manager.shiro.PermissionService;
import com.ding.biz.mybatis.page.Pagination;
import com.ding.biz.utils.LoggerUtils;
import com.ding.web.common.controller.BaseController;
/**
* <p>Title: PermissionController.java</p>  
* <p>package: com.ding.web.home.shiro</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: www.dinglh.com</p>  
* @author dinglh  
* @date 2018年4月3日  
* @version 1.0
 */
@Controller
@Scope(value="prototype")
@RequestMapping("permission")
public class PermissionController extends BaseController {
	
	@Autowired
	PermissionService permissionService;
	/**
	 * 权限列表
	 * @param findContent	查询内容
	 * @param pageNo		页码
	 * @param modelMap		参数回显
	 * @return
	 */
	@RequestMapping(value="index")
	public ModelAndView index(String findContent,ModelMap modelMap,Integer pageNo){
		modelMap.put("findContent", findContent);
		Pagination<UPermission> permissions = permissionService.findPage(modelMap,pageNo,pageSize);
		return new ModelAndView("permission/index","page",permissions);
	}
	/**
	 * 权限添加
	 * @param role
	 * @return
	 */
	@RequestMapping(value="addPermission",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addPermission(UPermission psermission){
		try {
			UPermission entity = permissionService.insertSelective(psermission);
			resultMap.put("status", 200);
			resultMap.put("entity", entity);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加权限报错。source[%s]", psermission.toString());
		}
		return resultMap;
	}
	/**
	 * 删除权限，根据ID，但是删除权限的时候，需要查询是否有赋予给角色，如果有角色在使用，那么就不能删除。
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deletePermissionById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteRoleById(String ids){
		return permissionService.deletePermissionById(ids);
	}
}
