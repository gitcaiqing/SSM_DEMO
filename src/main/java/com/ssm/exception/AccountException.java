package com.ssm.exception;

import org.apache.shiro.authc.AuthenticationException;

public class AccountException extends AuthenticationException{

	private static final long serialVersionUID = 6423461337343398987L;
	
	public AccountException(String msg) {
		super(msg);
	}

}
