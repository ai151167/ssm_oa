package com.oa.demo.qsy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.basecontroller.BaseController;
import com.oa.demo.qsy.pojo.SysRole;
import com.oa.demo.qsy.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	
	@Autowired
	private IRoleService roleServiceImpl;
	
	@RequestMapping("/roleMana")
	public String toRoleMana() {
		return "role/roleMana";
	}
	
	
	@RequestMapping("/queryRoleList")
	public ModelAndView queryRoleList(HttpServletRequest request){
		Map<String, Object> param = this.getParam(request);
		ModelAndView view = new ModelAndView();
		Map<String, Object> result = roleServiceImpl.queryRoleList(param);
		view.addObject("roleList", result.get("list"));
		view.addObject("count", result.get("count"));
		view.addObject("page", result.get("page"));
		view.setViewName("/role/roleList");
		return view;
	}
	
	@ResponseBody
	@RequestMapping("/saveRole")
	public String saveRole(HttpServletRequest request) throws Exception{
		Map<String, Object> param = this.getParam(request);
		String isOk = "ERROR";
		short state = CommonUtils.stringToShort(param.get("state").toString());
		param.put("state", state);
		Long roleId =CommonUtils.stringToLong(param.get("roleId").toString());
		if(roleId!=null&&!"".equals(roleId)&&roleId!=0) {
			param.put("roleId", roleId);
			roleServiceImpl.updateRole(param);
			isOk = "SUCCESS";
		}else {
			roleServiceImpl.addRole(param);
			isOk = "SUCCESS";
		}
		
		return isOk;
	}
	
	@ResponseBody
	@RequestMapping("getRoleInfo")
	public SysRole getRoleInfo(HttpServletRequest request) {
		Map<String, Object> param = this.getParam(request);
		return roleServiceImpl.getRoleInfo(CommonUtils.stringToLong(param.get("roleId").toString()));
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteRoleById")
	public String deleteRoleById(HttpServletRequest request) {
		Map<String, Object> param = this.getParam(request);
		return roleServiceImpl.deleteRoleById(CommonUtils.stringToLong(param.get("roleId").toString()));
	}
}
