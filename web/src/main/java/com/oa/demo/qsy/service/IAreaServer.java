package com.oa.demo.qsy.service;

import java.util.List;

import com.oa.demo.qsy.pojo.BaseArea;

public interface IAreaServer {

	List<BaseArea> getBaseArea(String areaParentId);

}
