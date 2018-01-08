package com.oa.demo.qsy.service;

import java.util.List;
import java.util.Map;

import com.oa.demo.qsy.pojo.SysOrg;

public interface IOrgService {

	List<SysOrg> getOrgListByParentId(Long pid);

	Map<String, Object> queryOrgList(Map<String, Object> param);

}
