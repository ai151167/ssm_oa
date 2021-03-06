package com.oa.demo.qsy.service;

import java.util.List;
import java.util.Map;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysOrgSub;
import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.pojo.SysRoleOrgRel;

public interface IOrgService {

	List<SysOrg> getOrgListByParentId(Long pid);

	Map<String, Object> queryOrgList(Map<String, Object> param);

	void addOrg(Map<String, Object> param) throws Exception;

	void updataOrg(Map<String, Object> param) throws Exception;

	SysOrgSub queryOrgInfo(Long orgId);

	Map<String, Object> deleteOrg(Long orgId);

	Map<String, Object> delRoleOrgRel(CommonParam param);

	boolean addRoleOrgRel(SysRoleOrgRel param);

}
