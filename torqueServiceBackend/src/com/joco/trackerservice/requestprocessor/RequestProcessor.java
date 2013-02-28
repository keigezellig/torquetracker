package com.joco.trackerservice.requestprocessor;

import java.util.Date;
import java.util.Map;

import com.joco.trackerservice.common.CarData;
import com.joco.trackerservice.common.DeviceInfo;
import com.joco.trackerservice.common.GPSData;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.IRequestProcessor;
import com.joco.trackerservice.common.PhysicalData;
import com.joco.trackerservice.common.RequestProcessorException;

public abstract class RequestProcessor implements IRequestProcessor
{

	private final Map<TagType,String> tagMap;
	private IDataWriter dataWriter;
    
	public RequestProcessor(IDataWriter datawriter)
	{
		this.tagMap = generateTagMap();
		this.dataWriter = datawriter;
	}
	
	protected abstract Map<TagType, String> generateTagMap();
	

	@Override
	public void processRequest(Map<String, String> values) throws RequestProcessorException 
	{		
		try
		{
			//Process webrequest
			DeviceInfo deviceInfo = processDeviceInfo(values);
			GPSData gpsData = processGPSData(values);
			CarData carData = processCarData(values);
			PhysicalData physData = processPhysicalData(values);
			
			gpsData.setDeviceInfo(deviceInfo);
			carData.setDeviceInfo(deviceInfo);
			physData.setDeviceInfo(deviceInfo);
			
			
			//Write objects
			dataWriter.writeGPSData(gpsData);
			dataWriter.writeCarData(carData);
			dataWriter.writePhysicalData(physData);
		}
		catch (Exception ex)
		{
			throw new RequestProcessorException(ex);
		}
	}
	
    private DeviceInfo processDeviceInfo(Map<String, String> values)
    {
    	DeviceInfo result = new DeviceInfo();
    	String deviceId = values.get(tagMap.get(TagType.DEVICE_DEVICEID));
    	String sessionId = values.get(tagMap.get(TagType.DEVICE_SESSIONID));
    	
    	if (deviceId != null)
    	{
    		result.setDeviceId(deviceId);
    	}
    	
    	if (sessionId != null)
    	{
    		result.setSessionId(Long.parseLong(sessionId));
    	}
    	return result;
    	
    }
	private GPSData processGPSData(Map<String, String> values)
	{
		GPSData result = new GPSData();		
		String time = values.get(tagMap.get(TagType.TIMESTAMP));
		String lat = values.get(tagMap.get(TagType.GPS_LAT));
		String lon = values.get(tagMap.get(TagType.GPS_LON));
		String alt = values.get(tagMap.get(TagType.GPS_ALT));
		String spd = values.get(tagMap.get(TagType.GPS_SPEED));
		String accuracy = values.get(tagMap.get(TagType.GPS_ACCURACY));
		String heading = values.get(tagMap.get(TagType.GPS_HEADING));
		
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

	private PhysicalData processPhysicalData(Map<String, String> values)
	{
		PhysicalData result = new PhysicalData();

		
		String time = values.get(tagMap.get(TagType.TIMESTAMP));
		String accX = values.get(tagMap.get(TagType.PHYS_ACCX));
		String accY = values.get(tagMap.get(TagType.PHYS_ACCY));
		String accZ = values.get(tagMap.get(TagType.PHYS_ACCZ));		
		String accTotal = values.get(tagMap.get(TagType.PHYS_ACCTOTAL));
		String pressure = values.get(tagMap.get(TagType.PHYS_PRESSURE));
		String temp = values.get(tagMap.get(TagType.PHYS_TEMP));
		
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

	
	private CarData processCarData(Map<String, String> values)
	{
		
		CarData result = new CarData();		
		String time = values.get(tagMap.get(TagType.TIMESTAMP));
		String speed = values.get(tagMap.get(TagType.OBD_SPEED));
		String rpm = values.get(tagMap.get(TagType.OBD_RPM));
		String coolantTemp = values.get(tagMap.get(TagType.OBD_COOLANT));
		String torque = values.get(tagMap.get(TagType.OBD_TORQUE));
		String engineLoad = values.get(tagMap.get(TagType.OBD_ENGINELOAD));
		String fuelConsumption = values.get(tagMap.get(TagType.OBD_FUELCONSUMPTION));
		String CO2Production = values.get(tagMap.get(TagType.OBD_CO2PRODUCTION));
		String battVoltage = values.get(tagMap.get(TagType.OBD_BATVOLTAGE));

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
