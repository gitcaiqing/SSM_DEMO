package com.ssm.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.entity.BasicUser;
import com.ssm.entity.Page;
import com.ssm.mapper.BasicUserMapper;
import com.ssm.service.BasicUserService;

/**
 * 用户Service实现类
 * @author https://blog.csdn.net/caiqing116
 *
 */
@Service
public class BasicUserServiceImpl implements BasicUserService{

	@Autowired
	private BasicUserMapper basicUserMapper;
	
	/**
	 * 插入用户
	 */
	public Integer insert(BasicUser basicUser) {
		return basicUserMapper.insertSelective(basicUser);
	}

	/**
	 * 根据id删除
	 */
	public Integer deleteById(Integer id) {
		return basicUserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据id查询
	 */
	public BasicUser selectById(Integer id) {
		return basicUserMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据id更新
	 */
	public Integer updateById(BasicUser basicUser) {
		return basicUserMapper.updateByPrimaryKeySelective(basicUser);
	}

	/**
	 * 根据用户名查询
	 */
	public BasicUser selectByUsername(String username) {
		return basicUserMapper.selectByUsername(username);
	}

	@Override
	public Page<List<BasicUser>> listBasicUser(BasicUser basicUser, Page<BasicUser> page) {
		int total = basicUserMapper.countData(basicUser);
		if(total == 0) {
			return new Page<List<BasicUser>>(page.getPage(), total, new ArrayList<BasicUser>());
		}
		List<BasicUser> basicUsers = basicUserMapper.listData(basicUser, page);
		return new Page<List<BasicUser>>(page.getPage(), total, basicUsers);
	}

}
