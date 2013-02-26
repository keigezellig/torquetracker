package com.joco.common;

import java.util.Map;



public interface IDataProcessor 
{
	CarData ProcessCarData(Map<String, String> values);
	GPSData ProcessGPSData(Map<String, String> values);
	PhysicalData ProcessPhysicalData(Map<String, String> values);
	
}
