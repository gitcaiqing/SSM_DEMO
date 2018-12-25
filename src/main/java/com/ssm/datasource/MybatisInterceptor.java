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
@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,   RowBounds.class, ResultHandler.class }) })  
public class MybatisInterceptor implements Interceptor{  
	
	private static final Logger log = LoggerFactory.getLogger(MybatisInterceptor.class);
      
    @SuppressWarnings("unused")  
    private Properties properties;  
     
    /**
     * @Methodname: intercept
     * @Description: sql拦截器方法
     * @overridden: @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
     * @param: @param arg0
     * @param: @return
     * @param: @throws Throwable   
     * @throws:
     * @CreateDate:  2017-10-10 下午4:59:37 by CQ
     * @LastModified: 2017-10-10 下午4:59:37 by CQ
     * @version: 1.0
     */
    public Object intercept(Invocation arg0) throws Throwable {  
        MappedStatement mappedStatement = (MappedStatement) arg0.getArgs()[0];  
        Object parameter = null;  
        if (arg0.getArgs().length > 1) {  
            parameter = arg0.getArgs()[1];  
        }  
        //mapper对应的方法 如：com.jht.common.mapper.CodePoolMapper.listData
        String sqlId = mappedStatement.getId();  
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);  
        Configuration configuration = mappedStatement.getConfiguration();  
          
        Object returnValue = null;  
        long start = System.currentTimeMillis();  
        returnValue = arg0.proceed();  
        long end = System.currentTimeMillis();  
        //sql执行耗时
        long time = (end - start);  
        String sql = showSql(configuration, boundSql);
        if(time > 1) {
        	log.info("SQL=====>>>:"+sql);
        }
       
        /*JdbcTemplate jdbcTemplate = SpringContextHolder.getBean("masterJdbcTemplate");
        jdbcTemplate.update( "insert into tb_basic_sqlmonitor(sysname,sqlid,credate, pack, sqldetail, timeconsu) values(?,?,?,?,?,?)" ,
        		null,UniqueIdUtils.getUUID(),new Date(start),sqlId,sql,Integer.valueOf(time+""));*/
        return returnValue;  
    }  
      
    //执行sql获取
    public static String showSql(Configuration configuration, BoundSql boundSql) {  
        Object parameterObject = boundSql.getParameterObject();  
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();  
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");  
        if (parameterMappings.size() > 0 && parameterObject != null) {  
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
        }  
        return sql;  
    }  
      
    private static String getParameterValue(Object obj) {  
        String value = null;  
        if (obj instanceof String) {  
            value = "'" + obj.toString() + "'";  
        } else if (obj instanceof Date) {  
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);  
            value = "'" + formatter.format(new Date()) + "'";  
        } else {  
            if (obj != null) {  
                value = obj.toString();  
            } else {  
                value = "";  
            }  
   
        }  
        return value;  
    }  
  
    public Object plugin(Object arg0) {  
        return Plugin.wrap(arg0, this);  
    }  
  
    public void setProperties(Properties arg0) {  
        this.properties = arg0;  
    }  
  
}