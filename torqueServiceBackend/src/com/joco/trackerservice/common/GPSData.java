package com.joco.trackerservice.common;

public class GPSData 
{
	private DeviceInfo deviceInfo;
	private Long timeStamp;
	private Double latitude;
	private Double Longitude;
	private Double heading;
	private Double altitude;
	private Double speed;
	private Double accuracy;
	
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double Longitude) {
		this.Longitude = Longitude;
	}
	public Double getHeading() {
		return heading;
	}
	public void setHeading(Double heading) {
		this.heading = heading;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
	public Double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
	public GPSData(Long timeStamp, Double latitude, Double Longitude, Double heading,
			Double altitude, Double speed, Double accuracy) {
		super();
		this.timeStamp = timeStamp;
		this.latitude = latitude;
		this.Longitude = Longitude;
		this.heading = heading;
		this.altitude = altitude;
		this.speed = speed;
		this.accuracy = accuracy;
	}
	
	
	@Override
	public String toString() {
		return String
				.format("GPSData [latitude=%s, Longitude=%s, heading=%s, altitude=%s, speed=%s]",
						latitude, Longitude, heading, altitude, speed);
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
