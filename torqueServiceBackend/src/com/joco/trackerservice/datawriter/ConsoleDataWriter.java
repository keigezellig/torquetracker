package com.joco.trackerservice.datawriter;

import com.google.inject.Inject;
import com.joco.trackerservice.common.CarData;
import com.joco.trackerservice.common.GPSData;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.PhysicalData;

public class ConsoleDataWriter implements IDataWriter {

	@Inject
	public ConsoleDataWriter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeCarData(CarData data) 
	{
		System.out.println(data);

	}

	@Override
	public void writeGPSData(GPSData data) 
	{
		System.out.println(data);

	}

	@Override
	public void writePhysicalData(PhysicalData data) 
	{
		System.out.println(data);

	}

}
