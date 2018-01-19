package com.oa.demo.qsy.service;

import java.util.Map;

import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysUserSub;
import com.oa.demo.qsy.pojo.SysUser;

public interface IUserService {

	Map<String, Object> userList(CommonParam param);

	String addUser(SysUser sysUser);

	String updateUser(SysUser sysUser);

	SysUserSub queryUser(Long stringToLong);

	String delete(Long stringToLong);

	Map<String, Object> loginCheck(SysUser user);

}
