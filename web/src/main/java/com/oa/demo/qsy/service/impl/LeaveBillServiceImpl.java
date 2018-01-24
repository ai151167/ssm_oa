package com.oa.demo.qsy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.common.pojo.org.SysLeaveBillSub;
import com.oa.demo.qsy.pojo.SysLeavebill;
import com.oa.demo.qsy.pojo.SysLeavebillExample;
import com.oa.demo.qsy.pojo.SysUser;
import com.oa.demo.qsy.pojo.mapper.SysLeavebillMapper;
import com.oa.demo.qsy.pojo.mapper.SysUserMapper;
import com.oa.demo.qsy.service.ILeaveBillService;

@Service
public class LeaveBillServiceImpl implements ILeaveBillService {

	@Autowired
	private SysLeavebillMapper sysLeavebillMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public void saveLeaveBill(SysLeavebill leavebill) {
		if(leavebill!=null&&leavebill.getId()!=null&&!"".equals(leavebill.getId().toString())&&leavebill.getId()>0) {
			leavebill.setState(0);
			updateLeaveBill(leavebill);
		}else {
			leavebill.setState(0);
			leavebill.setLeavedate(new Date());
			addLeaveBill(leavebill);
		}
	}

	protected void updateLeaveBill(SysLeavebill leavebill) {
		sysLeavebillMapper.updateByPrimaryKeySelective(leavebill);
	}

	protected void addLeaveBill(SysLeavebill leavebill) {
		sysLeavebillMapper.insert(leavebill);
	}

	@Override
	public List<SysLeaveBillSub> getleaveBillList() {
		List<SysLeaveBillSub>  result =  new ArrayList<>();
		SysLeavebillExample example = new SysLeavebillExample();
		 List<SysLeavebill> list = sysLeavebillMapper.selectByExample(example );
		 if(list!=null&&list.size()>0) {
			 for (SysLeavebill sysLeavebill : list) {
				 SysLeaveBillSub sub = new SysLeaveBillSub();
				 sub.setId(sysLeavebill.getId());
				 sub.setContent(sysLeavebill.getContent());
				 sub.setDays(sysLeavebill.getDays());
				 sub.setLeavedate(sysLeavebill.getLeavedate());
				 sub.setState(sysLeavebill.getState());
				 sub.setRemark(sysLeavebill.getRemark());
				 if(sysLeavebill.getUserId()!=null&&sysLeavebill.getUserId()>0&&!"".equals(sysLeavebill.getUserId().toString())) {
					 SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysLeavebill.getUserId());
					 sub.setUserId(sysLeavebill.getUserId());
					 sub.setUserChName(sysUser.getUserChName());
				 }
				 result.add(sub);
			}
		 }
		return result;
		 
	}

	@Override
	public SysLeavebill queryInfo(Long id) {
		return sysLeavebillMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Long id) {
		sysLeavebillMapper.deleteByPrimaryKey(id);
	}

}
