package com.joco.trackerservice.common;

public class DeviceInfo 
{
	public long sessionId;
	public String deviceId;
	
	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public DeviceInfo(long sessionId, String deviceId) {
		super();
		this.sessionId = sessionId;
		this.deviceId = deviceId;
	}
	
	public DeviceInfo()
	{
		
	}
	
	
	
}
