package icix.Locators;

import org.openqa.selenium.By;

public class LoginOutRepo {

	public static By txtUsername = By.id("username");
	public static By txtPassword = By.id("password");
	public static By btnLogin = By.id("Login");
	public static By drpSwitchToLighteningById = By.id("userNavLabel");
	public static By drpSwitchToLighteningByXPath = By.xpath("//span[@id='userNavLabel']");
	public static By OptionSwitchToLightening = By.xpath(".//*[@id='userNav-menuItems']/a[4]");
	public static By appLauncherIcon = By.xpath("//div[@class='slds-icon-waffle']");
	public static By imgWaffle = By.xpath("//div[@class='slds-icon-waffle_container']");
	public static By imgProfile = By.xpath("//img[contains(@class,'profileTrigger')]");
	public static By imgProfileTrigger=By.xpath("//img[contains(@class,'profileTrigger')]");
	public static By lnkLogout=By.linkText("Log Out");

}