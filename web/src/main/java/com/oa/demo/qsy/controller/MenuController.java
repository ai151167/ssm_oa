package com.oa.demo.qsy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IMenuService menuServiceImpl;
	
	@RequestMapping("/menu")
	public String getMenu() {
		return "menu/menuMana";
	}
	
	@ResponseBody
	@RequestMapping("/menuPage")
	public ModelAndView menuPage(CommonParam param) {
		ModelAndView model = new ModelAndView();
		Map<String, Object> map =  menuServiceImpl.getMenuPageInfo(param);
		model.addObject("count", map.get("count"));
		model.addObject("menuList", map.get("menuList"));
		model.addObject("page", map.get("page"));
		model.setViewName("menu/menuList");
		return model;
	}
}
