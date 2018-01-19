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
import com.oa.demo.qsy.pojo.SysMenu;
import com.oa.demo.qsy.service.IMenuService;

@Controller
@RequestMapping("/menuTree")
public class MenuTreeController{
	
	@Autowired
	private IMenuService menuServiceImpl;
	
	@ResponseBody
	@RequestMapping("/menuDirSubList")
	public List<Map<String, Object>> menuDirSubList(HttpServletRequest request ) {
		String id = request.getParameter("id");
		if(id==null||"".equals(id)) {
			id = "-1";
		}
		List<SysMenu> list = menuServiceImpl.menuDirSubList(CommonUtils.stringToLong(id));
		List<Map<String, Object>> result = new ArrayList<>();
		if(list!=null&&list.size()>0) {
			for (SysMenu sysMenu : list) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", sysMenu.getMenuId());
				map.put("name", sysMenu.getMenuName());
				if(sysMenu.getIsParent()==Constant.ONE) {
					map.put("isParent",true);
				}else {
					map.put("isParent", false);
				}
				result.add(map);
			}
		}
		return result;
	}
}
