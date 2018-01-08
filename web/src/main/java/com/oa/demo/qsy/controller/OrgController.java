package com.oa.demo.qsy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.service.IOrgService;

@Controller
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	private IOrgService orgServiceImpl;
	
	@RequestMapping("/queryOrgList")
	public String queryOrgList(Map<String, Object> map){
		List<SysOrg> orgList = orgServiceImpl.queryOrgList();
		map.put("list", orgList);
		return "page/org/orgList";
	}
}
