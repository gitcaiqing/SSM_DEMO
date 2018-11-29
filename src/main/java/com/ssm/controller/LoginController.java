package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.entity.BasicUser;
import com.ssm.service.BasicUserService;

@Controller
public class LoginController {
	
	@Autowired
	private BasicUserService basicUserService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BasicUser basicUser = (BasicUser) session.getAttribute("basicUser");
		if(basicUser == null) {
			return "redirect:/login.jsp";
		}
		return "/home";
	}

	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("login")
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		BasicUser basicUser = basicUserService.selectByUsername(username);
		if(basicUser == null) {
			return "redirect:/login.jsp";
		}
		System.out.println("basicUser:"+basicUser);
		
		HttpSession session = request.getSession();
		session.setAttribute("basicUser", basicUser);
		return "/home";
	}
	
}
