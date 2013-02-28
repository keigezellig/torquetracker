package com.joco.trackerservice.common;

import java.util.Map;



public interface IRequestProcessor 
{
	void processRequest(Map<String, String> values) throws RequestProcessorException;	
}
