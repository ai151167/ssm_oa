package com.oa.demo.qsy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.demo.qsy.pojo.BaseArea;
import com.oa.demo.qsy.service.IAreaServer;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private IAreaServer areaServerImpl;
	
	@ResponseBody
	@RequestMapping("/getBaseArea")
	public List<BaseArea> getBaseArea(HttpServletRequest request){
		String areaParentId = request.getParameter("areaParentId");
		return areaServerImpl.getBaseArea(areaParentId);
	}
}
