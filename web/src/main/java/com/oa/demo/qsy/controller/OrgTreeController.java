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
import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.service.IOrgService;

@Controller
@RequestMapping("/orgTree")
public class OrgTreeController {

	@Autowired
	private IOrgService orgServiceImpl;
	
	@RequestMapping("/getOrgTreeList")
	@ResponseBody
	public List<Map<String, Object>> getOrgTreeList(HttpServletRequest request) {
		String parentId = request.getParameter("id");
		if(parentId==null||"".equals(parentId)) {
			parentId ="-1";
		}
		List<SysOrg> listByParentId = orgServiceImpl.getOrgListByParentId(CommonUtils.stringToLong(parentId));
		List<Map<String, Object>> list = new ArrayList<>();
		for (SysOrg sysOrg : listByParentId) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("id", sysOrg.getOrgId());
			resultMap.put("name", sysOrg.getOrgName());
			if(sysOrg.getIsParent()==Constant.ONE&&sysOrg.getIsParent()!=null&&!"".equals(sysOrg.getIsParent())) {
				resultMap.put("isParent",true);
			}else {
				resultMap.put("isParent",false);
			}
			
			list.add(resultMap);
		}
		return list;
	}
}
