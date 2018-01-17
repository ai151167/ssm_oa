package com.oa.demo.qsy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.demo.qsy.pojo.BaseArea;
import com.oa.demo.qsy.pojo.mapper.BaseAreaMapper;
import com.oa.demo.qsy.service.IAreaServer;

@Service
public class AreaServerImpl implements IAreaServer {

	@Autowired
	private BaseAreaMapper baseAreaMapper;
	
	@Override
	public List<BaseArea> getBaseArea(String areaParentId) {
		return baseAreaMapper.selectBaseAreaByCondition(areaParentId);
	}

}
