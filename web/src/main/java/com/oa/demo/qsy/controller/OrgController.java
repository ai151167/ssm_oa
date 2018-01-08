package com.oa.demo.qsy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.service.IOrgService;

@Controller
@RequestMapping("/org")
public class OrgController {
	
	@Autowired
	private IOrgService orgServiceImpl;
	
	@RequestMapping("/queryOrgList")
	public ModelAndView queryOrgList(Map<String, Object> map){
		ModelAndView model = new ModelAndView();
		List<SysOrg> orgList = orgServiceImpl.queryOrgList();
		map.put("list", orgList);
		model.setViewName("org/orgList");
		return model;
	}
}
