package com.ssm.datasource;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 切换数据源，清除数据源信息等
 * @author https://blog.csdn.net/caiqing116
 */
public class DataSourceContextHolder {
	
	
	//定义数据源标识和配置文件dataAccessContext.xml配置的bean id一致
	public static final String DATASOURCE = "dataSource3306";
	public static final String DATASOURCE3308 = "dataSource3308";
	//定义从库标识，和配置
	public static final String SLAVE = "slave";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	/**
	 * 设置当前数据源
	 * @param dataType 数据元类型 DATASOURCE | DATASOURCE3308
	 */
	public static void setDatatype(String dataType) {
		contextHolder.set(dataType);
	}
	
	/**
	 * 获取当前数据源
	 * @return
	 */
	public static String getDataType(){
		return contextHolder.get();
	}
	
	/**
	 * 清除
	 */
	public static void clear() {
		contextHolder.remove();
	}
	
	/**
	 * 切到3306端口数据源
	 */
	public static void mark3306() {
		setDatatype(DATASOURCE);
	}
	
	/**
	 * 切到3308端口数据源
	 */
	public static void mark3308() {
		setDatatype(DATASOURCE3308);
	}

	/**
	 * 判断是否进入从库
	 * @return
	 */
	public static boolean isSlave(String methodName) {
		//DynamicDataSource dynamicDataSource = new DynamicDataSource();
		//未配置切换到从库的方法名前缀，返回false,默认切换到主库
		Map<String, List<String>> methodPrefix = DynamicDataSource.methodPrefix;
		if(methodPrefix == null) {
			return false;
		}
		List<String> methodPrefixs = methodPrefix.get(SLAVE);
		if(methodPrefixs.isEmpty()) {
			return false;
		}
		//方法名前缀和配置的相同则切换到从库
		if(StringUtils.startsWithAny(methodName, methodPrefixs.toArray(new CharSequence[methodPrefixs.size()]))) {
			return true;
		}
		return false;
	}
	
}
