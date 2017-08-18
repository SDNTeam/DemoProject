package icix.Utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

import icix.Tests.TC9648_Test;

public class Log 
{

	private static Logger Log ;
	
	private static void init(){
		if(Log ==null){
			Log = LogManager.getLogger(Log.class);
		}
	}
	
	public static void info(String message)
	{
		init();
		Log.info(message);
		
	}
	
	public static void warn(String message)
	{
		init();
		Log.warn(message);
		
	}
	
	public static void error(String message)
	{
		init();
		Log.error(message);
		
	}
}
