package com.oa.demo.qsy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("/login")
	public String login() {
		return "common/login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(SysUser user,ModelMap map ) {
		Map<String, Object> result =  userServiceImpl.loginCheck(user);
		if(result.get("user")!=null) {
			SysUser sysUser = (SysUser) result.get("user");
			map.put("user",sysUser);
			return "common/main";
		}else {
			map.put("data", result.get("data"));
			return "common/login";
		}
		
	}
}
