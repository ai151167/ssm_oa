package com.oa.demo.qsy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.pojo.SysOrgExample;
import com.oa.demo.qsy.pojo.mapper.SysOrgMapper;
import com.oa.demo.qsy.service.IOrgService;

@Service
public class OrgServiceImpl implements IOrgService {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Override
	public Map<String, Object> queryOrgList(Map<String, Object> param) {
	
		return param;
	}

	@Override
	public List<SysOrg> getOrgListByParentId(Long pid) {
		SysOrgExample example = new SysOrgExample();
		example.createCriteria().andOrgParentIdEqualTo(pid).andStateNotEqualTo(Constant.ZERO);
		return sysOrgMapper.selectByExample(example);
	}

}
