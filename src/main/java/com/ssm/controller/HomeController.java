package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("ssm")
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "/home";
	}
}
