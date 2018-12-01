package com.ssm.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.stereotype.Service;

@Service
public class SysUserFilter extends UserFilter{ 

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// TODO Auto-generated method stub
		return super.isAccessAllowed(request, response, mappedValue);
	}

}
