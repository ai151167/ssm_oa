package com.oa.demo.qsy.service;

import java.util.List;

import com.oa.demo.qsy.common.pojo.org.SysLeaveBillSub;
import com.oa.demo.qsy.pojo.SysLeavebill;

public interface ILeaveBillService {

	void saveLeaveBill(SysLeavebill leavebill);

	List<SysLeaveBillSub> getleaveBillList();

	SysLeavebill queryInfo(Long id);

	void deleteById(Long id);

}
