package com.oa.demo.qsy.service;

import java.util.List;
import java.util.Map;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysMenuSub;
import com.oa.demo.qsy.pojo.SysMenu;
import com.oa.demo.qsy.pojo.SysRoleMenuRel;

public interface IMenuService {

	Map<String, Object> getMenuPageInfo(CommonParam param);

	List<SysMenu> getMenuList();

	List<SysMenu> menuDirSubList(Long pid);

	SysMenuSub queryMenu(Long menuId);

	Boolean addMenu(SysMenu menu);

	Boolean updataMenu(SysMenu menu);

	boolean deleteMenu(Long menuId);

	Map<String, Object> delRoleMenuRel(CommonParam param);

	boolean addRoleMenuRel(SysRoleMenuRel param);

}
