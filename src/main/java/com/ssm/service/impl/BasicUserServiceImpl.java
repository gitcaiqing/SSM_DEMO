package com.ssm.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
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
	
	private static final Logger log = LoggerFactory.getLogger(BasicUserServiceImpl.class);

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
		log.info("进入方法deleteById.....");
		//return basicUserMapper.deleteByPrimaryKey(id);
		basicUserMapper.selectByPrimaryKey(id);
		return 0;
	}

	/**
	 * 根据id查询
	 */
	public BasicUser selectById(Integer id) {
		//该方法内部含有一些其他业务处理，如插入删除更新操作等等需要，需要切换到主节点
		//在这里进行了Service层内部方法调用
		//一般理解，这里会切换到从库，实际是不会的
		log.info("执行删除操作开始");
		//this.deleteById(3);
		
		//既然只有调用代理类的方法才能切入，那我们拿到代理类
		BasicUserService proxy = ((BasicUserService)AopContext.currentProxy());
		proxy.deleteById(3);
		log.info("执行删除操作结束");
		
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
