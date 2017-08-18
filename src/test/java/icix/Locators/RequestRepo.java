package icix.Locators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import icix.Modules.Request;
import icix.TestData.RequestTestData;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RequestRepo {

	static Date objdate = new Date();
	static String selectDate = new SimpleDateFormat("dd").format(objdate);
	static int date1 = Integer.parseInt(selectDate);
	static int date2 = date1+1; 

	public static By lnkRequests=By.xpath("//span[@class='label slds-truncate slds-text-link'][starts-with(.,'Requests')]");
	public static By btnNewRequest=By.xpath("//div[@class='slds-truncate'][@title='New']");
	public static By frmFrameNewRequest=By.tagName("iframe");
	public static By txtRequestName=By.id("requestName");
//	public static By RdoBtnProduct=By.id("product");
	public static By RdoBtnProduct=By.xpath("//label[@for='product']");
	public static By txtProductName=By.id("productDropDown1");
	public static By OptEnteredProduct=By.id("s01");
	public static By btnSelectDocForm=By.cssSelector("button.slds-button.slds-button--neutral");
//	public static By lnkDocCategory=By.linkText("All");
	public static By lnkDocCategory=By.linkText("Form");
	public static By noDocFormfound = By.xpath("//div[@class='ng-binding']");
	public static By chooseDocFormIndex1 = By.xpath("//label[@class='slds-checkbox']");
	public static By divMainDivForDoc=By.xpath("//div[@ng-show='showCategoryModal']");
	public static By divSubDiv=By.xpath("//div[@class='ng-scope']");
	public static By lblDocCheckBox=By.xpath("//label[@class='slds-checkbox']");
	public static By btnAttach=By.cssSelector("div.slds-modal__footer.slds-modal__footer--directional > button.slds-button.slds-button--brand");
	public static By btnSaveOnPopup=By.xpath("//button[3]");
	public static By txtDueDate=By.id("dueDate");
	public static By tdPickCurrentDate = By.xpath("//span[contains(.,'"+date2+"')]");
	public static By tblCalender=By.xpath("//table[@class='datepicker__month']");
	public static By tdDueDays=By.tagName("td");
	public static By txtCommentsToSendRequest=By.id("comments");
	public static By showmore= By.xpath("//a[@title='Show more actions for this record']");
	public static By btnSendRequest=By.xpath("//button[contains(.,'Send')]");
	
	//public static By lnkWorkFlows=By.linkText("Workflows");
	public static By xpathWorkFlows=By.xpath("//a[@data-walkthrough-key='searchScopeSelector_false'][contains(text(),'Workflows')]"); //New Added By R
	public static By ArrowToOpenMenu=By.xpath("//a[@class='menuTrigger']"); // by responder
	public static By OptionToOpenForm=By.cssSelector("[role='menuitem'][title='Open Form']");
	
	public static By tabRelated = By.xpath("//span[@class='title'][contains(.,'Related')]");
	public static By lnkWorkflowName = By.xpath("//a[@class='textUnderline outputLookupLink slds-truncate forceOutputLookup'][contains(.,'" + RequestTestData.RequestName + "')]");
	public static By btnSubmitWorkflowPage = By.xpath("//div[@title='Submit'][starts-with(.,'Submit')]");
	public static By btnSubmitReqComfirmation = By.xpath("//button[@class='slds-button slds-button--neutral slds-button--brand'][contains(.,'Submit')]");
	public static By workflowStatus=By.xpath("//div[contains(@arialabel,'Status -')]/div/div[@class='itemBody']/div");

	
	
	//public static By txtAttention=By.xpath("//label[contains(.,'Attention')]/following::input[1]");
	public static By txtAttention=By.id("a0o36000001v18vAAA");
	public static By drpTestingFacility=By.id("pickList");
	public static By btnNext=By.xpath("//button[contains(text(),'Next')]");
	public static By btnFormSubmit=By.xpath("//button[contains(.,'Submit')]");
	//public static By btnFormSubmit=By.xpath("//*[@id='origin-main']/div[1]/div[2]/button[1]");
	public static By SpanLabName=By.xpath("//span[contains(text(),'feature06')]");
	public static By ArrowForOpenForm=By.xpath("//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix'][@title='Show more actions for this record']");
//			By.xpath("//span[@title='Show more actions for this record']"); // by lab
	public static By drpBrandLimitResult=By.xpath("//label[contains(.,'Brand Limit Result')]/following::select[1]");
	public static By btnLabFormClose=By.xpath("//button[@ng-click='vm.toggleModalWindow()']");
	public static By btnYes=By.xpath("//button[contains(.,'Yes')]");
	//public static By SpanWorkflowInstance=By.xpath("//span[contains(.,'Workflow Instance')]");
	public static By lnkWorkflowInstance=By.xpath("//span[contains(.,'Workflow Instance')]/following::a[1]");
	public static By anchorSubmitbyLab=By.cssSelector("[title='Submit']");	
	public static By popupBtnSubmitByLab=By.xpath("//button[contains(text(),'Submit')]");
	public static By lnkApproveOption=By.linkText("Approve");
	public static By txtApproveComments=By.id("txt_Comment");
	public static By btnSaveApprovedComments=By.id("btn_Save");
//	public static By SpanWorkFlowStatus=By.xpath("//span[contains(.,'Status')]/following::span[2]");
	public static By SpanWorkFlowStatusApprove=By.xpath("//div[@class='desktop full listItemBody forcePageBlockItem forcePageBlockItemView'][@arialabel='Status - Approved']");
	public static By SpanWorkFlowStatusOpen=By.xpath("//div[@class='desktop full listItemBody forcePageBlockItem forcePageBlockItemView'][@arialabel='Status - Open']");
	public static By SpanWorkFlowStatusCancelled=By.xpath("//div[@class='desktop full listItemBody forcePageBlockItem forcePageBlockItemView'][@arialabel='Status - Cancelled']");
	public static By SpanWorkFlowStatusClosed=By.xpath("//div[@class='desktop full listItemBody forcePageBlockItem forcePageBlockItemView'][@arialabel='Status - Closed']");
	// Added By rishu 27.12.16
	public static By tradingPartnerDropDown =By.id("tradingPartnerDropDown");
	
	//public static By SelectTradingPartner =By.xpath("//h3[contains(.,'TradingPartnerName')]");
	public static By lnkRejectOption=By.linkText("Reject");
	public static By txtRejectComments=By.xpath("//textarea[@placeholder='Enter Comments ']");
	public static By btnSubmit=By.xpath("//input[@value='Submit']");
	public static By formFormName=By.xpath("//input[@class='slds-input ng-pristine ng-valid ng-empty ng-valid-maxlength ng-valid-minlength ng-valid-is-valid ng-touched']");
	//public static By formFormName=By.id(".//*[@id='a0o36000001umsUAAQ']");
	//public static By Question=By.xpath("//input[@id='a0o36000001umt7AAA']");
	public static By Question=By.xpath("//input[contains(@type,'text')]");
	
	public static By TradingPartnerName =By.xpath("//span[contains(.,'StagingPKG02')]");
	//public static By TradingPartnerName=By.xpath("//h3[contains(.,'"+RequestTestData.TradingPartnerName+"')]");

	// Workflow Status 
	public static By wfStatusDropdown=By.xpath("//a[@aria-label='Status']");
	public static By requestComment=By.xpath("//span[contains(.,'Request is sent..')]");
	public static By wfName=By.xpath("//a[@title='Fail']");
	
	public static By btnSavewfStatus=By.xpath("//button[@title='Save']");
	public static By linkContainer=By.xpath("//a[contains(.,'Product Test Corrective Action Form')]");
	public static By drpRegulatoryLimitResult=By.xpath("//label[contains(.,'Regulatory Limit Result')]/following::select[1]");
	public static By wfStatus=By.xpath("//span[contains(.,'Rejected by Requestor')]");
	

	//Trading partner Group  Locators
	public static By tpgTab =By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Trading Partner Groups')]");
	public static By tpgNewBtn = By.cssSelector("div[title='New']");
	public static By tpgName = By.id("txtGroupName");
	public static By statusTab = By.xpath("//a[contains(.,'Status')]");
	public static By moveIconRight = By.xpath(".//*[@id='icnMoveRight']");
	public static By typeTab =  By.xpath("//a[contains(.,'Type')]");
	public static By tpgSave = By.xpath(".//*[@id='btnSave']");
	public static By successMsg =  By.xpath("//p[@class='ng-binding']");
	public static By tpgPopupClose = By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand");
	
	public static By reqRecentlyViewed = By.xpath("//span[@class='triggerLinkText selectedListView uiOutputText'][contains(.,'Recently Viewed')]");
	public static By reqViewAll = By.xpath("//span[@class=' virtualAutocompleteOptionText'][contains(.,'All')]");
	public static By btnRefreshListing = By.xpath("//button[@class='slds-button forceRefreshButton slds-button--icon-border uiButton'][@title='Refresh']");
	
	//for sendRequest() function
	public static By btnClose=By.xpath("//button[contains(@ng-click,'redirectToRequestListPage')]");
	public static By topRequestName=By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/th[1]/span/a");
	public static By refreshRequestList=By.xpath("//div[@class='active oneContent']/div/div/div/div/div/div/div/button[contains(@class,'forceRefreshButton')]");
	public static By MainDivForForm=By.xpath("//div[@ng-show='showCategoryModal']");
	public static By InnerDivForForm=By.xpath("//div[@class='ng-scope']");
	public static By chkForm=By.xpath("//label[@class='slds-checkbox']");
}






