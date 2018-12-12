package com.ssm.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 定义动态数据源，集成spring提供的AbstractRoutingDataSource，实现determineCurrentLookupKey
 * @author https://blog.csdn.net/caiqing116
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	
	private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

	@Override
	protected Object determineCurrentLookupKey() {
		Object dataType = DataSourceContextHolder.getDataType();
		log.info("当前数据源：{}",dataType);
		return dataType;
	}

}
