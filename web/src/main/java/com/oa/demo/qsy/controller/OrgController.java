package com.oa.demo.qsy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.basecontroller.BaseController;
import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.service.IOrgService;

@Controller
@RequestMapping("/org")
public class OrgController extends BaseController {
	
	@Autowired
	private IOrgService orgServiceImpl;
	
	@RequestMapping("/OrgManage")
	public String OrgManage() {
		return "org/orgMana";
	}
	
	
	@RequestMapping("/queryOrgList")
	public ModelAndView queryOrgList(HttpServletRequest request, Map<String, Object> map){
		Map<String, Object> param = this.getParam(request);
		ModelAndView model = new ModelAndView();
		Map<String, Object> orgMap= orgServiceImpl.queryOrgList(param);
		model.setViewName("org/orgList");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/OrgListByParentId/{pid}")
	public List<SysOrg> getOrgListByParentId(@PathVariable Long pid){
		List<SysOrg> orgs = orgServiceImpl.getOrgListByParentId(pid);
		return orgs;
	}
}
