package com.ssm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.entity.BasicUser;
import com.ssm.util.EncryptKit;
import com.ssm.util.UuidUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml","classpath:servlet/*.xml" })
public class BasicUserServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(BasicUserServiceTest.class);
	
	@Autowired
	private BasicUserService basicUserService;

	@Test
	public void testInsert() {
		BasicUser basicUser = new BasicUser();
		basicUser.setUtype(1);
		basicUser.setUserid(UuidUtil.getUuid());
		basicUser.setUsername("叹稀奇");
		basicUser.setRealname("叹稀奇");
		basicUser.setPassword(EncryptKit.MD5("123456"));
		basicUser.setAge(18);
		//手动切换数据源测试代码
		//切换到3308插入数据
		/*DataSourceContextHolder.clear();
		DataSourceContextHolder.mark3306();
		int result = basicUserService.insert(basicUser);
		DataSourceContextHolder.clear();*/
		//自动切换数据源测试
		int result = basicUserService.insert(basicUser);
		log.info("basicUser:"+basicUser);
		log.info("插入行数："+result);
	}

	@Test
	public void testDeleteById() {
		int result = basicUserService.deleteById(1);
		log.info("删除行数："+result);
	}

	@Test
	public void testSelectById() {
		BasicUser basicUser = basicUserService.selectById(1);
		log.info("basicUser:"+basicUser);
	}

	@Test
	public void testUpdateById() {
		BasicUser basicUser = new BasicUser();
		basicUser.setId(1);
		basicUser.setAge(19);
		int result = basicUserService.updateById(basicUser);
		log.info("更新行数："+result);
	}

	@Test
	public void testSelectByUsername() {
		String username = "墨倾池";
		BasicUser basicUser = basicUserService.selectByUsername(username);
		log.info("basicUser："+basicUser);
	}

}
