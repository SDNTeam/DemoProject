package icix.Utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitTool {

	public static WebElement waitForElementPresentAndDisplay(WebDriver driver,final By by,int timeOutInSeconds) {
		WebElement element = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
					
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			Log.warn("element is not present and displayed");
		}
		return element;
	}
	
	public static List<WebElement> waitForElementsPresentAndDisplay(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		List<WebElement> element = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
			
			
			element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			//throw new Exception(by.toString()+ "element is not present and displayed");
		}
		return element;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			
			
			element = wait.until(ExpectedConditions.elementToBeClickable(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			throw new Exception(by.toString()+ " element is not present and displayed");
		}
	
	}
	
	public static void waitForPageLoadToComplete(WebDriver driver, int timeOutInSeconds){
		try{
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver newDriver) {
	                return ((JavascriptExecutor)newDriver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	    wait.until(pageLoadCondition);
	    //Log.info("Waiting for Page to load completely");
		}
		catch(Exception e){
			System.out.println("not able to load page and exception is thrown "+e.getMessage());
		}
	}

	public static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
		try {			
			if(driver.findElement(by).isDisplayed())
				return true;
			else 
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitForElementToBeClickable(WebDriver driver,
			WebElement element, int timeOutInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
			
			element = wait.until(ExpectedConditions.elementToBeClickable(element));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
		} catch (Exception e) {
			Log.warn(element.toString()+ "element is not present and displayed");
		}
		
	}
	
	public static Boolean waitForElementsToBeInvisible(WebDriver driver,final By by,int timeOutInSeconds) throws Exception {
		Boolean isTrue=false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()

			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
			
			isTrue = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset implicitlyWait
			return isTrue; // return the element
		} catch (Exception e) {
			//throw new Exception(by.toString()+ "element is not present and displayed");
		}
		return isTrue;
	}
	
	@SuppressWarnings("null")
	public static WebElement FindWithFluentWait(WebDriver driver,final By by,int timeOutInSeconds){
		Log.info("Waiting for element: " + by.toString());
		WebElement element=null;
				
		long startTime = System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(WebDriverException.class, NoSuchElementException.class);
		
				
		element=	wait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(by); 
			}
			
		});
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		Log.info("Total waiting(ms) : " + totalTime);
		
		return element;
	}
	
	
	
	
}
