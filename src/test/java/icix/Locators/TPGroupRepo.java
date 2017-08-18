package icix.Locators;

import org.openqa.selenium.By;

public class TPGroupRepo {

    public static By tpgTab = By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]");
	public static By tpgNewBtn =By.cssSelector("div[title='New']");
	public static By tpgName =By.id("txtGroupName");
//	public static By tagName = "//span[contains(.,'GFSI Certified')]";
	public static By tpgSave = By.xpath(".//*[@id='btnSave']");
	public static By successMsg =By.xpath("//p[@class='ng-binding']");
	public static By tpgPopupClose =By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand");
	public static By statusTab =By.xpath("//a[contains(.,'Status')]");
//	public static By statusPending = "//span[contains(.,'Pending')]";
//	public static By statusActive = "//span[contains(.,'Active')]";
	public static By moveIconRight =By.xpath(".//*[@id='icnMoveRight']");
	public static By typeTab = By.xpath("//a[contains(.,'Type')]");
/*	public static By typeAgent = "//span[contains(.,'Agent')]";
	public static By typeBroker = "//span[contains(.,'Broker')]";
	public static By editTPG = "//a[@title='Edit']";*/
	
	// Global	
	public static By searchBox = By.xpath("//input[@title='Search Salesforce']");
	// Workflows
	public static By wfStatus = By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]");
	public static By ReqStatus =By.xpath( "//span[contains(.,'Closed')]");
				
	public static By editTPG =By.xpath("//a[@title='Edit']");

	// New Workflow locators (Rishu)23.12.16
	//public static By ReqStatusN ="//span[contains(.,'Closed')]";*/

	// Abhay 
				
	public static By TradingPartnerRelationship=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Relationships')]");
				
	public static By Relationshipdropdown=By.xpath("//select[@id='ddl_UURelationship_Type']");
	public static By btnSavePro=By.id ("btn_UPRelationship_Save");
	public static By TpgRelationshipClose=By.xpath("//button[contains(text(),'Close')]");
}
