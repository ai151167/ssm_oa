package com.oa.demo.qsy.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.MapAndObject;
import com.oa.demo.qsy.common.pojo.org.SysOrgSub;
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
		int startIndex = CommonUtils.stringToInt(param.get("startIndex").toString());
		int pageSize = CommonUtils.stringToInt(param.get("pageSize").toString());
		param.put("startIndex", startIndex);
		param.put("pageSize", pageSize);
		List<SysOrgSub> orgList = sysOrgMapper.queryOrgList(param);
		long count = sysOrgMapper.countByOrgCondition(param);
		int orgCount =new Long(count).intValue();
		int totalPages = 1;
		if(count>0) {
			totalPages = orgCount%pageSize==0?orgCount/pageSize:orgCount/pageSize+1;
		}else {
			count=1;
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("orgList", orgList);
		resultMap.put("orgCount", orgCount);
		resultMap.put("totalPages", totalPages);
		return resultMap;
	}

	@Override
	public List<SysOrg> getOrgListByParentId(Long pid) {
		SysOrgExample example = new SysOrgExample();
		example.createCriteria().andOrgParentIdEqualTo(pid).andStateNotEqualTo(Constant.ZERO);
		return sysOrgMapper.selectByExample(example);
	}

	@Override
	public void addOrg(Map<String, Object> param) throws Exception {
		Long orgParentId = CommonUtils.stringToLong(param.get("orgParentId").toString());
		param.put("orgParentId", orgParentId);
		param.put("dispIndex", CommonUtils.stringToShort(param.get("dispIndex").toString()));
		param.put("state", CommonUtils.stringToShort(param.get("state").toString()));
		SysOrg org = (SysOrg) MapAndObject.mapToObject(param, SysOrg.class);
		org.setCreatedDate(new Date());
		SysOrg parentInfo = sysOrgMapper.selectByPrimaryKey(orgParentId);
		if(parentInfo.getIsParent()!=Constant.ONE) {
			parentInfo.setIsParent(Constant.ONE);
			sysOrgMapper.updateByPrimaryKey(parentInfo);
		}
		org.setIsParent(Constant.ZERO);
		sysOrgMapper.insert(org);
	}

	@Override
	public void updataOrg(Map<String, Object> param) throws Exception {
		Long orgId = CommonUtils.stringToLong(param.get("orgId").toString());
		Long orgParentId = CommonUtils.stringToLong(param.get("orgParentId").toString());
		SysOrg oldOrgInfo = sysOrgMapper.selectByPrimaryKey(orgId);
		param.put("orgId", orgId);
		param.put("orgParentId", orgParentId);
		param.put("dispIndex", CommonUtils.stringToShort(param.get("dispIndex").toString()));
		param.put("state", CommonUtils.stringToShort(param.get("state").toString()));
		SysOrg org = (SysOrg) MapAndObject.mapToObject(param, SysOrg.class);
		sysOrgMapper.updateByPrimaryKeySelective(org);
		SysOrg newOrgInfo = sysOrgMapper.selectByPrimaryKey(orgParentId);
		if(CountByParentId(oldOrgInfo.getOrgParentId())<1) {
			oldOrgInfo.setIsParent(Constant.ZERO);
			sysOrgMapper.updateByPrimaryKeySelective(oldOrgInfo);
		}
		
		if(CountByParentId(newOrgInfo.getOrgParentId())>0) {
			newOrgInfo.setIsParent(Constant.ONE);
			sysOrgMapper.updateByPrimaryKeySelective(newOrgInfo);
		}
	}

	@Override
	public SysOrgSub queryOrgInfo(Long orgId) {
		return sysOrgMapper.selectOrgInfo(orgId);
	}

	protected long CountByParentId(long parentId) {
		SysOrgExample example = new SysOrgExample();
		example.createCriteria().andOrgParentIdEqualTo(parentId).andStateEqualTo(Constant.ONE);
		return sysOrgMapper.countByExample(example );
	}

	@Override
	public Map<String, Object> deleteOrg(Long orgId) {
		Map<String, Object> result = new HashMap<>();
		SysOrg sysOrg = sysOrgMapper.selectByPrimaryKey(orgId);
		sysOrg.setState(Constant.TWO);
		sysOrgMapper.updateByPrimaryKeySelective(sysOrg);
		result.put("isSuccess", true);
		return result;
	}

	@Override
	public Map<String, Object> getCountAndPage(Map<String, Object> param) {
		Map<String, Object> resultMap = new HashMap<>();
		int pageSize = CommonUtils.stringToInt(param.get("pageSize").toString());
		param.put("pageSize", pageSize);
		long count = sysOrgMapper.countByOrgCondition(param);
		int orgCount =new Long(count).intValue();
		int totalPages = 1;
		if(count>0) {
			totalPages = orgCount%pageSize==0?orgCount/pageSize:orgCount/pageSize+1;
		}else {
			count=1;
		}
		resultMap.put("page", totalPages);
		resultMap.put("count", orgCount);
		return resultMap;
	}
}
