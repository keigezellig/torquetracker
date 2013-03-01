package com.joco.trackerservice.rabbitmq;

import com.joco.trackerservice.common.CarData;
import com.joco.trackerservice.common.GPSData;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.PhysicalData;

public class RabbitQueueWriter implements IDataWriter
{

	private RabbitMQHelper rabbitMQHelper;
	
	public RabbitQueueWriter(String broker)
	{
		this.rabbitMQHelper = new RabbitMQHelper(broker, "TRACKER_EXCHANGE", "direct");
	}
	
	@Override
	public void writeCarData(CarData data)
	{
		
		
	}

	@Override
	public void writeGPSData(GPSData data)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePhysicalData(PhysicalData data)
	{
		// TODO Auto-generated method stub
		
	}

}
