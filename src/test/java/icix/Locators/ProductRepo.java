package icix.Locators;

import org.openqa.selenium.By;

public class ProductRepo {
	// new Product for 3-ActorWF
		public static By lnkProductTestManager=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Product Test Manager')]");
		public static By lnkContainerTemplates=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Container Templates')]");
		public static By btnCreateNewTestProgram=By.xpath("//button[contains(.,'Create New Test Program')]");
		public static By txtBoxTestProgramName=By.id("programName");
		public static By btnProgramNameNext=By.xpath("//button[contains(.,'Next')]");
		public static By selectApprovedLabs=By.xpath("//span[contains(.,'feature06')]");
		public static By moveRight=By.xpath("//button[@title='Move right']");
		public static By btnCreateTProgram=By.xpath("//button[3][contains(text(),'Create')]");
		public static By btnAddNewCategory=By.xpath("//button[contains(.,'Add New Test Category')]");
		public static By txtBoxCategoryName=By.id("edit_category_name");
		public static By txtBoxTestClass=By.xpath("//*[@id='main']/div/form/slds-table/table/tbody/tr/td[1]/slds-lookup/div/div/div[1]/input");
		public static By txtBoxTestName=By.xpath("//*[@id='main']/div/form/slds-table/table/tbody/tr/td[2]/slds-lookup/div/div/div[1]/input");
		public static By dropDownTestType=By.xpath("//td[3]/select[@ng-model='row[field]']");
		public static By txtBoxTestMethod=By.xpath("//td[4]/input[@type='text']");
		public static By linkLimit=By.xpath("//*[@id='main']/div/form/slds-table/table/tbody/tr/td[6]/svg/use");
		public static By dropDownOperator=By.xpath("//*[@id='limitTable']/table/tbody/tr/td[2]/select");
		public static By txtboxValue=By.xpath("//input[@type='number']");
		public static By dropDownMeasure=By.xpath("//*[@id='limitTable']/table/tbody/tr/td[4]/select");
		public static By dropDownMessage=By.xpath("//*[@id='limitTable']/table/tbody/tr/td[6]/select");
		public static By btnAddTestLimit=By.xpath("//button[contains(.,'Add')]");
		public static By btnSaveCategory=By.xpath("//button[contains(.,'Save')]");
		public static By dropdownLimit=By.xpath("//button[@svg='utility']");
		public static By limti=By.xpath("//p[contains(.,'Add Limits')]");
		public static By productSearchResults=By.xpath("//tr[contains(@ng-repeat,'productSearchResult')]");

		// Product

		public static By linkProduct= By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'ICIX Products')]");
		public static By btnNewProduct=By.xpath("//div[@title='New']");
		public static By tbSearchTP=By.id("txt_SearchTermTradingPartner");
		public static By btnProductSearch=By.id("btnProductSearch");
		public static By btnCreateProduct=By.id("btnCreateProduct");
		public static By tbPName=By.id("ProductName");
		public static By btnNextProduct=By.id("btn_UPRelationship_Next");
		public static By tabPravacySettings=By.id("tab-ProductRelationship-3__item");
		public static By rbtnPublic= By.xpath("//span[contains(.,'Public')]");
		public static By btnSavePro=By.id ("btn_UPRelationship_Save");
		public static By popupClose= By.xpath("//button[@ng-click='vm.close()']");
		public static By searchBoxPName=By.id("txt_SearchTerm");
		public static By btnConnectToProduct=By.xpath("//button[contains(.,'Connect to Product')]");
		public static By tbRelationshipTPName=By.id("txt_UPTardingPartner_Name");
		public static By tabProductTest=By.id("tab-ProductRelationship-4__item");
		public static By radioBtnFinishedGood=By.xpath("//span[@class='slds-checkbox--faux']");
		public static By selectTP=By.xpath("//a[contains(.,'sdd3v06')]");
		public static By selectTPforProduct=By.xpath("//h3[contains(.,'Day-Based QA Testing 02 SD')]");
	    public static By verifyCreateProductMessage=By.xpath("//div[contains(text(),'New Product Relationship created successfully.')]");
	    public static By selectProgram=By.xpath("//span[contains(.,'New Testing Program 1/5/2017 6:24:48 PM')]");
	    public static By selectCategory=By.xpath("//span[contains(text(),'New Test Category 1/9/2017 2:43:06 PM')]");
	    public static By icixProductID=By.xpath("//div[contains(@arialabel,'ICIX Product ID - ')]/div/div[@class='itemBody']/div/span");

		//Container
		
		public static By statusbutton=By.xpath("//a[@aria-label='Status']");
	    public static By StatusDropdown=By.xpath("//a[@title='Published']");
	    public static By searchTestingProgram=By.xpath("//input[@placeholder='Search Testing Program']");
	    public static By btnSaveForm=By.xpath("//button[contains(@title,'Save')]");
	    public static By Status=By.xpath("//span[contains(text(),'Status')]/../following-sibling::div[@class='itemBody']");
	   

	    //v
	    
	    
	    
	    public static By lnkProductGroups = By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Product Groups')]");
		public static By btnNew = By.xpath("//div[@title='New']");
		public static By txtNameOfGroup = By.id("txtGroupName");
		public static By chkbxTag = By.xpath("//span[@class='slds-checkbox--faux']"); //have to be clicked by index
		public static By tabStatus = By.id("tab-scoped-1__item");
		public static By activeStatus = By.xpath("//span[@class='ng-binding'][contains(.,'Active')]");
		public static By inactiveStatus = By.xpath("//span[@class='ng-binding'][contains(.,'Inactive')]");
		public static By pendingStatus = By.xpath("//span[@class='ng-binding'][contains(.,'Pending')]");
		public static By suspendedStatus = By.xpath("//span[@class='ng-binding'][contains(.,'Suspended')]");
		
		public static By tabType = By.id("tab-scoped-2__item");
		public static By buyType = By.xpath("//span[@class='ng-binding'][contains(.,'Buy')]");
		public static By customerType = By.xpath("//span[@class='ng-binding'][contains(.,'Customer')]");
		public static By distributeType = By.xpath("//span[@class='ng-binding'][contains(.,'Distribute')]");
		public static By manufactureType = By.xpath("//span[@class='ng-binding'][contains(.,'Manufacture')]");
		public static By sellType = By.xpath("//span[@class='ng-binding'][contains(.,'Sell')]");
		
		public static By tabAttributes = By.id("tab-scoped-3__item");
		public static By drpDwnCountryOfOrigin = By.id("countryDropdwn0");
		public static By drpDwnImporterOfRecord = By.id("countryDropdwn1");
		
		public static By btnSaveProdGrp = By.xpath("//button[@text='Save']");
		
		public static By divProdGrpSuccessPopUp = By.xpath("//div[@class=' slds-m-around--medium']");
		public static By btnCloseSuccessPopUp = By.xpath("//button[@class='slds-button slds-button--brand'][contains(.,'Close')]");
		public static By successMessageProdGrp = By.xpath("//h2[@class='slds-text-heading--small ng-binding'][contains(.,'Group saved successfully.')]");
		
		public static By btnMoveRight = By.id("icnMoveRight");
		
		public static By divRelAttrFieldCount = By.xpath("//div[@class='slds-form-element slds-lookup ng-scope']");
		public static By frmNewProdGrp=By.tagName("iframe");
		public static By tabRelationshipTags = By.id("tab-ProductRelationship-1__item");
		public static By txtAddATag = By.id("txt_UPRelationship_Tag_New");
		public static By lnkAddATag = By.id("btn_UPRelationship_Tag_Add");
		public static By divRelTagTagName = By.xpath("//span[@class='slds-form-element__label ng-binding']");
	    
		
		
		//============ Abhay ================
		
		 public static By LinkProduct= By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Product Groups')]");
		    //public static By LinkProduct=By.linkText("Product Groups");
		    public static By iframe=By.tagName("iframe");
		    public static By txtgroup=By.xpath("//input[@id='txtGroupName']");
		    public static By ckeckbox=By.xpath("//span[@class='slds-checkbox--faux'][1]");
		public static By Editbutton=By.cssSelector("div[title=\"Edit\"]");
		public static By saveproductgroup=By.id("btnSave");
		public static By close=By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand");
		public static By tpDrop = By.xpath("//*[@id='s01']");
	public static By TxtUniversalValue =By.id("txt_product_UniversalId_Value0");
	
	
	//=============Pradeep 
	
	public static By lnkIcixProduct = By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'ICIX Products')]");
//	public static By btnNew = By.xpath("//a[@title='New']");
	public static By frame = By.tagName("iframe");
	public static By SearchTP = By.id("txt_SearchTermTradingPartner");
//	public static By tpDrop = By.xpath("//*[@id='s01']");
	public static By universalID = By.id("txt_SearchTerm");
	public static By btnSearch = By.id("btnProductSearch");
	public static By createPrdt = By.id("btnCreateProduct");
	public static By productName = By.xpath("//input[@id='ProductName']");
	public static By idsDrop = By.id("ddl_product_UniversalId_Type0");
	public static By idTxt = By.id("txt_product_UniversalId_Value0");
	public static By productDescrip = By.id("ProductDesc");
	public static By btnNext = By.id("btn_UPRelationship_Next");
	public static By btnSave = By.xpath("//button[@id='btn_UPRelationship_Save']");
	public static By relationTP = By.id("txt_UPTardingPartner_Name"); 
	public static By btnClose = By.xpath("//button[@ng-click='vm.close()']");
}
