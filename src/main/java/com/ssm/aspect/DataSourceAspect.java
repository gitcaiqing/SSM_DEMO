package com.ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ssm.datasource.DataSourceContextHolder;

/**
 * 定义一个数据源切换的切面
 * @aspect 注释对于在类路径中自动检测是不够的：为了达到这个目的，您需要添加一个单独的@component注解
 * @author https://blog.csdn.net/caiqing116 
 */
@Aspect
@Component
public class DataSourceAspect {

	private static final Logger log = LoggerFactory.getLogger(DataSourceAspect.class);
	
	/**
	 * 定义切面
	 * 跟数据源相关的操作都是在service包下
	 */
	@Pointcut("execution(* com.ssm.service.*.*(..))")
	public void servicePoint(){}
	
	/**
	 * 根据切入点进行数据源的切换
	 */
	@Before("servicePoint()")
	public void before(JoinPoint joinpoint){
		String className = joinpoint.getTarget().getClass().getName();
		String methodName = joinpoint.getSignature().getName();
		//判断如果方法名开头符合从库，则切换到从库（端口号3308的服务）
		if(DataSourceContextHolder.isSlave(methodName)) {
			log.info("执行类："+className+" 方法："+methodName+"，切换到从库");
			DataSourceContextHolder.mark3308();
		}else {
			log.info("执行类："+className+" 方法："+methodName+"，切换到主库");
			DataSourceContextHolder.mark3306();
		}
	}
}
