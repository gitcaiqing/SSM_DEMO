package com.ssm.service;

import com.ssm.entity.BasicUser;

/**
 * 用户Service
 * @author https://blog.csdn.net/caiqing116
 *
 */
public interface BasicUserService {
	
	Integer insert(BasicUser basicUser);
	
	Integer deleteById(Integer id);
	
	BasicUser selectById(Integer id);
	
	Integer updateById(BasicUser basicUser);
	
	BasicUser selectByUsername(String username);

}
