package com.oa.demo.qsy.service;

import java.util.List;
import java.util.Map;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysUserSub;
import com.oa.demo.qsy.pojo.SysRoleUserRel;
import com.oa.demo.qsy.pojo.SysUser;

public interface IUserService {

	Map<String, Object> userList(CommonParam param);

	String addUser(SysUser sysUser);

	String updateUser(SysUser sysUser);

	SysUserSub queryUser(Long stringToLong);

	String delete(Long stringToLong);

	Map<String, Object> loginCheck(SysUser user);

	Map<String, Object> delRoleUserRel(CommonParam param);

	List<SysUser> getUserByOrgId(Long orgId);

	boolean addRoleUserRel(SysRoleUserRel param);

	Map<String, Object> getUserStatistics();

	Map<String, Object> getUserSexStatistics();

	void insertSheetData(List<Map<String, Object>> list) throws Exception;

	List<Map<String, Object>> queryColumnList();

}
