/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joco.trackerservice.testbackend;

import com.joco.trackerservice.common.CarData;
import com.joco.trackerservice.common.DeviceInfo;
import com.joco.trackerservice.common.GPSData;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.PhysicalData;
import com.joco.trackerservice.rabbitmq.RabbitQueueWriter;
import java.util.Date;

/**
 *
 * @author maarten
 */
public class MQSendTest 
{
    public static void main(String[] args)
    {
        DeviceInfo di = new DeviceInfo(12234, "Device X");
        GPSData gps = new GPSData(new Date().getTime(), 51.0, 6.0, 270.0,  40.0, 36.0, 3.0);
        CarData car = new CarData(new Date().getTime(), 40.0, 3600, 90, 80, 5, 50, 17, 12);
        PhysicalData phys = new PhysicalData(new Date().getTime(), 0.444, 0.444, 1.33, 4, 25, 1012);
        
        gps.setDeviceInfo(di);
        car.setDeviceInfo(di);
        phys.setDeviceInfo(di);
        
        IDataWriter writer = new RabbitQueueWriter(null);
        
        while(true)
        {
            writer.writeCarData(car);
            writer.writeGPSData(gps);
            writer.writePhysicalData(phys);
        }
    }
    
}
