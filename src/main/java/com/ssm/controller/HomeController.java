package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ssm")
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}
}
