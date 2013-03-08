package com.joco.trackerservice.requestprocessor;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.joco.trackerservice.common.IDataWriter;

public class TorqueRequestProcessor extends RequestProcessor {

	@Inject
	public TorqueRequestProcessor(IDataWriter datawriter) 
	{
		super(datawriter);
	}

	@Override
	protected Map<TagType, String> generateTagMap() {
		
		Map<TagType,String> tagMap = new HashMap<TagType,String>();
		tagMap.put(TagType.TIMESTAMP,"time");
    	tagMap.put(TagType.DEVICE_DEVICEID,"id");
    	tagMap.put(TagType.DEVICE_SESSIONID,"session");
    	tagMap.put(TagType.GPS_SPEED,"kff1001");
    	tagMap.put(TagType.GPS_LAT,"kff1006");
    	tagMap.put(TagType.GPS_LON,"kff1005");
    	tagMap.put(TagType.GPS_ALT,"kff1010");
    	tagMap.put(TagType.GPS_HEADING,"kff123b");
    	tagMap.put(TagType.GPS_ACCURACY,"kff1239");
    	tagMap.put(TagType.OBD_SPEED,"k0d");
    	tagMap.put(TagType.OBD_RPM,"k0c");
    	tagMap.put(TagType.OBD_COOLANT,"k05");
    	tagMap.put(TagType.OBD_BATVOLTAGE,"k2113");
    	tagMap.put(TagType.OBD_CO2PRODUCTION,"kff1257");
    	tagMap.put(TagType.OBD_ENGINELOAD,"k04");
    	tagMap.put(TagType.OBD_TORQUE,"kff1225");
    	tagMap.put(TagType.OBD_FUELCONSUMPTION,"kff1203");
       	tagMap.put(TagType.PHYS_ACCX,"kff1220");
       	tagMap.put(TagType.PHYS_ACCY,"kff1221");
       	tagMap.put(TagType.PHYS_ACCZ,"kff1222");
       	tagMap.put(TagType.PHYS_ACCTOTAL,"kff1223");
    	tagMap.put(TagType.PHYS_TEMP,"k46");
    	tagMap.put(TagType.PHYS_PRESSURE,"k33");		  
		return tagMap;
	}
	
	

}
