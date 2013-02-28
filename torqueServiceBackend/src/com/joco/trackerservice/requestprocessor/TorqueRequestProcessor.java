package com.joco.trackerservice.requestprocessor;

import java.util.HashMap;
import java.util.Map;

import com.joco.trackerservice.common.IDataWriter;

public class TorqueRequestProcessor extends RequestProcessor {

	public TorqueRequestProcessor(IDataWriter datawriter) 
	{
		super(datawriter);
	}

	@Override
	protected Map<TagType, String> generateTagMap() {
		
		Map<TagType,String> tagMap = new HashMap<TagType,String>();
		tagMap.put(TagType.TIMESTAMP,"time");
    	tagMap.put(TagType.DEVICE_DEVICEID,"id");
    	tagMap.put(TagType.DEVICE_SESSIONID,"sessionid");
    	tagMap.put(TagType.GPS_SPEED,"ff1001");
    	tagMap.put(TagType.GPS_LAT,"ff1006");
    	tagMap.put(TagType.GPS_LON,"ff1005");
    	tagMap.put(TagType.GPS_ALT,"ff1010");
    	tagMap.put(TagType.GPS_HEADING,"ff123b");
    	tagMap.put(TagType.GPS_ACCURACY,"ff1239");
    	tagMap.put(TagType.OBD_SPEED,"0d");
    	tagMap.put(TagType.OBD_RPM,"0c");
    	tagMap.put(TagType.OBD_COOLANT,"05");
    	tagMap.put(TagType.OBD_BATVOLTAGE,"2113");
    	tagMap.put(TagType.OBD_CO2PRODUCTION,"ff1257");
    	tagMap.put(TagType.OBD_ENGINELOAD,"04");
    	tagMap.put(TagType.OBD_TORQUE,"ff1225");
    	tagMap.put(TagType.OBD_FUELCONSUMPTION,"ff1203");
       	tagMap.put(TagType.PHYS_ACCX,"ff1220");
       	tagMap.put(TagType.PHYS_ACCY,"ff1221");
       	tagMap.put(TagType.PHYS_ACCZ,"ff1222");
       	tagMap.put(TagType.PHYS_ACCTOTAL,"ff1223");
    	tagMap.put(TagType.PHYS_TEMP,"46");
    	tagMap.put(TagType.PHYS_PRESSURE,"33");		  
		return tagMap;
	}
	
	

}
