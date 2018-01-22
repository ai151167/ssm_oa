package com.oa.demo.qsy.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.basecontroller.BaseController;
import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysUserSub;
import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
		
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("/userMana")
	public String userMana() {
		return "user/userMana";
	}
	
	@ResponseBody
	@RequestMapping("/userList")
	public ModelAndView userList(CommonParam param){
		ModelAndView model = new ModelAndView();
		Map<String, Object> result =  userServiceImpl.userList(param);
		model.setViewName("user/userList");
		model.addObject("userList", result.get("list"));
		model.addObject("count", result.get("count"));
		model.addObject("page", result.get("page"));
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(SysUser sysUser) {
		return userServiceImpl.addUser(sysUser);
	}
	
	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(SysUser sysUser) {
		return userServiceImpl.updateUser(sysUser);
	}
	
	@ResponseBody
	@RequestMapping("/queryUser")
	public SysUserSub queryUser(HttpServletRequest request) {
		Map<String, Object> param = this.getParam(request);
		return userServiceImpl.queryUser(CommonUtils.stringToLong(param.get("userId").toString()));
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Map<String, Object> param = this.getParam(request);
		return userServiceImpl.delete(CommonUtils.stringToLong(param.get("userId").toString()));
	}
	
	@ResponseBody
	@RequestMapping("/getUserStatistics")
	public Map<String,Object> getUserStatistics(){
		return userServiceImpl.getUserStatistics();
	}
	
	@ResponseBody
	@RequestMapping("/getUserSexStatistics")
	public Map<String, Object> getUserSexStatistics(){
		return userServiceImpl.getUserSexStatistics();
	}
}
