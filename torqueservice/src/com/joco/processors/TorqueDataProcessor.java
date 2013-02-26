package com.joco.processors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.joco.common.CarData;
import com.joco.common.DeviceInfo;
import com.joco.common.GPSData;
import com.joco.common.IDataProcessor;
import com.joco.common.PhysicalData;

public class TorqueDataProcessor implements IDataProcessor
{

	private static final Map<TagType,String> TORQUE_TAGMAPPING;
    static
    {
    	TORQUE_TAGMAPPING = new HashMap<TagType,String>();
    	TORQUE_TAGMAPPING.put(TagType.TIMESTAMP,"time");
    	TORQUE_TAGMAPPING.put(TagType.DEVICE_DEVICEID,"id");
    	TORQUE_TAGMAPPING.put(TagType.DEVICE_SESSIONID,"sessionid");
    	TORQUE_TAGMAPPING.put(TagType.GPS_SPEED,"ff1001");
    	TORQUE_TAGMAPPING.put(TagType.GPS_LAT,"ff1006");
    	TORQUE_TAGMAPPING.put(TagType.GPS_LON,"ff1005");
    	TORQUE_TAGMAPPING.put(TagType.GPS_ALT,"ff1010");
    	TORQUE_TAGMAPPING.put(TagType.GPS_HEADING,"ff123b");
    	TORQUE_TAGMAPPING.put(TagType.GPS_ACCURACY,"ff1239");
    	TORQUE_TAGMAPPING.put(TagType.OBD_SPEED,"0d");
    	TORQUE_TAGMAPPING.put(TagType.OBD_RPM,"0c");
    	TORQUE_TAGMAPPING.put(TagType.OBD_COOLANT,"05");
    	TORQUE_TAGMAPPING.put(TagType.OBD_BATVOLTAGE,"2113");
    	TORQUE_TAGMAPPING.put(TagType.OBD_CO2PRODUCTION,"ff1257");
    	TORQUE_TAGMAPPING.put(TagType.OBD_ENGINELOAD,"04");
    	TORQUE_TAGMAPPING.put(TagType.OBD_TORQUE,"ff1225");
    	TORQUE_TAGMAPPING.put(TagType.OBD_FUELCONSUMPTION,"ff1203");
       	TORQUE_TAGMAPPING.put(TagType.PHYS_ACCX,"ff1220");
       	TORQUE_TAGMAPPING.put(TagType.PHYS_ACCY,"ff1221");
       	TORQUE_TAGMAPPING.put(TagType.PHYS_ACCZ,"ff1222");
       	TORQUE_TAGMAPPING.put(TagType.PHYS_ACCTOTAL,"ff1223");
    	TORQUE_TAGMAPPING.put(TagType.PHYS_TEMP,"46");
    	TORQUE_TAGMAPPING.put(TagType.PHYS_PRESSURE,"33");
    	
    	
    	
	}

    public DeviceInfo ProcessDeviceInfo(Map<String, String> values)
    {
    	String deviceId = values.get(TORQUE_TAGMAPPING.get(TagType.DEVICE_DEVICEID));
    	String sessionId = values.get(TORQUE_TAGMAPPING.get(TagType.DEVICE_SESSIONID));
    	
    	return new DeviceInfo(Long.parseLong(sessionId),deviceId);
    	
    }
	@Override
	public GPSData ProcessGPSData(Map<String, String> values)
	{
		GPSData result = new GPSData();
		result.setDeviceInfo(ProcessDeviceInfo(values));
		String time = values.get(TORQUE_TAGMAPPING.get(TagType.TIMESTAMP));
		String lat = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_LAT));
		String lon = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_LON));
		String alt = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_ALT));
		String spd = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_SPEED));
		String accuracy = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_ACCURACY));
		String heading = values.get(TORQUE_TAGMAPPING.get(TagType.GPS_HEADING));
		
		if (time != null)
		{
			result.setTimeStamp(Long.valueOf(time));
		}
		else
		{
			result.setTimeStamp(new Date().getTime());
		}
		
		if (lat != null)
		{
			result.setLatitude(Double.parseDouble(lat));
		}
		if (lon != null)
		{
			result.setLongitude(Double.parseDouble(lon));
		}
		if (alt != null)
		{
			result.setAltitude(Double.parseDouble(alt));
		}
		if (spd != null)
		{
			result.setSpeed(Double.parseDouble(spd));
		}
		if (accuracy != null)
		{
			result.setAccuracy(Double.parseDouble(accuracy));
		}
		if (heading != null)
		{
			result.setHeading(Double.parseDouble(heading));
		}
		
		return result;
	}

	@Override
	public PhysicalData ProcessPhysicalData(Map<String, String> values)
	{
		PhysicalData result = new PhysicalData();

		result.setDeviceInfo(ProcessDeviceInfo(values));
		String time = values.get(TORQUE_TAGMAPPING.get(TagType.TIMESTAMP));
		String accX = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_ACCX));
		String accY = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_ACCY));
		String accZ = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_ACCZ));		
		String accTotal = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_ACCTOTAL));
		String pressure = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_PRESSURE));
		String temp = values.get(TORQUE_TAGMAPPING.get(TagType.PHYS_TEMP));
		
		if (time != null)
		{
			result.setTimeStamp(Long.valueOf(time));
		}
		else
		{
			result.setTimeStamp(new Date().getTime());
		}

		
		if (accX != null)
		{
			result.setAccelerationX(Double.parseDouble(accX));
		}
		if (accY != null)
		{
			result.setAccelerationY(Double.parseDouble(accY));
		}
		if (accZ != null)
		{
			result.setAccelerationZ(Double.parseDouble(accZ));
		}
		if (accTotal != null)
		{
			result.setAccelerationTotal(Double.parseDouble(accTotal));
		}
		if (pressure != null)
		{
			result.setAtmosphericPressure(Double.parseDouble(pressure));
		}
		if (temp != null)
		{
			result.setAmbientTemperature(Double.parseDouble(temp));
		}
		
		
		return result;
	}

	@Override
	public CarData ProcessCarData(Map<String, String> values)
	{
		
		CarData result = new CarData();
		result.setDeviceInfo(ProcessDeviceInfo(values));
		String time = values.get(TORQUE_TAGMAPPING.get(TagType.TIMESTAMP));
		String speed = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_SPEED));
		String rpm = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_RPM));
		String coolantTemp = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_COOLANT));
		String torque = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_TORQUE));
		String engineLoad = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_ENGINELOAD));
		String fuelConsumption = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_FUELCONSUMPTION));
		String CO2Production = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_CO2PRODUCTION));
		String battVoltage = values.get(TORQUE_TAGMAPPING.get(TagType.OBD_BATVOLTAGE));

		if (time != null)
		{
			result.setTimeStamp(Long.valueOf(time));
		}
		else
		{
			result.setTimeStamp(new Date().getTime());
		}

		if (speed != null)
		{
			result.setSpeed(Double.parseDouble(speed));
		}
		if (rpm != null)
		{
			result.setRpm(Double.parseDouble(rpm));
		}
		if (coolantTemp != null)
		{
			result.setCoolantTemperature(Double.parseDouble(coolantTemp));
		}
		if (torque != null)
		{
			result.setTorque(Double.parseDouble(torque));
		}
		
		if (engineLoad != null)
		{
			result.setEngineLoad(Double.parseDouble(engineLoad));
		}
		if (fuelConsumption != null)
		{
			result.setFuelConsumption(Double.parseDouble(fuelConsumption));
		}
		if (CO2Production != null)
		{
			result.setCO2Production(Double.parseDouble(CO2Production));
		}
		
		if (battVoltage != null)
		{
			result.setBatteryVoltage(Double.parseDouble(battVoltage));
		}
		
		return result;
	}

}
