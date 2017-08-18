package icix.Utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.sun.jna.platform.unix.X11.Display;

public class ExtentManager {
	 static ExtentReports extent;
	    final static String filePath = System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\TestReport.html";
	    final static String configFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.xml";
	    
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            extent = new ExtentReports(filePath, false, DisplayOrder.NEWEST_FIRST);
	            extent.loadConfig(new File(configFilePath));
	        }
	        
	        return extent;
	    }
}
