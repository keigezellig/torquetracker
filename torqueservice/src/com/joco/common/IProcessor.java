package com.joco.common;

import java.util.Map;

public interface IProcessor<T> 
{
	//example of map content
	//[1005,6.1022] => 1005 stands for longitude.. should be defined elsewhere
	T ProcessData (Map<Integer, Object> data);

}
