package com.oa.demo.qsy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysMenuSub;
import com.oa.demo.qsy.pojo.SysMenu;
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
	
	@RequestMapping("/left")
	public ModelAndView menuList() {
		ModelAndView model = new ModelAndView();
		List<SysMenu> list =  menuServiceImpl.getMenuList();
		model.addObject("menuList", list);
		model.setViewName("common/left");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/queryMenu")
	public SysMenuSub queryMenu(HttpServletRequest request) {
		String menuId = request.getParameter("menuId");
		return menuServiceImpl.queryMenu(CommonUtils.stringToLong(menuId));
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public Boolean addMenu(SysMenu menu) {
		return menuServiceImpl.addMenu(menu);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Boolean updateMenu(SysMenu menu) {
		return menuServiceImpl.updataMenu(menu);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public boolean deleteMenu(HttpServletRequest request) {
		String menuId = request.getParameter("menuId");
		return menuServiceImpl.deleteMenu(CommonUtils.stringToLong(menuId));
	}
}
