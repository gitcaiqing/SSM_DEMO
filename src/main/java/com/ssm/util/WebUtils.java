package com.ssm.util;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.support.RequestContext;

import com.ssm.entity.BasicUser;

/**
 * 系统工具类
 * @author
 *
 */
public class WebUtils {
	
	/**
	 * 获取getHttpServletRequest请求对象
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 获取HttpServletResponse响应对象
	 * @return
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	/**
	 * 获取HttpSession对象
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);  
		return httpSession;  
	}
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public static BasicUser getCurrentUser() {

		HttpSession session = getSession();
		Object object = session.getAttribute("currentUser");
		if(object == null) {
			return null;
		}
		BasicUser basicUser = (BasicUser) getSession().getAttribute("currentUser");
		return basicUser;
	}

	
}
