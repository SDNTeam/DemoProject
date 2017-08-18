package icix.Utils;

import icix.Start.Start;

import java.io.File;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


public class ScreenShotOnFailure extends TestListenerAdapter {

	public static String destDirFailed=null;
	
	@Override
	public void onTestFailure(ITestResult tr) {
		WebDriver driver = Start.getDriverInstance();
		
		//if there is no folder created, then create one		
		if(destDirFailed==null){
			destDirFailed = TakeScreenshots.createScreenshotFolder()+"/Failed";
		}		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String testMethod = tr.getMethod().getMethodName();
		String pageTitle= driver.getTitle();
		String newPageTitle = pageTitle.replaceAll("[\\/:*?\"<>|]", "_");
		String destFile = newPageTitle+ "_" + testMethod+"_"+dateFormat.format(new Date()) + ".png";
		TakeScreenshots.captureScreenshot(driver, destDirFailed, destFile);
		
		String fileWithProtocol = null;
		
		try {
			File newfile = new File(destFile);
			String filePath = newfile.getAbsolutePath().replace(destFile, "");
			//this will get absolute path of file except filename
			String fileFullPath = filePath.concat(destDirFailed + "/"+ destFile);
			fileWithProtocol = Paths.get(fileFullPath).toUri().toASCIIString();			//update file path to URI 
		} catch (Exception e) {
			System.out.println("unable to get file path for reports " + e.getMessage());
		}

		// attach screenshot on the report
		Reporter.setEscapeHtml(false);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>Screenshot saved <a href=" + fileWithProtocol + ">Screenshot</a>");
		
	}
	
	public void resetScreenshotFolder() {
		destDirFailed = null;
	}
	
	/**@author jagdeep.kaur
	 * Take screen shot in fail folder explicitly.
	 * @param testCaseName the test case name
	 */
	public static void takeScreenShotInFailFolder(String testCaseName){

		WebDriver driver = Start.getDriverInstance();
		
		//if there is no folder created, then create one		
		if(destDirFailed==null){
			destDirFailed = TakeScreenshots.createScreenshotFolder()+"/Failed";
		}		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String testMethod = testCaseName;
		String pageTitle= driver.getTitle();
		String newPageTitle = pageTitle.replaceAll("[\\/:*?\"<>|]", "_");
		String destFile = newPageTitle+ "_" + testMethod+"_"+dateFormat.format(new Date()) + ".png";
		TakeScreenshots.captureScreenshot(driver, destDirFailed, destFile);
		
		String fileWithProtocol = null;
		
		try {
			File newfile = new File(destFile);
			String filePath = newfile.getAbsolutePath().replace(destFile, "");
			//this will get absolute path of file except filename
			String fileFullPath = filePath.concat(destDirFailed + "/"+ destFile);
			fileWithProtocol = Paths.get(fileFullPath).toUri().toASCIIString();			//update file path to URI 
		} catch (Exception e) {
			System.out.println("unable to get file path for reports " + e.getMessage());
		}

		// attach screenshot on the report
		Reporter.setEscapeHtml(false);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>Screenshot saved <a href=" + fileWithProtocol + ">Screenshot</a>");
	}
	
}