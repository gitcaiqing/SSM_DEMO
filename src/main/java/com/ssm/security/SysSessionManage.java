package com.ssm.security;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class SysSessionManage extends DefaultWebSessionManager{

	@Override
	public boolean isServletContainerSessions() {
		return true;
	}

}
