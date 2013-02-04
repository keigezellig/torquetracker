package com.joco.common;

public class CarData 
{
	private DeviceInfo deviceInfo;
	private long timeStamp;
	private double speed;
	private double rpm;
	private double coolantTemperature;
	private double torque;
	private double fuelConsumption;
	private double engineLoad;
	private double CO2Production;
	private double batteryVoltage;
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getRpm() {
		return rpm;
	}
	public void setRpm(double rpm) {
		this.rpm = rpm;
	}
	public double getCoolantTemperature() {
		return coolantTemperature;
	}
	public void setCoolantTemperature(double coolantTemperature) {
		this.coolantTemperature = coolantTemperature;
	}
	public double getTorque() {
		return torque;
	}
	public void setTorque(double torque) {
		this.torque = torque;
	}
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public double getEngineLoad() {
		return engineLoad;
	}
	public void setEngineLoad(double engineLoad) {
		this.engineLoad = engineLoad;
	}
	public double getCO2Production() {
		return CO2Production;
	}
	public void setCO2Production(double cO2Production) {
		CO2Production = cO2Production;
	}
	public double getBatteryVoltage() {
		return batteryVoltage;
	}
	public void setBatteryVoltage(double batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public CarData(long timeStamp, double speed, double rpm,
			double coolantTemperature, double torque, double fuelConsumption,
			double engineLoad, double cO2Production, double batteryVoltage) {
		super();
		this.timeStamp = timeStamp;
		this.speed = speed;
		this.rpm = rpm;
		this.coolantTemperature = coolantTemperature;
		this.torque = torque;
		this.fuelConsumption = fuelConsumption;
		this.engineLoad = engineLoad;
		this.CO2Production = cO2Production;
		this.batteryVoltage = batteryVoltage;
	}
	
	public CarData()
	{
		
	}
	@Override
	public String toString() {
		return String
				.format("CarData [timeStamp=%s, speed=%s, rpm=%s, coolantTemperature=%s, torque=%s, fuelConsumption=%s, engineLoad=%s, CO2Production=%s, batteryVoltage=%s]",
						timeStamp, speed, rpm, coolantTemperature, torque,
						fuelConsumption, engineLoad, CO2Production,
						batteryVoltage);
	}
	
	
	
	

}
