package icix.Locators;

import org.openqa.selenium.By;

public class TPGroupComplianceRepo {
	// tpg 	
			
	//public static By lnkRequests=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Requests')]");
	        public static By tpgTab = By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]");
			public static By tpgNewBtn =By.cssSelector("div[title='New']");
			public static By tpgName =By.id("txtGroupName");
		//	public static By tagName = "//span[contains(.,'GFSI Certified')]";
			public static By tpgSave = By.xpath("//button[contains(@text,'Save')]");
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
			public static By tpgTitle = By.xpath("//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']");

		// tpg compliance 	
			public static By showMoreActionsIcon =By.xpath("//a[@title='Show more actions for this record']");
			public static By setReqBtn =By.xpath("//a[@title='Set Requirements']");
			public static By tpgRelated =By.xpath("//span[contains(.,'Related')]");
			public static By tpgCompLink =By.xpath("//span[contains(.,'Trading Partner Group Requirements')]");
			//public static By reqList =By.xpath("//div/div[2]/div/div[3]/div/div/table/tbody/tr/th/span/a");
			public static By reqList =By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[4]/div/div/div[1]/table/tbody/tr/th/span/a");
			public static By showMore =By.xpath("//span[contains(@title,'Show more actions for this record')]");
			public static By oneContent =By.xpath("//div[@class='active oneContent']");
			public static By btnDeleteReq =By.xpath("//button[@title='Delete']");
			public static By delete =By.xpath(".//div[@title='Delete']");
			public static By setReqmFrame = By.tagName(("iframe"));
//			public static By delReqmIcon = By.xpath("//button[@class='slds-button slds-button--icon-bare slds-pill__remove ng-scope']");
			public static By delReqmIcon = By.xpath("html/body/form/div[1]/div[6]/button");
			public static By btnSaveReqm = By.id("btnSave");
			public static By btnCloseSuccessMsg = By.xpath("//button[@class='slds-button slds-button--brand'][contains(.,'Close')]");
			
		
		// Global	
			public static By searchBox = By.xpath("//input[@title='Search Salesforce']");
		
		// Workflows
			public static By wfStatus = By.xpath("//span[contains(.,'Workflow Status')]/following::span[2]");
			public static By ReqStatus =By.xpath( "//span[contains(.,'Closed')]");
			
			public static By editTPG =By.xpath("//a[@title='Edit']");
			
			// Abhay 
			
			public static By TradingPartnerRelationship=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Relationships')]");
			public static By Relationshipdropdown=By.xpath("//select[@id='ddl_UURelationship_Type']");
			public static By btnSavePro=By.id ("btn_UPRelationship_Save");
			public static By TpgRelationshipClose=By.xpath("//button[contains(text(),'Close')]");
			
			
//			public static By dueDate = By.xpath("//input[@class='slds-input slds-datepicker-input ng-pristine ng-valid ng-empty ng-touched'][@id='"++"'");
}
