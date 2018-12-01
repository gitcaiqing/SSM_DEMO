package com.ssm.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.exception.AccountException;
import com.ssm.util.EncryptKit;
import com.ssm.util.ResultModel;

@Controller
@RequestMapping("ssm")
public class LoginHandler {

	@RequestMapping("/shirologin")
	@ResponseBody
	public ResultModel shirologin(String username, String password, boolean rememberMe) {
		
		try {
			Subject currentUser = SecurityUtils.getSubject();
			//未认证登录
			if(!currentUser.isAuthenticated()) {
				//密码进行MD5加密
				UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, EncryptKit.MD5(password));
				//是否记住我
				usernamePasswordToken.setRememberMe(rememberMe);
				//认证登陆
				currentUser.login(usernamePasswordToken);
			}
		} catch (AuthenticationException e) {
			if(e instanceof AccountException) {
				return new ResultModel(1, "账号或密码错误");
			}
		}
		return new ResultModel(0, "登陆成功");
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/shirologout")
	public String shirologout() {
		try {
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()) {
				subject.logout();
				//登出成功
				return "redirect:/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ssm/index";
	}
}
