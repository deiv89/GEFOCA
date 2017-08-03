package it.synclab.utilities;

import javax.servlet.ServletRequest;

public class ParameterUtility {
	
	public static int getIntValue(ServletRequest request, String paramName, int defaultValue)
	{
	     if(request.getParameter(paramName) != null){
	        return Integer.valueOf(request.getParameter(paramName));
	    } else{
	        return defaultValue;
	    }
	}
	
	public static double getDoubleValue(ServletRequest request, String paramName, double defaultValue)
	{
	     if(request.getParameter(paramName) != null){
	        return Double.valueOf(request.getParameter(paramName));
	    } else{
	        return defaultValue;
	    }
	}
	

}
