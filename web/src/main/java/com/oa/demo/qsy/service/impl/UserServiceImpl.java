package com.oa.demo.qsy.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.CommonUtils;
import com.oa.demo.qsy.Constant;
import com.oa.demo.qsy.MapAndObject;
import com.oa.demo.qsy.common.pojo.org.CommonCount;
import com.oa.demo.qsy.common.pojo.org.CommonParam;
import com.oa.demo.qsy.common.pojo.org.SysUserSub;
import com.oa.demo.qsy.pojo.SysRoleUserRel;
import com.oa.demo.qsy.pojo.SysRoleUserRelExample;
import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.pojo.SysUserExample;
import com.oa.demo.qsy.pojo.mapper.SysRoleUserRelMapper;
import com.oa.demo.qsy.pojo.mapper.SysUserMapper;
import com.oa.demo.qsy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysRoleUserRelMapper sysRoleUserRelMapper;
	
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

	@Override
	public Map<String, Object> delRoleUserRel(CommonParam param) {
		Map<String, Object> result = new HashMap<>();
		result.put("isOk", false);
		SysRoleUserRelExample example = new SysRoleUserRelExample();
		example.createCriteria().andRoleIdEqualTo(param.getRoleId()).andUserIdEqualTo(param.getUserId());
		int i = sysRoleUserRelMapper.deleteByExample(example);
		if(i>0) {
			result.put("isOk", true);
		}
		return result;
	}

	@Override
	public List<SysUser> getUserByOrgId(Long orgId) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andOrgIdEqualTo(orgId).andStateEqualTo("01");
		return sysUserMapper.selectByExample(example );
	}

	@Override
	public boolean addRoleUserRel(SysRoleUserRel param) {
		boolean isOK = false;
		param.setCreatedDate(new Date());
		int i = sysRoleUserRelMapper.insert(param);
		if(i>0) {
			isOK = true;
		}
		return isOK;
	}

	@Override
	public Map<String, Object> getUserStatistics() {
		Map<String, Object> result = new HashMap<>();
		result.put("isSuccess", false);
		List<CommonCount> list = sysUserMapper.getUserStatistics();
		if(list!=null && list.size()>0) {
			result.put("list", list);
			result.put("isSuccess", true);
		}
		
		return result;
	}

	@Override
	public Map<String, Object> getUserSexStatistics() {
		Map<String, Object> result = new HashMap<>();
		result.put("isSuccess", false);
		List<Map<String, Object>> list = sysUserMapper.getUserSexStatistics();
		if(list!=null && list.size()>0) {
			result.put("list", list);
			result.put("isSuccess", true);
		}
		
		return result;
	}

	@Override
	public void insertSheetData(List<Map<String, Object>> list) throws Exception {
		sysUserMapper.insertSheetData(list);
	}

	@Override
	public List<Map<String, Object>> queryColumnList() {
		return sysUserMapper.queryColumnList();
	}
}
