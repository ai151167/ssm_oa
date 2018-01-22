package com.oa.demo.qsy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.pojo.SysRole;
import com.oa.demo.qsy.pojo.SysRoleMenuRel;
import com.oa.demo.qsy.pojo.SysRoleOrgRel;
import com.oa.demo.qsy.pojo.SysRoleUserRel;
import com.oa.demo.qsy.service.IMenuService;
import com.oa.demo.qsy.service.IOrgService;
import com.oa.demo.qsy.service.IRoleService;
import com.oa.demo.qsy.service.IUserService;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
	
	@Autowired
	private IRoleService roleServiceImpl;
	
	@Autowired
	private IOrgService orgServiceImpl;
	
	@Autowired
	private IUserService userServiceImpl;
	
	@Autowired
	private IMenuService menuServiceImpl;
	
	@RequestMapping("/authorizationMana")
	public String Authorization() {
		return "authorization/authorizationMana";
	}
	
	@ResponseBody
	@RequestMapping("/getRoleList")
	public List<SysRole> getRoleList() {
		return roleServiceImpl.getRoleList();
	}

	@ResponseBody
	@RequestMapping("/queryAuthOrg")
	public ModelAndView queryAuthOrg(CommonParam param) {
		ModelAndView model = new ModelAndView();
		Map<String, Object> data = new HashMap<>();
		data.put("startIndex", param.getStartIndex());
		data.put("pageSize", param.getPageSize());
		data.put("orgId", param.getOrgId());
		data.put("roleId", param.getRoleId());
		data.put("auth","org");
		Map<String, Object> orgMap = orgServiceImpl.queryOrgList(data);
		model.addObject("count", orgMap.get("orgCount"));
		model.addObject("page", orgMap.get("totalPages"));
		model.addObject("orgList", orgMap.get("orgList"));
		model.setViewName("authorization/orgList");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/queryAuthMenu")
	public ModelAndView queryAuthMenu(CommonParam param) {
		ModelAndView model = new ModelAndView();
		Map<String, Object> menuMap = menuServiceImpl.getMenuPageInfo(param);
		model.addObject("count", menuMap.get("count"));
		model.addObject("page", menuMap.get("page"));
		model.addObject("menuList", menuMap.get("menuList"));
		model.setViewName("authorization/menuList");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/queryAuthUser")
	public ModelAndView queryAuthUser(CommonParam param) {
		ModelAndView model = new ModelAndView();
		Map<String, Object> userMap = userServiceImpl.userList(param);
		model.addObject("count", userMap.get("count"));
		model.addObject("page", userMap.get("page"));
		model.addObject("userList",userMap.get("list"));
		model.setViewName("authorization/userList");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/delRoleOrgRel")
	public Map<String, Object> delRoleOrgRel(CommonParam param) {
		return orgServiceImpl.delRoleOrgRel(param);
	}
	
	@ResponseBody
	@RequestMapping("/delRoleMenuRel")
	public Map<String, Object> delRoleMenuRel(CommonParam param) {
		return menuServiceImpl.delRoleMenuRel(param);
	}
	
	@ResponseBody
	@RequestMapping("/delRoleUserRel")
	public Map<String, Object> delRoleUserRel(CommonParam param) {
		return userServiceImpl.delRoleUserRel(param);
	}
	
	@ResponseBody
	@RequestMapping("/addRoleMenuRel")
	public boolean addRoleMenuRel(SysRoleMenuRel param) {
		return menuServiceImpl.addRoleMenuRel(param);
	}
	
	@ResponseBody
	@RequestMapping("/addRoleOrgRel")
	public boolean addRoleOrgRel(SysRoleOrgRel param) {
		return orgServiceImpl.addRoleOrgRel(param);
	}
	
	@ResponseBody
	@RequestMapping("/addRoleUserRel")
	public boolean addRoleUserRel(SysRoleUserRel param) {
		return userServiceImpl.addRoleUserRel(param);
	}
}
