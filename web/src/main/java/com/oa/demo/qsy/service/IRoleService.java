package com.oa.demo.qsy.service;

import java.util.List;
import java.util.Map;

import com.oa.demo.qsy.pojo.SysRole;



public interface IRoleService {

	Map<String, Object> queryRoleList(Map<String, Object> param);

	void updateRole(Map<String, Object> param) throws Exception;

	void addRole(Map<String, Object> param) throws Exception;

	SysRole getRoleInfo(Long stringToLong);

	String deleteRoleById(Long stringToLong);

	List<SysRole> getRoleList();

}
