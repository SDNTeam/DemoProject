package icix.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import icix.Locators.LoginOutRepo;
import icix.Locators.GlobalRepo;
import icix.Locators.ProductRepo;
import icix.Locators.RequestRepo;
import icix.Start.Start;


public class Common extends Start {
	

	public static void Init()
	{
		InitilizeBrowser();
	}
	
	public static void LoginUser(String UserName, String Password) throws Exception  
	{	
		Log.info("Start Log in to application");
		ClearAndSendKeys(LoginOutRepo.txtUsername, UserName, 20);
		ClearAndSendKeys(LoginOutRepo.txtPassword, Password, 20);
		//ClickElement(LoginOutRepo.btnLogin, 20);
		ClickElement(By.id("Login"),"Login button", 20);
		
		//WaitTool.FindWithFluentWait(driver, GlobalRepo.appLauncherIcon, 300);
				
	}
	
	public static void LogoutUser()
	{		
		try {
			SwitchToDefaultContent(10);
			ClickElement(LoginOutRepo.imgProfile, 10);
//			driver.findElement(LoginOutRepo.imgProfile).click();
//			driver.findElement(By.xpath("//img[contains(@class,'profileTrigger')]")).click();
//			Thread.sleep(2000);
			ClickElement(LoginOutRepo.lnkLogout, 10);
//			driver.findElement(LoginOutRepo.lnkLogout).click();
//			driver.findElement(By.linkText("Log Out")).click();
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void SwitchToLightiningView()
	{		
		try
		{
			
	      	if(!WaitTool.isElementPresentAndDisplay(driver, LoginOutRepo.imgWaffle)){
	      		
	      		if (Common.FindAllElements(LoginOutRepo.drpSwitchToLighteningByXPath,10).size() > 0)
	      			{
	      				Log.info("Switching to Lightening view");
	      				ClickElement(LoginOutRepo.drpSwitchToLighteningById, 10);
					
	      				ClickElement(LoginOutRepo.OptionSwitchToLightening, 10);
	      				//ClickElement(LoginOutRepo.imgWaffle, 10);
//						ClickElement(LoginOutRepo.appLauncherIcon,5000);
	      			}
	      	}
	      	else
      		{
	      		Log.info("Already on Lightening view");
      			//ClickElement(LoginOutRepo.imgWaffle, 10);
      			WaitTool.waitForPageLoadToComplete(driver, 60);
//				ClickElement(LoginOutRepo.appLauncherIcon,5000);
      		}
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String GetTestData(String ColumnName) {
		Properties prop = new Properties();
		InputStream input = null;
		String projectDir = System.getProperty("user.dir") + "/src/test/java/TestData/";
		try {			
			input = new FileInputStream(projectDir + "TestData.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(ColumnName);
	}
	
	public static void ClickElement(By Element, int timeOutInSeconds)
	{		
		try {
			WaitTool.waitForElementToBeClickable(driver, Element, timeOutInSeconds).click();;
		} catch (Exception e) {
				Log.error("There is exception: "+ e.toString());
				
		}
	}
	
	public static void ClickElement(By Element, String detail, int timeOutInSeconds) throws Exception
	{		
		try {
			Log.info("Clicking on:" + detail);
			WaitTool.waitForElementToBeClickable(driver, Element, timeOutInSeconds).click();;
		} catch (Exception e) {
			Log.error("Error on:" + detail);
			Log.error("There is exception: "+ e.getMessage());
			throw e;
			
		}
	}
	
	
	//Commenting redundant method
	public static void ClickElement(WebElement Element, int timeOutInSeconds)
	{		
		try {
			WaitTool.waitForElementToBeClickable(driver, Element, timeOutInSeconds);
			Element.click();
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}
	
	public static List<WebElement> FindAllElements(By Element, int timeOutInSeconds)
	{		
		List<WebElement> TempElement = null;
		try {
			WaitTool.waitForElementsPresentAndDisplay(driver, Element, timeOutInSeconds);
			TempElement=driver.findElements(Element);	
		} catch (Exception e) {
			Log.warn("There is exception: "+ e.toString());
		}
		return TempElement;	
	}
	
	//Commenting redundant method
//	public static List<WebElement> FindAllElements(WebElement FromElement,By Element)
//	{		
//		List<WebElement> TempElement = null;
//		try {
//			TempElement=FromElement.findElements(Element);			
//			
//		} catch (Exception e) {
//			Log.warn("There is an exception: " + e.toString());
//		}
//		return TempElement;	
//	}
	
	public static WebElement FindAnElement(By Element, int timeOutInSeconds)
	{		
		WebElement TempElement = null;
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
			TempElement=driver.findElement(Element);
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
		return TempElement;	
	}
	

	public static void SwitchToFrame() {
		  try {
		   List<WebElement> NewRequestFrame=Common.FindAllElements(GlobalRepo.frame,10);
		   int size=NewRequestFrame.size();
		   driver.switchTo().frame(size-1);
		   Log.info("Switching to frame: " +size);
		   Thread.sleep(2000);
		  } catch (InterruptedException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  
		 }
	
	//TBD
	public static void SwitchToFrame(WebElement frames, int interval) {
		try {			
			driver.switchTo().frame(frames);
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Commenting redundant method
//	public static void SwitchToFrameString(String tagName, int interval){
//		try {			
//			driver.switchTo().frame(tagName);
//			Thread.sleep(interval);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public static void switchWindow(){
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
	}
	
	public static void ClearAndSendKeys(By Element, String KeysToSend, int Interval) throws Exception
	{		
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Element, Interval);
			driver.findElement(Element).clear();
			Thread.sleep(200);
			driver.findElement(Element).sendKeys(KeysToSend);
			Log.info("Set Text value: " + KeysToSend + " into "+Element.toString());
			Thread.sleep(Interval);
		} catch (Exception e) {
			Log.error("There is an exception in setting a text value: " + e.toString());
			throw e;
		}
	}

	public static void ClearAndSendKey(By Element, String KeysToSend[], int timeOutInSeconds) throws Exception
	{		
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
			driver.findElement(Element).clear();
			Thread.sleep(200);
			driver.findElement(Element).sendKeys(KeysToSend);
			Log.info("Set Text value: " + KeysToSend + " into "+Element.toString());
		} catch (Exception e) {
			Log.warn("There is an exception in setting a text value: " + e.toString());
			throw e;
		}
	}

	public static void sendKeys(By Element,Keys enter,int timeOutInSeconds) {
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
		driver.findElement(Element).sendKeys(enter);
	} catch (Exception e) {
		Log.warn("There is an exception: " + e.toString());
	}	
	}

	public static void GlobalSearch(String moduleName, String KeywordToSearch)
	 {
	  try
	  {
	   Thread.sleep(6000);
	   WebElement globalSearchBox=Common.FindAnElement(GlobalRepo.txtGlobalSrc, 30); //driver.findElement(GlobalRepo.txtGlobalSrc);
	   globalSearchBox.click();
	   Log.info("Global search text box clicked.");
	   globalSearchBox.sendKeys(KeywordToSearch);
	   Log.info("Keyword "+ KeywordToSearch + " entered for searching.");
	   Common.ClickElement(GlobalRepo.optionSearchInSalesforce, 30);
	   Log.info("Clicked on " + KeywordToSearch + " in salesforec.");
	   Common.ClickElement(GlobalRepo.lnkShowMore, 120);
	   Log.info("Clicked on show more link.");
	   
	   switch(moduleName){
	         case "Requests":  
	        	 Common.ClickElement(GlobalRepo.globalSearchRequestTab, 120);
	        	 WaitUntilResultsPresent(GlobalRepo.globalSearchRequestTab);
	        	 Log.info("Request tab clicked");
	          break;
	          
	         case "Workflows":  
	        	 Common.ClickElement(GlobalRepo.globalSearchWorkflowsTab, 120);
	        	 WaitUntilResultsPresent(GlobalRepo.globalSearchWorkflowsTab);
	        	 Log.info("Workflow tab clicked");
	          break;
	          
	         case "Trading Partner Groups":
//	        	 Common.ClickElement(GlobalRepo.globalSearchTradingPartnerGroups, 120);
//	        	 WaitUntilResultsPresent(GlobalRepo.globalSearchTradingPartnerGroups);
	        	 Log.info("Trading Partner Groups tab clicked");

	         default:   
	        	 Log.info("Invalid Search Tab");
	          break;
	  }
	   Thread.sleep(500);  
	  }
	  catch (InterruptedException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  
	 }
	 
	private static void WaitUntilResultsPresent(By globalSearchRequestTab) throws InterruptedException {
		   long lStartTime = System.currentTimeMillis();
		   long timeDifference=0;
		   do{
		     if(!Common.getElementText(GlobalRepo.globalSearchResultNumber, 5).contains("0 Results"))  {
		     Log.info("Request has reflected on responder side");
		       break;
		     }    
		     Thread.sleep(10000);
		     Log.info("checking for expected search results");
		     Common.ClickElement(globalSearchRequestTab, 10);
		     WaitTool.waitForElementPresentAndDisplay(driver, GlobalRepo.globalSearchResult, 10);
		     timeDifference=System.currentTimeMillis()-lStartTime;
		   }while(timeDifference<300000);
		   Log.info("Total Time taken while looking for request in Request Search Results:"+timeDifference+"seconds");
		   if(!WaitTool.isElementPresentAndDisplay(driver, GlobalRepo.globalSearchResultNumber)){
		    Log.warn("Request has not been reflected on reponder side within 5 minutes");
		    assertTrue(false);
		    }
		   
		}
	
	public static void clickPartialLinkText(String LinkToClick, int Interval) throws InterruptedException
	{
		Common.ClickElement((By.partialLinkText(LinkToClick)), Interval);
		Log.info("The link " +LinkToClick+ " is clicked.");
	}

	//TBD
	public static void ClickLink(String LinkToClick, int Interval)
	{
		try {
			WebElement rateElement = driver.findElement(By.linkText(LinkToClick));
			  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
			//driver.findElement(By.linkText(LinkToClick)).click();	
			  Log.info("The link: " +LinkToClick+ "is clicked.");
			Thread.sleep(Interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void SwitchTab(int Interval)
	{
		try {
			//driver.findElement(Dropdown).click();
			//driver.findElement(LabName).click();
			//Select drpToSelectFrom=new Select(driver.findElement(Dropdown));
			//drpToSelectFrom.selectByVisibleText(TextToSelect);						
			Thread.sleep(Interval);
			/*
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    */
			Actions TabToShiftTo= new Actions(driver);
			TabToShiftTo.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ClickArrowIcon(By ArrowToClick, int timeOutInSeconds)
	{
		try {
			WaitTool.waitForElementsPresentAndDisplay(driver, ArrowToClick, timeOutInSeconds);
			List<WebElement> ArrowToOpenMenu = Common.FindAllElements(ArrowToClick,10);
			
			if(ArrowToOpenMenu.size()>0)
			{
				if(ArrowToOpenMenu.size()>1)
				{			
					Common.ClickElement(ArrowToOpenMenu.get(1), 2);			
				}
				else
				{
					Common.ClickElement(ArrowToOpenMenu.get(0), 2);
				}
			}	
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}

	public static void SelectDropdownText(By Dropdown,String TextToSelect, int timeOutInSeconds)
	{
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Dropdown, timeOutInSeconds);
			Select drpToSelectFrom=new Select(driver.findElement(Dropdown));
			drpToSelectFrom.selectByVisibleText(TextToSelect);	
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}

	//TBD
	public static void javascriptExecutor(WebElement Element,int Interval){
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Element);
		try {
			Thread.sleep(Interval);
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}

	//TBD
	public static void SwitchToDefaultContent(int Interval)
	{
		try {
			System.out.println("Switching default");
			driver.switchTo().defaultContent();
			Thread.sleep(Interval);
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}

	public static void RefreshPage(int Interval)
	{
		try {	
		Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(Interval);
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
	}
	
	//==========================  Added by rishu (28.12.16) =========================
	// Select DueDate for request 
	public static void selectDueDate(int Interval) throws InterruptedException{
	Actions action = new Actions(driver);
	WebElement we1 = driver.findElement(By.id("dueDate"));
	action.moveToElement(we1).moveToElement(driver.findElement(By.xpath("//span[contains(.,'28')]"))).click().build().perform();
	Thread.sleep(Interval);
	}
	
	public static void selectDueDate1(By ElementFirst,By ElementSecond,int Interval) throws InterruptedException{
		Actions action = new Actions(driver);
		WebElement we1 = driver.findElement(ElementFirst);
		action.moveToElement(we1).moveToElement(driver.findElement(ElementSecond)).click().build().perform();
		Thread.sleep(Interval);
		}

	// Double click on element	
	public static void doubleClick(By Element,int timeOutInSeconds) throws InterruptedException {
		try{
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(Element)).build().perform();
			//action.doubleClick(driver.findElement(By.xpath("//span[contains(.,'"+SendRequestComments+"')]"))).build().perform();
		} catch (Exception e) {
			Log.warn("There is an exception: " + e.toString());
		}
		
	}

	// Close  Browser	
	public static void closeBrowser(){
//		driver.quit();
		driver.close();
	}

	// Verify test present in page
	public static void verifyTextPresentorNot(String AutoRequeestName){
		driver.getPageSource().contains(AutoRequeestName);
	}

	public static void mouseHover(By ElementToHover,By ElementToClick,int timeOutInSeconds){
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, ElementToHover, timeOutInSeconds);
			WebElement elemenToHover= driver.findElement(ElementToHover);
			Actions action = new Actions(driver);
		    action.moveToElement(elemenToHover).build().perform();
		    WaitTool.waitForElementPresentAndDisplay(driver, ElementToClick, timeOutInSeconds);
		    driver.findElement(ElementToClick).click();
		} catch (Exception e) {
				Log.warn("There is an exception: " + e.toString());
		} 
	}

	public static void searchAndPublishProductForm(String FormName) throws InterruptedException{ 
		 WebElement txtSrc=driver.findElement(GlobalRepo.txtGlobalSrc);
			txtSrc.click();
			txtSrc.sendKeys(FormName);
			Thread.sleep(500);
			txtSrc.sendKeys(Keys.ENTER);
			Thread.sleep(500);
		    Common.ClickLink(FormName, 5000);
		    doubleClick(ProductRepo.Status,1000);
		 
		    /* Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(ProductRepo.Status)).build().perform();*/
	}
	
	public static void assertText(By Element,String ExpectedText, int Interval)
	{		
		Assert.assertEquals(WaitTool.waitForElementPresentAndDisplay(driver, Element, 10).getText(), ExpectedText);
		//WaitTool.waitForElementPresentAndDisplay(driver, Element, 10).click();
	}

	public static void alert(int Interval) throws InterruptedException{
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
	 }

	public static void switchToActiveElementString(String Element,int Interval){
		driver.switchTo().activeElement().sendKeys(Element);
	}
	 
	public static void switchToActiveElementKeys(Keys tab,int Interval) {
		 driver.switchTo().activeElement().sendKeys(tab);
	}

	public static void SwitchToWindowHandle(String Element){
		driver.switchTo().window(Element);
	}
	
	public static String WindowHandle(){
		return driver.getWindowHandle();
	}
	
	public static Set<String> WindowHandles(){
		driver.getWindowHandles();
		return null;	
	}
	
	public static  Set<String> getWindowHandles(){
		  return driver.getWindowHandles();
	}

	public static void Action(WebElement Element){
		Actions act = new Actions(driver);
		act.moveToElement(Element);
	}

	public static void switchFrame(By Element, int Interval)
	{		
		try {			
			driver.switchTo().frame(driver.findElement(Element));
			Thread.sleep(Interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteCookies(int Interval){
		try {
			driver.manage().deleteAllCookies();
			Thread.sleep(Interval);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	public static void clickAppLauncher(){
		ClickElement(LoginOutRepo.imgWaffle, 5000);
	}

	//========== Vishal ============
	public static boolean checkExistenceOfElement(By Element, int timeOutInSeconds){
		boolean elementStatus = false;
		try {
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
			elementStatus = driver.findElements(Element).size()>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementStatus;
	}
	
	//Updated by Vishal Dhiman 14/02/2017
	//Purpose - If null is returned then the comparison fails and execution of fails
	public static String getElementText(By Element, int timeOutInSeconds){
		String pageText = null;
		try{
			WaitTool.waitForElementPresentAndDisplay(driver, Element, timeOutInSeconds);
			if(Common.checkExistenceOfElement(Element, timeOutInSeconds) == true)
			pageText = driver.findElement(Element).getText();
			else
				pageText=null;
		} catch (Exception e){
			Log.info("There is an exception: " + e.toString());
		}
		if(pageText == null)
			return("No value found for this element");
		else
			return pageText;
	}
	
	public static void ClickElementByIndex(By Element,int index, int Interval) {		
		try {
			WaitTool.waitForElementToBeClickable(driver, Element, Interval);
			driver.findElements(Element).get(index).click();
		} catch (Exception e) {
			Log.warn("Element is not clickable: "+e.toString());
		}
	}
	
	//Added by Vishal Dhiman 18/02/2017
	//purpose - to click the last index from all the elements found
	public static void ClickElementByLastIndex(By Element, int Interval) {		
		try {
			WaitTool.waitForElementToBeClickable(driver, Element, Interval);
			int elementCount = Common.getCount(Element, Interval);
			driver.findElements(Element).get(elementCount).click();
		
		} catch (Exception e) {
			Log.warn("Element is not clickable: "+e.toString());
		}
	}
	
	public static int getCount(By Element, int Interval) throws InterruptedException{
		Thread.sleep(Interval);
		List<WebElement> myElements = driver.findElements(Element);
		int size = myElements.size();
	return size;
	}
	
	//Added by Vishal Dhiman 15/02/2017
	public static void selectDate(By element, int interval) throws Exception {
        Actions action=new Actions(driver);
        Thread.sleep(1000);
        WaitTool.isElementPresentAndDisplay(driver, element);
        action.moveToElement(driver.findElement(element))
        .click(driver.findElement(GlobalRepo.tblNextMonth)) .build().perform();
             
        List<WebElement> tblTds= Common.FindAllElements(GlobalRepo.tblTd,10);
        Log.info("Clicking on date");
        WaitTool.waitForElementToBeClickable(driver, tblTds.get(10), interval);
        action.click(Common.FindAllElements(GlobalRepo.tblTd,10).get(10))
        .build().perform();
	}
	
	public static  String getProjectDirectory(){
		return System.getProperty("user.dir");
	}
	public static String getTextFile(String fileType){
		String filePath=getProjectDirectory()+"\\src\\main\\resources\\DocumentTypes";
		switch (fileType) {
        case ".txt":  filePath=filePath+"\\textDoc.txt";
                 break;
        case ".jpg":  filePath = filePath+"\\jpegImage.jpeg";
                 break;
        case ".jpeg":  filePath = filePath+"\\jpegImage.jpeg";
                 break;
        case ".xml":  filePath = filePath+"\\xmlFile.xml";
                 break;
        default:   filePath=filePath+"\\textDoc.txt";
        		 break;
		}
		return filePath;
	
	}
	
	public static void assertTrue(String str1, String str2){
		Assert.assertTrue(str1.equalsIgnoreCase(str2));
		
	}
	public static void assertTrue(String str1, String str2,String message){
		Assert.assertTrue(str1.equalsIgnoreCase(str2),message);
		
	}
	
	public static void assertTrue(boolean isTrue){
		Assert.assertTrue(isTrue);
		
	}
	
	public static void assertTrue(int num1, int num2){
		Assert.assertTrue(num1==num2);
		
	}
	public static void waitForElementToBeVisible(By element, int timeOutInSeconds){
		WaitTool.waitForElementPresentAndDisplay(driver, element, timeOutInSeconds);
	}
	
	public static void waitForElementTobeInvisible(By element, int timeOutInSeconds) throws Exception{
		WaitTool.waitForElementsToBeInvisible(driver, element, timeOutInSeconds);
	}
	
	public static void waitForPageLoadToComplete(){
		WaitTool.waitForPageLoadToComplete(driver, 120);
	}
	
	public static void openAppLauncher(){
		  if(WaitTool.isElementPresentAndDisplay(driver, GlobalRepo.appLauncherIcon)){
		   Log.info("Opening App Launcher");
		   Common.ClickElement(GlobalRepo.appLauncherIcon, 10);
		  }else
			  Log.info("App Launcher icon is not visible, seems like page is not on Lightning view");

	}
	
	public static void closeAppLauncher(){
		if(WaitTool.isElementPresentAndDisplay(driver, GlobalRepo.closeAppLauncher)){
		Log.info("Closing App Launcher");
		Common.ClickElement(GlobalRepo.closeAppLauncher, 10);
		}
		else
		  Log.info("App Laucher is already closed or not opened");
	}
		 
	public static void RefreshPage(){
		driver.navigate().refresh();
		WaitTool.waitForPageLoadToComplete(driver, 20);
	}
	
	//Jagdeep.kaur : To click element using JavaScritp 
	 public void clickUsingJS(By by) throws Exception {
		 WaitTool.waitForElementToBeClickable(driver, by, 120);
		 
		 try{
			 JavascriptExecutor jse = (JavascriptExecutor) driver;
			 jse.executeScript("arguments[0].click();", driver.findElement(by));
		 }
		 catch(Exception e){
			 Log.warn("Exception thrown: "+e.getMessage());
		 }
	 }
	 
	 //Jagdeep.kaur : To click element using pixel points
	 public void clickElementPoint(By by) throws Exception {
		 WaitTool.waitForElementToBeClickable(driver, by, 120);
		 try {
			 JavascriptExecutor jse = (JavascriptExecutor) driver;
			 jse.executeScript("window.scrollTo(" + driver.findElement(by).getLocation().x + ",0)");
			 Thread.sleep(1000);
			 driver.findElement(by).click();
		 }
		 catch(Exception e){
			 Log.warn("Exception thrown: "+e.getMessage());
		 }
	 }
	 
	 
	 public static String GetUserData(String key) {
			Properties prop = new Properties();
			InputStream input = null;
			String projectDir = System.getProperty("user.dir") + "/src/main/resources/";
			try {			
				input = new FileInputStream(projectDir + "users.properties");
				// load a properties file
				prop.load(input);
				// get the property value and print it out

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {

				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return prop.getProperty(key);
		}
	 
	 public static String CaptureScreenForReport(String ImagesPath)
	 {
	     TakesScreenshot oScn = (TakesScreenshot) driver;
	     File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	  File oDest = new File(ImagesPath+".jpg");
	  try {
	       FileUtils.copyFile(oScnShot, oDest);
	  } catch (IOException e) {System.out.println(e.getMessage());}
	  
	  //Create relative path
	  
	  return oDest.getName();
	 }
	 
	 public static String getTimeStamp(){
		 String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
		 return timeStamp;
	 }
	 
	 public static void executeStep(boolean result, String step) throws Exception{
		 if(result){
			 Log.info("Execution of: "+ step+"-PASS");
		 }else{
			 throw new Exception("Execution of: "+step+"-FAILED");
		 }
		 
	 }
	 
	 public static void verifyStep(boolean result, String step) throws Exception{
		 
		 if(result){
			 Log.info("Verification of: "+step+"-PASS");
		 }else{
			 throw new Exception("Verification of: "+step+"-FAILED");
		 }
		 
	 }
	 
	 
}

