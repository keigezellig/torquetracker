package com.joco.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.joco.common.IDataProcessor;
import com.joco.webprocessors.TorqueDataProcessor;

@Path("/")
public class VehicleDataService
{
	@GET
	@Path("/torque")
	public Response processTorqueData( 
			  @Context
			  Request request,
			  @Context
			  UriInfo uriInfo)
	{
		
		MultivaluedMap<String, String> requestData = uriInfo.getQueryParameters();
		Map<String,String> dataToBeProcessed = new HashMap<String,String>();
		
		for (String key : requestData.keySet())
		{
			dataToBeProcessed.put(key, requestData.getFirst(key));
		}
		
		IDataProcessor requestProcessor = new TorqueDataProcessor();
		requestProcessor.ProcessCarData(dataToBeProcessed);
		requestProcessor.ProcessGPSData(dataToBeProcessed);
		requestProcessor.ProcessPhysicalData(dataToBeProcessed);
		
		return Response.ok().build();
		
	}
}
