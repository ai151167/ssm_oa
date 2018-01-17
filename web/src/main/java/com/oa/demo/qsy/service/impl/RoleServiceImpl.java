package com.oa.demo.qsy.service.impl;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.MapAndObject;
import com.oa.demo.qsy.pojo.SysRole;
import com.oa.demo.qsy.pojo.mapper.SysRoleMapper;
import com.oa.demo.qsy.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public Map<String, Object> queryRoleList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		if(param.get("state")!=null&&!"".equals(param.get("state"))) {
			param.put("state", CommonUtils.stringToShort(param.get("state").toString()));
		}
		param.put("startIndex", CommonUtils.stringToInt(param.get("startIndex").toString()));
		param.put("pageSize", CommonUtils.stringToInt(param.get("pageSize").toString()));
		long count = roleCount(param);
		int page = CommonUtils.longToInt(count)%CommonUtils.stringToInt(param.get("pageSize").toString())==0?CommonUtils.longToInt(count)/CommonUtils.stringToInt(param.get("pageSize").toString()):CommonUtils.longToInt(count)/CommonUtils.stringToInt(param.get("pageSize").toString())+1;
		List<SysRole> list = sysRoleMapper.selectRoleListByCondition(param);
		result.put("count",CommonUtils.longToInt(count));
		result.put("list", list);
		result.put("page", page);
		return result;
		
	}
	
	public long roleCount(Map<String,Object> param) {
		return sysRoleMapper.roleCount(param);
	}

	@Override
	public void updateRole(Map<String, Object> param) throws Exception {
		SysRole role = (SysRole) MapAndObject.mapToObject(param, SysRole.class);
		sysRoleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void addRole(Map<String, Object> param) throws Exception {
		SysRole role = (SysRole) MapAndObject.mapToObject(param, SysRole.class);
		role.setCreatedDate(new Date());
		sysRoleMapper.insertSelective(role);
	}

	@Override
	public SysRole getRoleInfo(Long stringToLong) {
		SysRole sysRole = null;
		if(stringToLong!=0) {
			sysRole = sysRoleMapper.selectByPrimaryKey(stringToLong);
		}
		return sysRole;
	}

	@Override
	public String deleteRoleById(Long stringToLong) {
		String isOk = "FAILED";
		if(stringToLong!=0) {
			SysRole sysRole = sysRoleMapper.selectByPrimaryKey(stringToLong);
			sysRole.setState(Constant.TWO);
			sysRoleMapper.updateByPrimaryKeySelective(sysRole);
			isOk="SUCCESS";
		}
		return isOk;
	}


}
