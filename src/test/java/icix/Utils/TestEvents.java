package icix.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class TestEvents implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ReportUtil.getTest().log(LogStatus.FAIL, result.getThrowable());
    	Log.warn("TEST FAILED - "+result.getName());
    	String filePath =System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\Screenshots\\"+ Common.getTimeStamp()+result.getName();
    	String relativePath ="Screenshots\\"+Common.CaptureScreenForReport(filePath);
    	ReportUtil.getTest().log(LogStatus.INFO, "Snapshot below: " + ReportUtil.getTest().addScreenCapture(relativePath));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ReportUtil.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	}

	@Override
	public void onTestStart(ITestResult test) {
		// TODO Auto-generated method stub
		ReportUtil.startTest(test.getMethod().getMethodName(),test.getMethod().getDescription(),test.getMethod().getGroups());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		ReportUtil.getTest().log(LogStatus.PASS, "Test passed");
	}

}
