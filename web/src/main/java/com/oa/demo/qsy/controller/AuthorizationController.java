package com.oa.demo.qsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
	
	@RequestMapping("/authorizationMana")
	public String Authorization() {
		return "authorization/authorizationMana";
	}

}
