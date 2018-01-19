package com.oa.demo.qsy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysUserSub;
import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.pojo.SysUserExample;
import com.oa.demo.qsy.pojo.SysUserExample.Criteria;
import com.oa.demo.qsy.pojo.mapper.SysUserMapper;
import com.oa.demo.qsy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public Map<String, Object> userList(CommonParam param) {
		Map<String, Object> result = new HashMap<>();
		List<SysUser> list = sysUserMapper.selectByCondition(param);
		Long count = userCount(param);
		Long page = count % param.getPageSize() == 0 ? count / param.getPageSize() : count / param.getPageSize() + 1;
		if (count == 0) {
			page=(long) 1;
		}
		result.put("list", list);
		result.put("count", count);
		result.put("page", page);
		return result;
	}

	protected Long userCount(CommonParam param) {
		return sysUserMapper.countByCondition(param);
	}

	@Override
	public String addUser(SysUser sysUser) {
		int i = sysUserMapper.insert(sysUser);
		if(i>0) {
			return Constant.SUCCESS;
		}
		return Constant.FAILED;
	}

	@Override
	public String updateUser(SysUser sysUser) {
		int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
		if(i>0) {
			return Constant.SUCCESS;
		}
		return Constant.FAILED;
	}

	@Override
	public SysUserSub queryUser(Long userId) {
		return sysUserMapper.selectSysUserSubInfoById(userId);
	}

	@Override
	public String delete(Long userId) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		sysUser.setState("00");
		int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
		if(i>0) {
			return Constant.SUCCESS;
		}
		return Constant.FAILED;
	}

	@Override
	public Map<String, Object> loginCheck(SysUser user) {
		SysUserExample example = new SysUserExample();
		Map<String, Object> result = new HashMap<>();
		example.createCriteria().andUserNameEqualTo(user.getUserName());
		List<SysUser> list = sysUserMapper.selectByExample(example );
		if(list==null||list.size()==0) {
			result.put("data", "该账户不存在！");
		}else if(list!=null&&list.size()>0) {
			if(!"01".equals(list.get(0).getState())) {
				result.put("data", "该账户状态不正常！");
			}else if(!list.get(0).getUserPassword().equals(user.getUserPassword())) {
				result.put("data", "该账户密码不正确！");
			}else {
				result.put("user", list.get(0));
				result.put("data", "登录成功！");
			}
		}
		return result;
		
	}
}
