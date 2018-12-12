package com.ssm.datasource;

/**
 * 切换数据源，清除数据源信息等
 * @author https://blog.csdn.net/caiqing116
 */
public class DataSourceContextHolder {
	
	//定义数据源标识和配置文件dataAccessContext.xml配置的bean id一致
	public static final String DATASOURCE = "dataSource3306";
	public static final String DATASOURCE3308 = "dataSource3308";

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
	
}
