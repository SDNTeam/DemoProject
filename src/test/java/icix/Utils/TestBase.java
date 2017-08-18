package icix.Utils;

import icix.TestData.LoginOutTestData;
import icix.Tests.TC9648_Test;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;

@Listeners({ icix.Utils.ScreenShotOnFailure.class, TestEvents.class})

public class TestBase {
	
	private static Logger log = LogManager.getLogger(TestBase.class);
	protected static String Requestor = "Requestor";
	protected static String Responder = "Responder";
	protected static String Laboratory = "Laboratory";
	
	public static void logTestStep(String step) {
				log.info(step);
				ReportUtil.getTest().log(LogStatus.INFO, step);
	}
	
	
	
	@BeforeTest
	public void initialiseParameters(ITestContext context) throws Exception
	
	{
		LoginOutTestData.initialiseLoginParameters(context);
	}
	@BeforeClass
	public void beforeClass() {
		Common.Init();	
	}


	@AfterClass
	public void close(){
		Common.LogoutUser();
		Common.closeBrowser();
	}
	
	
	
	//Html Repoting
	  @AfterMethod
	    protected void afterMethod(ITestResult result) {
	        ExtentManager.getReporter().endTest(ReportUtil.getTest());        
	        ExtentManager.getReporter().flush();
	    }
	
	
}
