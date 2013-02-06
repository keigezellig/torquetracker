package com.joco.common;

public class DeviceInfo 
{
	public long sessionId;
	public String torqueId;
	
	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	public String getTorqueId() {
		return torqueId;
	}
	public void setTorqueId(String torqueId) {
		this.torqueId = torqueId;
	}
	public DeviceInfo(long sessionId, String torqueId) {
		super();
		this.sessionId = sessionId;
		this.torqueId = torqueId;
	}
	
	public DeviceInfo()
	{
		
	}
	
	
	
}
