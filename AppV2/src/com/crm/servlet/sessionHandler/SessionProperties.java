package com.crm.servlet.sessionHandler;

public class SessionProperties {
	private String SESSION_PROPERTIES_ID = "";
	private long SESSION_PROPERTIES_START_TIME = 0;
	private long SESSION_LAST_ACCESS_TIME = 0;
	private Boolean SESSION_IS_NEW = false;
	
	public SessionProperties(String id, long startTime, long lastAccessTime, Boolean isNew) {
		this.SESSION_PROPERTIES_ID = id;
		this.SESSION_PROPERTIES_START_TIME = startTime;
		this.SESSION_LAST_ACCESS_TIME = lastAccessTime;
		this.SESSION_IS_NEW = isNew;
	}

	public String getSESSION_PROPERTIES_ID() {
		return SESSION_PROPERTIES_ID;
	}

	public void setSESSION_PROPERTIES_ID(String sESSION_PROPERTIES_ID) {
		SESSION_PROPERTIES_ID = sESSION_PROPERTIES_ID;
	}

	public long getSESSION_PROPERTIES_START_TIME() {
		return SESSION_PROPERTIES_START_TIME;
	}

	public void setSESSION_PROPERTIES_START_TIME(long sESSION_PROPERTIES_START_TIME) {
		SESSION_PROPERTIES_START_TIME = sESSION_PROPERTIES_START_TIME;
	}

	public long getSESSION_LAST_ACCESS_TIME() {
		return SESSION_LAST_ACCESS_TIME;
	}

	public void setSESSION_LAST_ACCESS_TIME(long sESSION_LAST_ACCESS_TIME) {
		SESSION_LAST_ACCESS_TIME = sESSION_LAST_ACCESS_TIME;
	}

	public Boolean get_SESSION_IS_NEW() {
		return SESSION_IS_NEW;
	}

	public void set_SESSION_IS_NEW(Boolean _SESSION_IS_NEW) {
		this.SESSION_IS_NEW = _SESSION_IS_NEW;
	}
}
