package icix.Modules;

import icix.Locators.RequestRepo;
import icix.Locators.TPGroupComplianceRepo;
import icix.Locators.TPGroupRepo;
import icix.Start.Start;
import icix.Utils.Common;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.WaitTool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import bsh.Console;


public class TPGroupCompliance {
	
	public void createTPG(String tpgName, String tpgTags[], String tpgStatus[],String tpgType[]) throws Exception {
		Common.openAppLauncher();
		Common.ClickElement(TPGroupComplianceRepo.tpgTab, 10);	
		Common.ClickElement(TPGroupComplianceRepo.tpgNewBtn, 10);
		
		Log.info("Adding new TP Group: " + tpgName);
		
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(TPGroupComplianceRepo.tpgName, tpgName, 10);	

		for(int t=0; t<tpgTags.length; t++){
//			System.out.println(tpgTags[t]);
			Common.ClickElement(By.xpath("//span[contains(.,'"+tpgTags[t]+"')]"),10);
		}
		Log.info("Tag added successfully in " + tpgName);
		TakeScreenshots.takescreenshotOnSuccess();
		
		if(tpgStatus.length>0){
			Common.ClickElement(TPGroupComplianceRepo.statusTab, 10);
			
			Thread.sleep(3000);
			for(int s=0; s<tpgStatus.length; s++){
				Common.ClickElement(By.xpath("//span[contains(.,'"+tpgStatus[s]+"')]"), 10);	
			}
			Common.ClickElement(TPGroupComplianceRepo.moveIconRight, 10);
			Log.info("Status added successfully in " + tpgName);
			TakeScreenshots.takescreenshotOnSuccess();

		}
		if(tpgType.length>0){
			Common.ClickElement(TPGroupComplianceRepo.typeTab, 10);
			
			for(int t=0; t<tpgType.length; t++){
				Common.ClickElement(By.xpath("//span[contains(.,'"+tpgType[t]+"')]"), 10);
			}
			
			List<WebElement> ar=Common.FindAllElements(TPGroupComplianceRepo.moveIconRight, 10);
			//It is finding 2 elements of same ID
			//driver.findElement(By.id("icnMoveRight")).click();
			//clicking the 2nd one
			ar.get(1).click();
			Thread.sleep(1000);
			Log.info("Type added successfully in " + tpgName);
			TakeScreenshots.takescreenshotOnSuccess();
		}
		Common.ClickElement(TPGroupComplianceRepo.tpgSave, 10);		
		Log.info("Saving " + tpgName);
		TakeScreenshots.takescreenshotOnSuccess();
		
//		String msg =Common.FindAnElement(TPGroupComplianceRepo.successMsg).getText();
//		Assert.assertTrue(msg.contains("Trading partner group has been created successfully"));
//		Common.ClickElement(TPGroupComplianceRepo.tpgPopupClose, 10);
		
		Common.SwitchToDefaultContent(5000);
		Common.clickPartialLinkText(tpgName, 20);
		Log.info("Opening TP Group " + tpgName);
		TakeScreenshots.takescreenshotOnSuccess();
		ConsoleLog.info("Opening TP Group " + tpgName);
		//Common.assertTrue(Common.getElementText(TPGroupComplianceRepo.tpgTitle, 20), tpgName);
	}
	
	// Set Requirements then save	
    public void SetRequirement(String requestType[], String formNames[],String saveOrSend) throws Exception {
	if(Common.FindAllElements(TPGroupComplianceRepo.showMoreActionsIcon,10).size()>0)
	{
		Common.ClickElement(TPGroupComplianceRepo.showMoreActionsIcon, 10);
		Log.info("Clicking on the down arrow to click set requirement.");
		TakeScreenshots.takescreenshotOnSuccess();
	}
	
	
	Common.ClickElement(TPGroupComplianceRepo.setReqBtn, 10);
	Log.info("Clicking on the down arrow to click set requirement.");
	
	Common.SwitchToFrame();
//	Common.switchFrame(TPGroupComplianceRepo.setReqmFrame, 10);
	for(int r=1; r<=formNames.length; r++){
		int id=r-1;
		int reqid=r+1;
		if(requestType.length==formNames.length){
			System.out.println(Start.getDriverInstance());
			new Select(Common.FindAnElement(By.id("RequestType"+id+""),10)).selectByVisibleText(requestType[id]);
			//new Select(driver.findElement(By.id("RequestType"+id+""))).selectByVisibleText(requestType[id]);
			
			Log.info("Selecting the Request type");
			TakeScreenshots.takescreenshotOnSuccess();
		}
		else{
			new Select(Common.FindAnElement(By.id("RequestType"+id+""),10)).selectByVisibleText("All");
			Log.info("Selecting All");
			TakeScreenshots.takescreenshotOnSuccess();
		}
		
		new Select(Common.FindAnElement(By.id("DocType"+id+""),10)).selectByVisibleText(formNames[id]);//formNames[id]);
		Log.info("Selecting the form: " + formNames);
		TakeScreenshots.takescreenshotOnSuccess();
		
		Common.selectDate(By.id(""+id+""), 10);
		Log.info("Selecting the due date for full filling the requirement.");
		TakeScreenshots.takescreenshotOnSuccess();

		Thread.sleep(5000);
		new Select(Common.FindAnElement(By.id("RequirementType"+id+""),10)).selectByVisibleText("Approval");
		Log.info("Selecting the Requirment as approval");
		TakeScreenshots.takescreenshotOnSuccess();
		if(r<formNames.length){
			// add new requirement
			Common.ClickElement(By.xpath("html/body/form/div["+reqid+"]/div[2]/button"), 10);
		}
	}
		Common.ClickElement(By.id(saveOrSend), 10);
		Log.info("Clicking on send button.");
		TakeScreenshots.takescreenshotOnSuccess();
	
	/*if(saveOrSend.equals("btnSave")){
	String saveMsg = driver.findElement(By.xpath(TPGroupCompRepo.reqSaveUpdateMsg)).getText();
	Assert.assertTrue(saveMsg.contains("Requirements updated successfully"));
	Thread.sleep(1000);
	}
	if(saveOrSend.equals("btnSend")){
		String sendMsg = driver.findElement(By.cssSelector(TPGroupCompRepo.reqSendMsg)).getText();
		Assert.assertTrue(sendMsg.contains("Request is sent for the following Requirements and Members of the Group"));
	}*/
		Common.ClickElement(TPGroupComplianceRepo.tpgPopupClose, 10);
		Common.SwitchToDefaultContent(3000);
	}
    
	

	public void assertAndDeleteReqs( boolean removeReqs, int assertReqsSize) throws InterruptedException {
			Common.ClickElement(TPGroupComplianceRepo.tpgRelated, 10);
			Common.ClickElement(TPGroupComplianceRepo.tpgCompLink, 10);
			/*List<WebElement> listInputs =Common.FindAllElements(TPGroupComplianceRepo.reqList,8000);
			
			System.out.println("Requirements Saved " +listInputs.size());
					
			if(assertReqsSize!=0){
			Assert.assertEquals(listInputs.size(), assertReqsSize);
				System.out.println("size");
			}

			// for remove reqs	
			if(removeReqs==true && listInputs.size()>0){
				for(int i=0; i<listInputs.size();i++){
					System.out.println("in to for loop");*/
			
			Common.RefreshPage(5000);
			Common.ClickElement(TPGroupComplianceRepo.reqList, 10);

			
					//Common.ClickElement(TPGroupComplianceRepo.reqList, 10);
					//WebElement element =Common.FindAnElement(TPGroupComplianceRepo.oneContent, 10);
					//if (element != null) {
						//element.findElement(TPGroupComplianceRepo.delete).click();
						//Common.ClickElement(TPGroupComplianceRepo.btnDeleteReq, 10);
					//}
					//else
					//{
						//throw new NullPointerException();
					//}
				}
			//}
		//}

		public void searchAnything(String tabName, String searchKeyWord) throws Exception {			
			Common.ClearAndSendKeys(TPGroupComplianceRepo.searchBox, searchKeyWord, 10);
			Common.sendKeys(TPGroupComplianceRepo.searchBox, Keys.ENTER, 10);
			Common.ClickElement(By.cssSelector(".buttonLabel"), 10);
			
			List<WebElement> allTabs=(List<WebElement>) Common.FindAllElements(By.xpath("//div[@id='allItemsList']//li//a"), 10);
			for(WebElement myTab:allTabs){
				if(myTab.getText().equals(tabName)){
					myTab.click();
					break;
				}
			}
			
			Common.ClickElement(By.partialLinkText(searchKeyWord), 10);
		}
		
		public void searchAnythingTest(String searchKeyWord, String TPRequestName) throws InterruptedException {
			WaitTool.waitForPageLoadToComplete(Start.getDriverInstance(), 20);
			Common.GlobalSearch("Workflows", searchKeyWord);
			Log.info("The " + searchKeyWord + " is searched.");
			Common.clickPartialLinkText(TPRequestName, 4000);
			TakeScreenshots.takescreenshotOnSuccess();
			
//			Common.ClearAndSendKeys(TPGroupComplianceRepo.searchBox, searchKeyWord, 10);
//			Common.sendKeys(TPGroupComplianceRepo.searchBox, Keys.ENTER, 10);
//			Common.ClickElement(By.cssSelector(".buttonLabel"), 10);
//			
//			List<WebElement> allTabs=(List<WebElement>) Common.FindAllElements(By.xpath("//div[@id='allItemsList']//li//a"), 10);
//			for(WebElement myTab:allTabs){
//				if(myTab.getText().equals(tabName)){
//					myTab.click();
//					break;
//				}
//			}	
//			Common.ClickElement(By.partialLinkText(searchKeyWord), 10);
		}

		public void assertReqWFnStatus(String ReqStatus,String wfStatus) throws InterruptedException {
			
			
			Common.assertText(By.xpath("//span[contains(.,'"+ReqStatus+"')]"), ReqStatus, 10);
			//Common.RefreshPage(5000);
			Common.ClickElement(TPGroupComplianceRepo.tpgRelated, 10);
			Common.assertText(By.xpath("//span[contains(.,'"+wfStatus+"')]"), wfStatus, 10);
			Thread.sleep(3000);
		}
		
		public void editTPG(String editTags[]) throws InterruptedException {
			Common.ClickElement(TPGroupComplianceRepo.editTPG, 50);
			Common.SwitchToFrame();
			for(int t=0; t<editTags.length; t++){
//				System.out.println(tpgTags[t]);
				Common.ClickElement(By.xpath("//span[contains(.,'"+editTags[t]+"')]"),10);
			}
			Common.ClickElement(TPGroupComplianceRepo.tpgSave, 60);
			/*String msg =Common.FindAnElement(TPGroupComplianceRepo.successMsg).getText();
			Common.ClickElement(TPGroupComplianceRepo.tpgPopupClose, 0);*/
			Common.SwitchToDefaultContent(3000);
		}
			
			
				
			
			
				
						// Set Requirements then save	
		
		
		
		public void submitRequest() throws Exception {
			Common.ClickElement(By.xpath("//span[contains(.,'Container')]/following::a[1]"), 10);
			Common.deleteCookies(5000);
			
			List<WebElement>showMore=(List<WebElement>)Common.FindAllElements(By.xpath("//span[@title='Show more actions for this record']"), 10);
			if(showMore.size()==2)
				showMore.get(1).click();
			else
				showMore.get(0).click();
			
			Common.ClickElement(By.xpath("//a[@title='Open Form']"), 10);
			List<WebElement> fl=Common.FindAllElements(RequestRepo.frmFrameNewRequest, 10);
			System.out.println("No of iframes"+fl.size());
			WebElement frames = Common.FindAnElement(RequestRepo.frmFrameNewRequest, 10);
			Common.SwitchToFrame(frames, 0);
			
			List<WebElement> allInputs = Common.FindAllElements(By.xpath("//div[@class='slds-form-element__control']//input"), 10);
			for(int f=1; f<=allInputs.size(); f++){
			Common.ClearAndSendKeys(By.xpath("(//div[@class='slds-form-element__control']//input)["+f+"]"), "QA Submit"+f, 10);	
			}
			Common.ClickElement(By.xpath("//button[contains(.,'Submit')]"), 10);
			Common.SwitchToDefaultContent(3000);	
		}
		
		
		public void approveOrRejectRequest(String approveOrReject)throws Exception {
			Common.deleteCookies(8000);
			Common.ClickElement((By.xpath("//span[@alt='Show more actions for this record']")), 10);
		    Common.ClickElement((By.xpath("//a[@title='"+approveOrReject+"']")), 10);
		    Common.SwitchToFrame();
			//Common.sendKeys(By.xpath("//textarea[@placeholder='Enter Comments ']"), "QA Test", 0);
			Common.ClearAndSendKeys(By.xpath("//textarea[@placeholder='Enter Comments ']"), "QA Test", 10);
			Common.ClickElement(By.xpath("//input[@value='Submit']"), 10);
		
		}

		// ========== Abhay 
		
		public void TPRelationshipChange(String TPGRelationName,String RelationshipType,String ChangeRelationship) throws InterruptedException {
			Common.ClickElement(TPGroupComplianceRepo.TradingPartnerRelationship, 10);
			Common.ClickElement(By.xpath("//a[contains(.,'"+TPGRelationName+"')]"), 10);
			Common.ClickElement(TPGroupComplianceRepo.editTPG, 10);
			Common.SwitchToFrame();
			Common.SelectDropdownText(TPGroupComplianceRepo.Relationshipdropdown, RelationshipType, 10);
			Common.ClickElement(TPGroupComplianceRepo.btnSavePro, 10);
			Common.ClickElement(TPGroupComplianceRepo.TpgRelationshipClose, 10);
			Common.SwitchToDefaultContent(3000);
			Common.ClickElement(TPGroupComplianceRepo.editTPG, 10);
			Common.SwitchToFrame();
			Common.SelectDropdownText(TPGroupComplianceRepo.Relationshipdropdown, ChangeRelationship, 10);
			Common.ClickElement(TPGroupComplianceRepo.btnSavePro, 10);
			Common.ClickElement(TPGroupComplianceRepo.TpgRelationshipClose, 10);
		}
		
		
		
		public void deleteRequirement(String TPGroupName) throws Exception{
//			Common.openAppLauncher();
			Common.GlobalSearch("Trading Partner Groups", TPGroupName);
//			Common.ClickLink(TPGroupName, 20);
			Common.clickPartialLinkText(TPGroupName, 5000);
			TakeScreenshots.takescreenshotOnSuccess();
			Common.ClickElement(TPGroupComplianceRepo.setReqBtn, 20);
			Log.info("Set requirement button for TP group " + TPGroupName + " is clicked.");
			Common.RefreshPage();
			Common.SwitchToFrame();
			Common.ClickElement(TPGroupComplianceRepo.delReqmIcon, 20);
			Log.info("Requirement for TP group " + TPGroupName + " is deleted.");
			Common.ClickElement(TPGroupComplianceRepo.btnSaveReqm, 20);
			Thread.sleep(4000);
			Log.info("TP group " + TPGroupName + " is clicked after deleting requirment.");
			Common.ClickElement(TPGroupComplianceRepo.btnCloseSuccessMsg, 20);
			Common.SwitchToDefaultContent(3000);
			Thread.sleep(4000);
		}
	}
	

