package com.oa.demo.qsy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.service.IOrgService;
import com.oa.demo.qsy.service.IUserService;

@Controller
@RequestMapping("/userTree")
public class UserTreeController {
	
	@Autowired
	private IOrgService orgService;
	
	@Autowired
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("/userSubList")
	public List<Map<String, Object>> addAuthUser(HttpServletRequest request){
		String orgParentId = request.getParameter("id");
		if(orgParentId==null || "".equals(orgParentId)){
			orgParentId="-1";
		}
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("orgParentId", orgParentId);
		
		List<Map<String, Object>> list = new ArrayList<>();
		List<SysOrg> orgList = orgService.getOrgListByParentId(CommonUtils.stringToLong(orgParentId));
		for(int i=0;i<orgList.size();i++){
			Map<String, Object> orgMap = new HashMap<>();
			SysOrg org = orgList.get(i);
			orgMap.put("id", org.getOrgId());
			orgMap.put("name", org.getOrgName());
			orgMap.put("isParent", true);
			
			list.add(orgMap);
		}
		
		List<SysUser> userList = userService.getUserByOrgId(CommonUtils.stringToLong(orgParentId));
		for(int i=0;i<userList.size();i++){
			Map<String, Object> userMap = new HashMap<>();
			SysUser user = userList.get(i);
			userMap.put("id", user.getUserId());
			userMap.put("name", user.getUserChName());
			userMap.put("isParent", false);
			
			list.add(userMap);
		}
		return list;
		
	}
}
