package com.ssm.datasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 定义动态数据源，集成spring提供的AbstractRoutingDataSource，实现determineCurrentLookupKey
 * @author https://blog.csdn.net/caiqing116
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	
	private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);
	
	/*
	 * 定义一个方法前缀methodPrefix属性，通过配置文件赋值，该map存储数据源和方法前缀的值形如形如
	 * {"slave",["list","count","find","get","select","query","等不一一列举"]}
	 * 这里的方法前缀根据开发人员的习惯可自行配置
	*/
	public static Map<String,List<String>> methodPrefix = new HashMap<String, List<String>>();
	
	//设置切换到从库的方法前缀
	@SuppressWarnings("static-access")
	public void setMethodPrefix(Map<String, List<String>> methodPrefix) {
		this.methodPrefix = methodPrefix;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		Object dataType = DataSourceContextHolder.getDataType();
		log.info("当前数据源：{}",dataType);
		return dataType;
	}
	
}
