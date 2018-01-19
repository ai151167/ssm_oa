package com.oa.demo.qsy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysMenuSub;
import com.oa.demo.qsy.pojo.SysMenu;
import com.oa.demo.qsy.pojo.SysMenuExample;
import com.oa.demo.qsy.pojo.mapper.SysMenuMapper;
import com.oa.demo.qsy.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public Map<String, Object> getMenuPageInfo(CommonParam param) {
		Map<String, Object> map = new HashMap<>();
		List<SysMenu> menuList =  sysMenuMapper.selectByCondition(param);
		Long count = countByCondition(param);
		Long page = count%param.getPageSize()==0?count/param.getPageSize():count/param.getPageSize()+1;
		if(count==0) {
			page = (long) 1;
		}
		map.put("menuList", menuList);
		map.put("count", count);
		map.put("page", page);
		return map;
	}
	
	protected Long countByCondition(CommonParam param) {
		return sysMenuMapper.countByCondition(param);
	}

	@Override
	public List<SysMenu> getMenuList() {
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andMenuTypeEqualTo(Constant.TWO);
		return sysMenuMapper.selectByExample(example);
	}

	@Override
	public List<SysMenu> menuDirSubList(Long pid) {
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andMenuParentIdEqualTo(pid);
		return sysMenuMapper.selectByExample(example );
	}

	@Override
	public SysMenuSub queryMenu(Long menuId) {
		return sysMenuMapper.selectMenuInfoById(menuId);
	}

	@Override
	public Boolean addMenu(SysMenu menu) {
		boolean isOk = false;
		int i = sysMenuMapper.insert(menu);
		if(i>0) {
			isOk = true;
		}
		return isOk;
	}

	@Override
	public Boolean updataMenu(SysMenu menu) {
		boolean isOk = false;
		int i = sysMenuMapper.updateByPrimaryKeySelective(menu);
		if(i>0) {
			isOk = true;
		}
		return isOk;
	}

	@Override
	public boolean deleteMenu(Long menuId) {
		boolean isOk = false;
		int key = sysMenuMapper.deleteByPrimaryKey(menuId);
		if(key>0) {
			isOk = true;
		}
		return isOk;
	}

}
