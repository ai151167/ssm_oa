package com.oa.demo.qsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class CommonController {

	@RequestMapping("/frame")
	public String frame() {
		return "common/frame";

	}
}
