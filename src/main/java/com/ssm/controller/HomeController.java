package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.entity.BasicUser;
import com.ssm.util.WebUtils;

/**
 * 主页控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("ssm")
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		BasicUser basicUser = WebUtils.getCurrentUser();
		model.addAttribute("basicUser", basicUser);
		return "/index";
	}

}
