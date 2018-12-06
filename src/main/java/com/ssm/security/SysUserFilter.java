package com.ssm.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.stereotype.Service;

@Service
public class SysUserFilter extends UserFilter{ 

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		boolean isAccess = super.isAccessAllowed(request, response, mappedValue);
		return isAccess;
	}
	
}
