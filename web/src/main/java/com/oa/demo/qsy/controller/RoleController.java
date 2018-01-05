package com.oa.demo.qsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.demo.qsy.pojo.SysRole;
import com.oa.demo.qsy.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleServiceImpl;
	
	@ResponseBody
	@RequestMapping("/queryRoleList")
	public List<SysRole> queryRoleList(){
		return roleServiceImpl.queryRoleList();
	}
}
