package com.joco.common;

public class PhysicalData 
{
	private DeviceInfo deviceInfo;
	private long timeStamp;
	private double accelerationX;
	private double accelerationY;
	private double accelerationZ;
	private double accelerationTotal;
	private double ambientTemperature;
	private double atmosphericPressure;
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getAccelerationX() {
		return accelerationX;
	}
	public void setAccelerationX(double accelerationX) {
		this.accelerationX = accelerationX;
	}
	public double getAccelerationY() {
		return accelerationY;
	}
	public void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}
	public double getAccelerationZ() {
		return accelerationZ;
	}
	public void setAccelerationZ(double accelerationZ) {
		this.accelerationZ = accelerationZ;
	}
	public double getAccelerationTotal() {
		return accelerationTotal;
	}
	public void setAccelerationTotal(double accelerationTotal) {
		this.accelerationTotal = accelerationTotal;
	}
	public double getAmbientTemperature() {
		return ambientTemperature;
	}
	public void setAmbientTemperature(double ambientTemperature) {
		this.ambientTemperature = ambientTemperature;
	}
	public double getAtmosphericPressure() {
		return atmosphericPressure;
	}
	public void setAtmosphericPressure(double atmosphericPressure) {
		this.atmosphericPressure = atmosphericPressure;
	}
	
	public PhysicalData(long timeStamp, double accelerationX, double accelerationY,
			double accelerationZ, double accelerationTotal,
			double ambientTemperature,
			double atmosphericPressure) {
		super();
		this.timeStamp = timeStamp;
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
		this.accelerationTotal = accelerationTotal;
		this.ambientTemperature = ambientTemperature;
		this.atmosphericPressure = atmosphericPressure;
	}
	
	public PhysicalData()
	{
	
	}
	@Override
	public String toString() {
		return String
				.format("PhysicalData [accelerationX=%s, accelerationY=%s, accelerationZ=%s, accelerationTotal=%s, ambientTemperature=%s]",
						accelerationX, accelerationY, accelerationZ,
						accelerationTotal, ambientTemperature);
	}
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	
	
	
	

}
