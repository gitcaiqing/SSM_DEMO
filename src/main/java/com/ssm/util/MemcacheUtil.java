package com.ssm.util;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

/**
 * Memcache工具类
 * @author https://blog.csdn.net/caiqing116
 */
public class MemcacheUtil {
	
	private static final String M_USERNAME = "";
	private static final String M_PASSWORD = "";
	private static final String M_HOST = "127.0.0.1";
	private static final String M_PORT = "11211";

	/**
	 * 获取连接
	 * @return
	 */
	private static MemcachedClient getMemcachedClient() {
		MemcachedClient memcachedClient = null;
		try {
			//无账户密码连接
			memcachedClient = new MemcachedClient(
					new ConnectionFactoryBuilder().setProtocol(Protocol.BINARY).build(), 
					AddrUtil.getAddresses(M_HOST+":"+M_PORT));
			//有账户密码连接
			/*AuthDescriptor ad = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler(M_USERNAME, M_PASSWORD));
			memcachedClient = new MemcachedClient(
					new ConnectionFactoryBuilder().setProtocol(Protocol.BINARY).setAuthDescriptor(ad).build(), 
					AddrUtil.getAddresses(M_HOST+":"+M_PORT));*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memcachedClient;
	}
	//关闭连接
	private static void shutdownMemcachedClient(MemcachedClient memcachedClient) {
		memcachedClient.shutdown();
	}
	
	/**
	 * 根据key获取存储的值
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object result = null;
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = getMemcachedClient();
			if(memcachedClient != null) {
				result = memcachedClient.get(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdownMemcachedClient(memcachedClient);
		}
		return result;
	}
	
	/**
	 * 根据key获取存储的值转String
	 * @param key
	 * @return
	 */
	public static Object getString(String key) {
		String result = (String)get(key);
		return result;
	}
	
	/**
	 * 如果无此key的情况下，存储该数据，由此key则不操作
	 * @param key 
	 * @param exptime  超时时间。如果值为0表示该数据项永远不超时,单位为 S
	 * @param value
	 * @return
	 */
	public static Boolean add(String key, int exptime, Object value){
		Boolean result = false;
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = getMemcachedClient();
			if (memcachedClient != null) {
				OperationFuture<?> future = memcachedClient.add(key, exptime, value);
				result = (Boolean) future.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdownMemcachedClient(memcachedClient);
		}
		return result;
	}
	
	/**
	 * 直接存储数据，有对应的key则覆盖，没有则添加
	 * @param key 
	 * @param exptime  超时时间。如果值为0表示该数据项永远不超时,单位为 S
	 * @param value
	 * @return
	 */
	public static Boolean set(String key, int exptime, Object value){
		Boolean result = false;
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = getMemcachedClient();
			if (memcachedClient != null) {
				OperationFuture<?> future = memcachedClient.set(key, exptime, value);
				result = (Boolean) future.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdownMemcachedClient(memcachedClient);
		}
		return result;
	}
	
	/**
	 * 拥有key的情况下，替换原有内容
	 * @param key 
	 * @param exptime  超时时间。如果值为0表示该数据项永远不超时,单位为 S
	 * @param value
	 * @return
	 */
	public static Boolean replace(String key, int exptime, String value){
		Boolean result = false;
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = getMemcachedClient();
			if (memcachedClient != null) {
				OperationFuture<?> future = memcachedClient.replace(key, exptime, value);
				result = (Boolean) future.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdownMemcachedClient(memcachedClient);
		}
		return result;
	}
	
	/**
	 * 根据key移除
	 * @param key
	 * @return
	 */
	public static Object remove(String key){
		Object result = null;
		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = getMemcachedClient();
			if (memcachedClient != null) {
				OperationFuture<?> future = memcachedClient.delete(key);
				future.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdownMemcachedClient(memcachedClient);
		}
		return result;
	}
	
	public static void main(String[] args) {
		add("test", 0, "测试新增数据");
		System.out.println(get("test"));
	}
}
