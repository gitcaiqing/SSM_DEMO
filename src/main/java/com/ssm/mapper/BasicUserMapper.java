package com.ssm.mapper;

import com.ssm.entity.BasicUser;

/**
 * @author https://blog.csdn.net/caiqing116 2018-11-28
 */
public interface BasicUserMapper{
   
	int deleteByPrimaryKey(Integer id);

    int insert(BasicUser record);

    int insertSelective(BasicUser record);

    BasicUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicUser record);

    int updateByPrimaryKey(BasicUser record);

    /**
    * 根据用户名查询
    */
	BasicUser selectByUsername(String username);
}