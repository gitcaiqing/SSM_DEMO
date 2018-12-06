package com.ssm.quartz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密码过期任务调度
 * @author https://blog.csdn.net/caiqing116
 */
public class PasswordExpiredQuartz {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordExpiredQuartz.class);

	public void doTask() {
		log.info("密码过期提醒任务调度开始执行");
		//查询用户表数据更新时间大于一定天数的 TODO
		//给用户发送短信或邮件 TODO
		log.info("密码过期提醒任务调度执行结束");
	}
}
