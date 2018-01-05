package com.oa.demo.qsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.pojo.SysRole;
import com.oa.demo.qsy.pojo.SysRoleExample;
import com.oa.demo.qsy.pojo.mapper.SysRoleMapper;
import com.oa.demo.qsy.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public List<SysRole> queryRoleList() {
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andStateEqualTo(Constant.ONE);
		return sysRoleMapper.selectByExample(example );
	}

}
