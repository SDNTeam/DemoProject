package icix.TestData;

import icix.Utils.Common;
import icix.Utils.Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.Command;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

public class LoginOutTestData {
	private static Logger Log =  LogManager.getLogger(LoginOutTestData.class);

	//Login user types - Added by Vishal Dhiman on 13/02/2017 12:04PM 
	public static String Requestor = "Requestor";
	public static String Responder = "Responder";
	public static String Laboratory = "Laboratory";
	
	//Login
	public static String ResponderUsername;		//"qadbt02rk@icix.com";
	public static String ResponderPassword;			//"testing@1234";
	public static String RequesterUserName; 		//"r3lqa03rk@icix.com";
	public static String RequestorPassword; 			//"Test@12345"
	public static String LabUserName;		//"feature06@icix.com";
	public static String LabPassword;
	
	
	public static void initialiseLoginParameters(ITestContext context) throws Exception {
		
		if(context.getName().contains("ICIX Test"))
		{
			ResponderUsername = context.getCurrentXmlTest().getParameter("ResponderUsername");
			ResponderPassword = context.getCurrentXmlTest().getParameter("ResponderPassword");
			RequesterUserName = context.getCurrentXmlTest().getParameter("RequesterUserName");
			RequestorPassword = context.getCurrentXmlTest().getParameter("RequestorPassword");
			LabUserName = context.getCurrentXmlTest().getParameter("LabUserName");
			LabPassword = context.getCurrentXmlTest().getParameter("LabPassword");
			
			Log.info("User info initialized from suite file");
			
		}else{
						
			RequesterUserName = Common.GetUserData("RequesterID");
			RequestorPassword = Common.GetUserData("RequesterPassword");
						
			ResponderUsername = Common.GetUserData("ResponderID");
			ResponderPassword = Common.GetUserData("ResponderPassword");
			
			LabUserName = Common.GetUserData("LabID");
			LabPassword = Common.GetUserData("LabPassword");
			
			Log.info("Default User info initialized");
		}
		
		
	}

}
