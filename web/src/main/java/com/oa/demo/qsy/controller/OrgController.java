package com.oa.demo.qsy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.basecontroller.BaseController;
import com.oa.demo.qsy.common.pojo.org.SysOrgSub;
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
	public ModelAndView queryOrgList(HttpServletRequest request){
		Map<String, Object> param = this.getParam(request);
		ModelAndView model = new ModelAndView();
		Map<String, Object> orgMap= orgServiceImpl.queryOrgList(param);
		model.addObject("list",orgMap.get("orgList"));
		model.addObject("total", orgMap.get("orgCount"));
		model.addObject("page", orgMap.get("totalPages"));
		model.setViewName("org/orgList");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/OrgListByParentId/{pid}")
	public List<SysOrg> getOrgListByParentId(@PathVariable Long pid){
		List<SysOrg> orgs = orgServiceImpl.getOrgListByParentId(pid);
		return orgs;
	}
	
	@RequestMapping("/getPageNumber")
	public ModelAndView getPageNumber(HttpServletRequest request) {
		Map<String, Object> param = this.getParam(request);
		ModelAndView result = new ModelAndView("org/orgPageNumber");
		return this.getPageNumberInfo(CommonUtils.stringToInt(param.get("totalCount").toString()),CommonUtils.stringToInt(param.get("startIndex").toString()) ,CommonUtils.stringToInt(param.get("pageSize").toString()), result );
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request) throws Exception {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = this.getParam(request);
		result.put("isSuccess", false);
		if(param.get("orgId")==null||"".equals(param.get("orgId"))) {
			orgServiceImpl.addOrg(param);
			result.put("isSuccess", true);
		}else {
			orgServiceImpl.updataOrg(param);
			result.put("isSuccess", true);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/queryOrgInfo")
	public SysOrgSub queryOrgInfo(SysOrg org) {
		SysOrgSub sysOrg =  orgServiceImpl.queryOrgInfo(org.getOrgId());
		return sysOrg;
	}
	
	@ResponseBody
	@RequestMapping("/deleteOrg")
	public Map<String, Object> deleteOrg(SysOrg org){
		return orgServiceImpl.deleteOrg(org.getOrgId());
	}
	
	@ResponseBody
	@RequestMapping("/getCountAndPage")
	public Map<String, Object> getCountAndPage(HttpServletRequest request){
		Map<String, Object> param = this.getParam(request);
		return orgServiceImpl.getCountAndPage(param);
	}
	
}
