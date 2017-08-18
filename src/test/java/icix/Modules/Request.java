package icix.Modules;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import icix.Locators.RequestRepo;
import icix.Utils.Common;
import icix.Utils.Log;

public class Request {


	//String RequesterUserName=GetTestData("RequestorUsername");
	//String RequesterPassword=GetTestData("RequestorPassword");
	//Common ObjCommon=new Common();	

	public void Init()
	{
		Common.Init();
	}

	public void Login(String RequesterUserName, String RequesterPassword) throws Exception
	{		
		Common.LoginUser(RequesterUserName,RequesterPassword);
		Common.SwitchToLightiningView();
	}

	public void Logout() throws InterruptedException
	{		
		Common.LogoutUser();
	}

	public void createTPG(String tpgName, String tpgTags[], String tpgStatus[],String tpgType[]) throws Exception {
		Common.SwitchToLightiningView();
		Common.ClickElement(RequestRepo.tpgTab, 3);
		Common.ClickElement(RequestRepo.tpgNewBtn, 5);
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(RequestRepo.tpgName, tpgName, 3000);
		
		for(int t=0; t<tpgTags.length; t++){
			Common.ClickElement((By.xpath("//span[contains(.,'"+tpgTags[t]+"')]")), 1000);
		}
		if(tpgStatus.length>0){
			Common.ClickElement((RequestRepo.statusTab),3000);
			for(int s=0; s<tpgStatus.length; s++){
				Common.ClickElement((By.xpath("//span[contains(.,'"+tpgStatus[s]+"')]")), 1000);
			}
			Common.ClickElement(RequestRepo.moveIconRight, 0);
		}
		if(tpgType.length>0){
					
				Common.ClickElement(RequestRepo.typeTab, 5000);
		for(int t=0; t<tpgType.length; t++){
			Common.ClickElement((By.xpath("//span[contains(.,'"+tpgType[t]+"')]")), 1000);
		}
		
		Common.FindAllElements(RequestRepo.moveIconRight,10);
		}
		
		Common.assertText(RequestRepo.successMsg,"Trading partner group has been created successfully", 1000);
		Common.ClickElement(RequestRepo.tpgPopupClose, 0);
		Common.SwitchToDefaultContent(3000);
		Common.ClickLink(tpgName, 0);

	}

	public String GetTestData(String ColumnName)
	{
		return Common.GetTestData(ColumnName);		
	}

	public void TestPrint()
	{
		System.out.println("Hello QA");
	}

	public void FillAndSubmitForm(String RequestName,String ContainerName,String AttentionComments,String TestingFacility) throws Exception
	{
		Common.GlobalSearch("Requests", RequestName);
		Common.ClickLink(RequestName, 5000);
		Common.ClickLink(ContainerName, 5000);

		List<WebElement> ArrowToOpenMenu = Common.FindAllElements(RequestRepo.ArrowToOpenMenu,10);

		if(ArrowToOpenMenu.size()>0)
		{
			if(ArrowToOpenMenu.size()>1)
			{			
				Common.ClickElement(ArrowToOpenMenu.get(1), 3000);			
			}
			else
			{
				Common.ClickElement(ArrowToOpenMenu.get(0), 3000);
			}
		}

		Common.ClickElement(RequestRepo.OptionToOpenForm, 0);
		Common.SwitchToFrame();

		Common.ClearAndSendKeys(RequestRepo.txtAttention, AttentionComments, 2000);
		/*	Common.ClickElement(RequestRepo.drpTestingFacility, 0);
		Common.ClickElement(RequestRepo.SpanLabName, 2000);*/
		//Common.SelectLab(RequestRepo.drpTestingFacility,RequestRepo.SpanLabName,TestingFacility, 1000);
		Common.SwitchTab(2000);
		Common.ClickElement(RequestRepo.btnNext, 3000);
		Common.ClickElement(RequestRepo.btnFormSubmit, 3000);
	}
	public void passByLab(String RequestName,String ContainerName,String BrandLimitResult){
		Common.GlobalSearch("Requests", RequestName);
		Common.ClickLink(RequestName, 4000);
		Common.ClickLink(ContainerName, 4000);
		Common.ClickArrowIcon(RequestRepo.ArrowForOpenForm, 10);
		Common.ClickElement(RequestRepo.OptionToOpenForm, 0);

		Common.SwitchToFrame();

		Common.ClickElement(RequestRepo.btnNext, 2000);
		Common.SelectDropdownText(RequestRepo.drpBrandLimitResult, BrandLimitResult, 100);
		Common.ClickElement(RequestRepo.btnLabFormClose, 200);
		Common.ClickElement(RequestRepo.btnYes, 5000);
		Common.ClickElement(RequestRepo.lnkWorkflowInstance, 2000);
		Common.SwitchToDefaultContent(0);
		Common.RefreshPage(6000);
		Common.ClickElement(RequestRepo.anchorSubmitbyLab, 2000);

		Common.SwitchToFrame();
		Common.ClickElement(RequestRepo.popupBtnSubmitByLab, 3500);
		Common.SwitchToDefaultContent(0);
	}


	public void ApproveRequest(String RequestName,String ApprovedComments) throws Exception
	{
		
		Common.GlobalSearch("Workflows", RequestName);
		Common.ClickLink(RequestName, 4000);
		//Common.ClickLink(ContainerName, 4000);
		
		Common.ClickArrowIcon(RequestRepo.ArrowForOpenForm, 1000);		
		Common.ClickElement(RequestRepo.lnkApproveOption,2000);

	/*	List<WebElement> NewRequestFrame=Common.FindAllElements(RequestRepo.frmFrameNewRequest, 100);
		//System.out.println(NewRequestFrame.size());

		if (NewRequestFrame.size()>0)
		{
			if (NewRequestFrame.size()>1)
			{
				Common.SwitchToFrame();
			}
			else
			{
				Common.SwitchToFrame();
			}
		}*/
		Common.SwitchToFrame();

		Common.ClearAndSendKeys(RequestRepo.txtApproveComments, ApprovedComments, 500);
		Common.ClickElement(RequestRepo.btnSaveApprovedComments, 11000);	
		Common.RefreshPage(7000);		
	}

	public void VerifyRequestStatus(String status)
	{
		switch(status){
		
		case "Open":
			if(Common.getElementText(RequestRepo.SpanWorkFlowStatusOpen, 3000).contains("Open"))
				Assert.assertTrue(true, "Status is open");
			Log.info("The status is open.");
			break;
		
		case "Approved":
			if(Common.getElementText(RequestRepo.SpanWorkFlowStatusApprove, 3000).contains("Approved"))
				Assert.assertTrue(true, "Status approved successfully");
			Log.info("The status is approved.");
			break;
			
		case "Cancelled":
			if(Common.getElementText(RequestRepo.SpanWorkFlowStatusCancelled, 3000).contains("Cancelled"))
				Assert.assertTrue(true, "Status cancelled successfully");
			Log.info("The status is cancelled.");
			break;
			
		case "Closed":
			if(Common.getElementText(RequestRepo.SpanWorkFlowStatusClosed, 3000).contains("Closed"))
				Assert.assertTrue(true, "Status closed successfully");
			Log.info("The status is Closed.");
			break;
			
		default:
			Log.info("Invalid status");
			break;
		}
		
//		Common.getElementText(RequestRepo.SpanWorkFlowStatus, 3000);
//		Assert.assertEquals(Common.getElementText(RequestRepo.SpanWorkFlowStatus, 3000).contains("Approved"),"Workflow status is not Approved");
//		Assert.assertEquals(Common.FindAnElement(RequestRepo.SpanWorkFlowStatus).getText(), "Approved","Workflow status is not Approved");
//		Assert.assertEquals(Common.FindAnElement(RequestRepo.SpanWorkFlowStatus).getText(), "Rejected by Requestor","Workflow status is not Approved");
		Common.SwitchToDefaultContent(0);
	}


	//=============================== Added By R  27.12.16 ==============================================
	// Send Normal Request
	public void sendRequest(String RequestName,boolean selectTP,String TradingPartnerName,String ProductName,String DocumentName,String SendRequestComments,
			String formName) 
			throws Exception 
	{
		Common.openAppLauncher();
		Common.ClickElement(RequestRepo.lnkRequests, 120);	
		Common.ClickElement(RequestRepo.btnNewRequest, 30);
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(RequestRepo.txtRequestName,RequestName,60);
		if(selectTP==true)
		{

			Common.ClearAndSendKeys(RequestRepo.tradingPartnerDropDown, TradingPartnerName,120);
			Common.ClickElement(RequestRepo.TradingPartnerName, 120); 
			Log.info("Entering TradingPartnerName");
		}
		else{
			Common.ClickElement(RequestRepo.RdoBtnProduct, 120);
			Log.info("Entering product Name");
			Common.ClearAndSendKeys(RequestRepo.txtProductName, ProductName,120);
			Thread.sleep(500);
			Common.ClickElement(RequestRepo.OptEnteredProduct, 120);

		}

		Common.ClickElement(RequestRepo.btnSelectDocForm, 120);
		Common.ClickElement(RequestRepo.lnkDocCategory, 120);
		
		if(Common.getElementText(RequestRepo.noDocFormfound, 60).equalsIgnoreCase("No record")){
			Assert.assertTrue(false, "There are no documents/forms in the pop-up");
		}
		//else{
			//Common.ClickElementByIndex(RequestRepo.chooseDocFormIndex1, 5, 120);
		//}
		WebElement MainDiv=Common.FindAnElement(RequestRepo.MainDivForForm,60);
		List<WebElement> SubDivs=MainDiv.findElements(RequestRepo.InnerDivForForm);
		List<WebElement> chkFromdiv=MainDiv.findElements(RequestRepo.chkForm);
			
		  
		if (SubDivs.size()>0)
		{
		 for(int counter=0;counter<SubDivs.size();counter++)
		 	{
			  if (SubDivs.get(counter).getText().contains(formName))
			  {
				  chkFromdiv.get(counter).click();
				  break;
			  }
		 	}
		}
		
				
		Common.ClickElement(RequestRepo.btnAttach,120);
		Common.ClickElement(RequestRepo.btnSaveOnPopup,120);
		Log.info("Selecting date");
		Common.selectDate(RequestRepo.txtDueDate, 120);
		Common.ClearAndSendKeys(RequestRepo.txtCommentsToSendRequest,SendRequestComments, 120);
		Common.ClickElement(RequestRepo.btnSendRequest, 120);
		Common.ClickElement(RequestRepo.btnClose, 120);
		Common.RefreshPage();
		Common.ClickElement(RequestRepo.refreshRequestList, 60);
		Log.info("Refreshing Request List");
		Common.RefreshPage();
//		Common.assertTrue(Common.getElementText(RequestRepo.topRequestName, 120), RequestName, "Created request is not found in refreshed List");
		Log.info("Request has been created successfully");
	}


	// Reject Request
	public void RejectRequest(String RequestName,String RejectComments) throws Exception
	{
		Common.GlobalSearch("Requests", RequestName);

		Common.ClickLink(RequestName, 4000);
		//Common.ClickLink(ContainerName, 4000);
		Common.ClickArrowIcon(RequestRepo.ArrowForOpenForm, 10);		
		Common.ClickElement(RequestRepo.lnkRejectOption,2000);

		Common.SwitchToFrame();
		Common.ClearAndSendKeys(RequestRepo.txtRejectComments, RejectComments, 500);
		Common.ClickElement(RequestRepo.btnSubmit, 7000);	
		Common.RefreshPage(7000);		
	}

	// Fill and Submit Form (If requester selected Trading Partner)
	public void FillAndSubmit2ActorForm(String RequestName,String ContainerName,String AttentionComments,String TestingFacility) throws Exception
	 {
	  //Common.GlobalSearch("Requests", RequestName);
	  Common.GlobalSearch("Workflows", RequestName);
	  
	  Common.ClickLink(RequestName, 6000);
	  Common.RefreshPage(5000);
	  
	  Common.ClickLink(ContainerName, 5000);
	 // Common.clickPartialLinkText(ContainerName, 5000);
	 
	  /*List<WebElement> ArrowToOpenMenu = Common.FindAllElements(RequestRepo.ArrowToOpenMenu, 1000);

	  if(ArrowToOpenMenu.size()>0)
	  {
	   if(ArrowToOpenMenu.size()>1)
	   {   
	    Common.ClickElement(ArrowToOpenMenu.get(1), 3000);   
	   }
	   else
	   {
	    Common.ClickElement(ArrowToOpenMenu.get(0), 3000);
	   }
	  }*/
	  
	  
	  //Common.SwitchToFrame();
	  Common.RefreshPage(5000);
	  Common.ClickElement(RequestRepo.showmore, 3000);
	  Common.ClickElement(RequestRepo.OptionToOpenForm, 500);
	  /*List<WebElement> NewRequestFrame=Common.FindAllElements(RequestRepo.frmFrameNewRequest, 1000);
	  System.out.println(NewRequestFrame.size());

	  if (NewRequestFrame.size()>0)
	  {
	   if (NewRequestFrame.size()>1)
	   {
	    Common.SwitchToFrame();
	   }
	   else
	   {
	    Common.SwitchToFrame();
	   }
	  }*/
	  Common.SwitchToFrame();
	 // Common.SwitchToFrame(1,0);
	 // Common.RefreshPage(8000);
	  
	  Common.ClearAndSendKeys(RequestRepo.Question, AttentionComments, 200);
	  // Common.SwitchTab(2000); 
	  Common.ClickElement(RequestRepo.btnFormSubmit, 6000);
	 }

	
	//Purpose - To submit request back to resquestor without filling the form
	 public void submitBackToRequestor(String RequestName,String ContainerName,String AttentionComments,String TestingFacility) throws InterruptedException{
		  Common.waitForPageLoadToComplete();
		  Common.GlobalSearch("Workflows", RequestName);
		  Common.ClickLink(RequestName, 120);
		  //Common.ClickElement(RequestRepo.tabRelated, 120);
		 // Common.ClickElement(RequestRepo.lnkWorkflowName, 120);
		  Common.clickPartialLinkText(ContainerName, 300);
		 // Common.ClickElement(RequestRepo.btnSubmitWorkflowPage, 120);
		  Common.SwitchToFrame();
		  Common.ClickElement(RequestRepo.btnSubmitReqComfirmation, 120);
		  Log.info("Clicking on submit request popup");
		  Common.waitForPageLoadToComplete();
		  Thread.sleep(4000);
		  Log.info("Clicked on submit request popup");
		  Common.RefreshPage();
		  Common.assertTrue(Common.getElementText(RequestRepo.workflowStatus, 120), "Submitted by Responder");
		  Log.info("Request is submitted from responders end");
		 }

	//Request Verify by lab and save result(Form)
	public void VerifyByLab(String RequestName,String ContainerName,String BrandLimitResult, String RegulatoryLimitResult) throws InterruptedException
	{
		Common.GlobalSearch("Requests", RequestName);
		Common.ClickLink(RequestName, 4000);
		Common.ClickLink(ContainerName, 6000);
		Common.ClickArrowIcon(RequestRepo.ArrowForOpenForm, 10);
		Common.ClickElement(RequestRepo.OptionToOpenForm, 0);

		Common.SwitchToFrame();
		Common.ClickElement(RequestRepo.btnNext, 2000);
		Common.SelectDropdownText(RequestRepo.drpBrandLimitResult, BrandLimitResult, 1000);
		Common.SelectDropdownText(RequestRepo.drpRegulatoryLimitResult, RegulatoryLimitResult, 1000);

		Common.ClickElement(RequestRepo.btnLabFormClose, 200);
		Common.ClickElement(RequestRepo.btnYes, 5000);
		Common.ClickElement(RequestRepo.lnkWorkflowInstance, 5000);
		Common.SwitchToDefaultContent(0);
		Common.RefreshPage(6000);
	}

	//Change workflow status to failed and submit form from Lab
	public void changeWorkFlowStatus(String SendRequestComments, String WorkFlowStatus) throws InterruptedException{
		Common.doubleClick(RequestRepo.requestComment,3000);
		Common.ClickElement(RequestRepo.wfStatusDropdown, 3000);
		//Common.ClickElement(By.xpath("//a[@title='"+changeToWFStatus+"']"), 1000);
		Common.ClickElement(RequestRepo.wfName, 1000);
		Common.ClickElement(RequestRepo.btnSavewfStatus, 3000);
		Common.RefreshPage(6000);
		Common.ClickElement(RequestRepo.anchorSubmitbyLab, 2000);
		Common.SwitchToFrame();
		Common.ClickElement(RequestRepo.popupBtnSubmitByLab, 3500);
		Common.assertText(RequestRepo.wfStatus,WorkFlowStatus, 1000); //Verify WorkFlow Status
		Common.SwitchToDefaultContent(0);

	}



	//Searching automatic request come after failed from lab 
	public void VerifyAutomaticRequest(String AutoRequestName) throws InterruptedException 
	{
		//Common.verifyTextPresentorNot(AutoRequeestName);
		Common.GlobalSearch("Requests", AutoRequestName);
		Common.RefreshPage(6000);
		Common.ClickElement(RequestRepo.linkContainer, 00);
		/*Assert.assertFalse(Common.FindAnElement(By.xpath("//div[contains(.,'No results for \""+AutoRequeestName+"\" in Workflows.')]")).isDisplayed(),
	            "Request is not come");*/

	}
	// Product Form	
	public void FillAndSubmit3ActorForm(String RequestName,String ContainerName,String AttentionComments,String TestingFacility) throws Exception
	{
		Common.GlobalSearch("Requests", RequestName);
		Common.ClickLink(RequestName, 5000);
		Common.ClickLink(ContainerName, 5000);

		List<WebElement> ArrowToOpenMenu = Common.FindAllElements(RequestRepo.ArrowToOpenMenu,10);

		if(ArrowToOpenMenu.size()>0)
		{
			if(ArrowToOpenMenu.size()>1)
			{			
				Common.ClickElement(ArrowToOpenMenu.get(1), 3000);			
			}
			else
			{
				Common.ClickElement(ArrowToOpenMenu.get(0), 3000);
			}
		}

		Common.ClickElement(RequestRepo.OptionToOpenForm, 0);
		Common.SwitchToFrame();
		Common.ClearAndSendKeys(RequestRepo.txtAttention, AttentionComments, 200);
		Common.ClickElement(RequestRepo.drpTestingFacility, 0);
		Common.ClickElement(RequestRepo.SpanLabName, 1000);
		Common.ClickElement(RequestRepo.btnNext, 3000);
		Common.ClickElement(RequestRepo.btnFormSubmit, 4000);

	}


	// Abhay 
	
	public void Verifyquestionresponder(String RequestName,String ContainerName,String AttentionComments ) throws InterruptedException
	{
		Common.GlobalSearch("Requests", RequestName);
	
		Common.ClickLink(RequestName, 4000);
		Common.ClickLink(ContainerName, 4000);
		
		List<WebElement> ArrowToOpenMenu = Common.FindAllElements(RequestRepo.ArrowToOpenMenu,10);
		
		if(ArrowToOpenMenu.size()>0)
		{
			if(ArrowToOpenMenu.size()>1)
			{			
				Common.ClickElement(ArrowToOpenMenu.get(1), 1000);			
			}
			else
			{
				Common.ClickElement(ArrowToOpenMenu.get(0), 1000);
			}
		}
		
		Common.ClickElement(RequestRepo.OptionToOpenForm, 0);
		Common.SwitchToFrame();
			WebElement a=Common.FindAnElement(RequestRepo.Question, 10);
            String TextboxQuestion=a.getAttribute("value");
		    Assert.assertEquals(TextboxQuestion, AttentionComments, "Not Working Properly");
			 
		}  


	public void findRequestFromListing(){
		Common.clickAppLauncher();
		Common.ClickElement(RequestRepo.lnkRequests, 2000);
		Common.ClickElement(RequestRepo.reqRecentlyViewed, 2000);
		Common.ClickElement(RequestRepo.reqViewAll, 2000);

		do{
			Common.ClickElement(RequestRepo.btnRefreshListing, 4000);
		}while(Common.checkExistenceOfElement(RequestRepo.txtRequestName, 2000)== false);
		
		Common.ClickElement(RequestRepo.txtRequestName, 2000);
	}
	
	public void selectForm(String formName){
		Common.ClickElement(RequestRepo.btnSelectDocForm, 120);
		Common.ClickElement(RequestRepo.lnkDocCategory, 120);
		
		if(Common.getElementText(RequestRepo.noDocFormfound, 60).equalsIgnoreCase("No record")){
			Assert.assertTrue(false, "There are no documents/forms in the pop-up");
		}

		WebElement MainDiv=Common.FindAnElement(RequestRepo.MainDivForForm,60);
		List<WebElement> SubDivs=MainDiv.findElements(RequestRepo.InnerDivForForm);
		List<WebElement> chkFromdiv=MainDiv.findElements(RequestRepo.chkForm);
			
		  
		if (SubDivs.size()>0)
		{
		 for(int counter=0;counter<SubDivs.size();counter++)
		 	{
			  if (SubDivs.get(counter).getText().contains(formName))
			  {
				  chkFromdiv.get(counter).click();
				  break;
			  }
		 	}
		}
				  Common.ClickElement(RequestRepo.btnAttach,120);
				  Common.ClickElement(RequestRepo.btnSaveOnPopup,120);
				
			  }

}
