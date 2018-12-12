package com.ssm.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import com.ssm.util.MemcacheUtil;

public class CustomShiroSessionDao extends EnterpriseCacheSessionDAO{
	
	private static final String SESSION_KEY = "session_key";

	/**
	 * 创建session
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
		//从Memcache获取session
		Map<String, Session> sessions = (Map<String, Session>) MemcacheUtil.get(SESSION_KEY);
		if(sessions == null) {
			sessions = new HashMap<String, Session>();
		}
		sessions.put(sessionId.toString(), session);
		MemcacheUtil.set(SESSION_KEY, 0, sessions);
        return sessionId;
	}

	/**
	 * 读取session
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Session doReadSession(Serializable sessionId) {
		Map<String, Session> sessions = (Map<String, Session>)MemcacheUtil.get(SESSION_KEY);
    	Session session = sessions.get(sessionId.toString());
        return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doUpdate(Session session) {
		Map<String, Session> sessions = (Map<String, Session>) MemcacheUtil.get(SESSION_KEY);
		if(sessions == null) {
			sessions = new HashMap<String, Session>();
		}
		sessions.put(session.getId().toString(), session);
		MemcacheUtil.set(SESSION_KEY, 0, sessions);
	}

	/**
	 * 移除session
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doDelete(Session session) {
		Map<String, Session> sessions = (Map<String, Session>) MemcacheUtil.get(SESSION_KEY);
		if(sessions == null) {
			sessions = new HashMap<>();
		}
		sessions.remove(session.getId().toString());
		MemcacheUtil.set(SESSION_KEY, 0, sessions);
		super.doDelete(session);
	}

}
