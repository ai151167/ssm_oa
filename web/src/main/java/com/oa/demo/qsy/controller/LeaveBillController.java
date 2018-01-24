package com.oa.demo.qsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.demo.qsy.common.pojo.org.SysLeaveBillSub;
import com.oa.demo.qsy.pojo.SysLeavebill;
import com.oa.demo.qsy.service.ILeaveBillService;

@Controller
@RequestMapping("/leaveBill")
public class LeaveBillController {

	@Autowired
	private ILeaveBillService leaveBillServiceImpl;
	
	@RequestMapping("/leaveBill_main")
	public String toleaveBill(ModelMap map) {
		List<SysLeaveBillSub> leavebills = leaveBillServiceImpl.getleaveBillList();
		map.put("lbList", leavebills);
		return "views/leaveBill/list";
	}
	
	@RequestMapping("/toAddLeaveBill")
	public String toAddLeaveBill() {
		return "views/leaveBill/input";
	}
	
	@RequestMapping("/saveLeaveBill")
	public String saveLeaveBill(SysLeavebill leavebill) {
		leaveBillServiceImpl.saveLeaveBill(leavebill);
		return "redirect:/leaveBill/leaveBill_main";
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(Long id,ModelMap map) {
		SysLeavebill leavebill =  leaveBillServiceImpl.queryInfo(id);
		map.put("lb", leavebill);
		return "views/leaveBill/input";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id) {
		leaveBillServiceImpl.deleteById(id);
		return "redirect:/leaveBill/leaveBill_main";
	}
}
