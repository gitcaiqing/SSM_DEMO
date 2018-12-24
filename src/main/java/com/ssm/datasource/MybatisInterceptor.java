package com.ssm.datasource;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({  
	@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),  
    @Signature(type = Executor.class, method = "query",  args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) 
})  
public class MybatisInterceptor implements Interceptor {
	
	private static final Logger log = LoggerFactory.getLogger(MybatisInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];  
        Object parameter = null;  
        if (invocation.getArgs().length > 1) {  
            parameter = invocation.getArgs()[1];  
        }  

        BoundSql boundSql = mappedStatement.getBoundSql(parameter);  
        Configuration configuration = mappedStatement.getConfiguration();  
       
        //获取sql语句
        String sql = getSql(configuration, boundSql);  
        log.info("Mybatis 拦截器获取SQL:{}",sql);
        return sql;
	}

	@Override
	public Object plugin(Object target) {
		 return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}
	
	@SuppressWarnings("null")
	private String getSql(Configuration configuration, BoundSql boundSql) {
		Object parameterObject = boundSql.getParameterObject();  
	    List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
	    String sql = boundSql.getSql().replaceAll("[\\s]+", " ");  
	    if (parameterObject == null || parameterMappings.size() == 0) {
	    	return sql;
	    }  
        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();  
        if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {  
        	sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));  
        } else {  
        	MetaObject metaObject = configuration.newMetaObject(parameterObject);  
            for (ParameterMapping parameterMapping : parameterMappings) {  
            	String propertyName = parameterMapping.getProperty();  
                if (metaObject.hasGetter(propertyName)) {  
                	Object obj = metaObject.getValue(propertyName);  
                    sql = sql.replaceFirst("\\?", getParameterValue(obj));  
                } else if (boundSql.hasAdditionalParameter(propertyName)) {  
                	Object obj = boundSql.getAdditionalParameter(propertyName);  
                	sql = sql.replaceFirst("\\?", getParameterValue(obj));  
                }  
            }  
        }  
	    return sql;
	}

	private String getParameterValue(Object obj) {  
		String value = null;  
		if (obj instanceof String) {  
			value = "'" + obj.toString() + "'";  
	    } else if (obj instanceof Date) {  
	        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);  
	        value = "'" + formatter.format(obj) + "'";  
	    } else {  
	        if (obj != null) {  
	            value = obj.toString();  
	        } else {  
	            value = "";  
	        }  
	    }  
	    return value;  
	}  
}
