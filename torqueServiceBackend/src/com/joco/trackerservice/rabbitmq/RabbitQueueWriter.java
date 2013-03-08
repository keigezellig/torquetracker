package com.joco.trackerservice.rabbitmq;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.joco.trackerservice.common.CarData;
import com.joco.trackerservice.common.GPSData;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.PhysicalData;


public class RabbitQueueWriter implements IDataWriter
{

	private RabbitMQHelper rabbitMQHelper;
	
	private Gson gson;
	
	
	@Inject
	public RabbitQueueWriter(String broker)
	{
		
		if (broker == null)
		{
			broker = "localhost";
		}
		this.rabbitMQHelper = new RabbitMQHelper(broker, "TRACKER_EXCHANGE", "direct");
		this.gson = new Gson();
	}
	
	@Override
	public void writeCarData(CarData data)
	{
		try
		{
			String json = gson.toJson(data);
			this.rabbitMQHelper.sendMessage("CAR",json);
			
			/*if (this.producer.connectToRabbitMQ())
			{
				this.producer.SendMessage("CAR",json.getBytes());
			}*/
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			this.rabbitMQHelper.close();
			//this.producer.Dispose();
		}
		
		
	}

	@Override
	public void writeGPSData(GPSData data)
	{
		try
		{
			String json = gson.toJson(data);
			this.rabbitMQHelper.sendMessage("GPS",json);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			this.rabbitMQHelper.close();
		}	
		
	}

	@Override
	public void writePhysicalData(PhysicalData data)
	{
		try
		{
			String json = gson.toJson(data);
			this.rabbitMQHelper.sendMessage("PHYSICAL",json);
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			this.rabbitMQHelper.close();
			
		}
	}

}
