package com.ssm.security;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.entity.BasicUser;
import com.ssm.exception.AccountException;
import com.ssm.mapper.BasicUserMapper;
import com.ssm.util.WebUtils;

public class ShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private BasicUserMapper basicUserMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 授权认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = String.valueOf(usernamePasswordToken.getPassword());
		BasicUser basicUser = basicUserMapper.selectByUsername(username);
		if(basicUser == null) {
			throw new AccountException("账号或密码错误");
		}
		if(!password.equals(basicUser.getPassword())){
			throw new AccountException("账号或密码错误");
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				basicUser.getUsername(), basicUser.getPassword(), basicUser.getRealname());
		HttpSession session = WebUtils.getSession();
		session.setAttribute("currentUser", basicUser);
		return simpleAuthenticationInfo;
	}

}
