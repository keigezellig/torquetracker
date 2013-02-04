package com.joco.common;

public class GPSData 
{
	private DeviceInfo deviceInfo;
	private long timeStamp;
	private double latitude;
	private double longitude;
	private double heading;
	private double altitude;
	private double speed;
	private double accuracy;
	
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getHeading() {
		return heading;
	}
	public void setHeading(double heading) {
		this.heading = heading;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public GPSData(long timeStamp, double latitude, double longitude, double heading,
			double altitude, double speed, double accuracy) {
		super();
		this.timeStamp = timeStamp;
		this.latitude = latitude;
		this.longitude = longitude;
		this.heading = heading;
		this.altitude = altitude;
		this.speed = speed;
		this.accuracy = accuracy;
	}
	
	
	@Override
	public String toString() {
		return String
				.format("GPSData [latitude=%s, longitude=%s, heading=%s, altitude=%s, speed=%s]",
						latitude, longitude, heading, altitude, speed);
	}
	public GPSData()
	{
	}
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	
	
	
	
}
