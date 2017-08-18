package icix.Locators;

import org.openqa.selenium.By;

public class AccountRepo {
	 public static By linkAccount=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]");
	 public static By btnNew=By.xpath("//div[contains(@title,'New')]");
	 public static By linkAdvanceSearch=By.xpath("//a[contains(.,'Advanced Search')]");
	 public static By txtFieldICIXID=By.xpath("//input[@ng-model='avm.newPartner.icixId']");
	 public static By btnSearch=By.xpath("//button[contains(.,'Search')]");
	 public static By verifySearchResult=By.xpath("//h3[@ng-if='mvm.main.fetchedPartnerMatches']");
	 
	public static By tpName=By.id("companyName");
	public static By address=By.xpath("//input[@placeholder='Address1']");
	public static By city=By.xpath("//input[@placeholder='City/Town']");
	public static By state=By.xpath("//input[@placeholder='State/Province/Region']");
	public static By postalCode=By.xpath("//input[@placeholder='Postal Code']");
	
	
	
	// Vishal
	
	public static By lnkAccount = By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]");
	//public static By btnNew = By.xpath("//a[@title='New']");
	public static By lnkAdvanced = By.linkText("Advanced Search");
	public static By frameAccounts = By.tagName("iframe");
	public static By txtIcixId = By.xpath("//input[@type='text'][@ng-model='avm.newPartner.icixId']");
	public static By txtTradingPartnerName = By.id("companyName");
	//public static By btnSearch = By.xpath("//button[@class='slds-button slds-button--brand'][contains(.,'Search')]");
	public static By btnConnect = By.xpath("//button[@class='slds-button slds-button--brand slds-button--large ng-scope'][contains(.,'Connect')]");
	public static By drpDwnRelationshipType = By.id("ddl_UURelationship_Type");
	public static By txtComments = By.id("txt_UURelationship_Comment");
	public static By tabRelationshipTags = By.id("tab-PartnerRelationship-1__item");
	public static By lnkAddATag = By.id("btn_UURelationship_Tag_Add");
	public static By txtAddATag = By.id("txt_UURelationship_Tag_New");
	public static By btnSaveRelationship = By.id("btn_UPRelationship_Save");
	public static By btnConnected = By.xpath("//button[contains(.,'Connected')]");
	public static By divConnected = By.xpath("//div[@class='slds-col'][@style='margin-right: -20px;']");
	
	
	
	
	
	
}
