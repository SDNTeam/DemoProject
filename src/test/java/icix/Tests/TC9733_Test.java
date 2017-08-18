package icix.Tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.ProductTestData;
import icix.TestData.RequestTestData;

import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

//Scenario: Verify Trading Partner two Actor Workflow Approve request

public class TC9733_Test extends TestBase{

	FormList ObjForm=new FormList();
	Request ObjReq=new Request();
	LoginOut objLoginOut = new LoginOut();

	@Test(description="Verify Trading Partner two Actor Workflow Approve request")
	public void Approve_Request(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());

		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		ObjForm.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
				FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
				FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
				FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
				FormListTestData.newFeature, FormListTestData.formNames);

		ObjReq.sendRequest(TPGroupComplianceTestData.RequestName, TPGroupComplianceTestData.selectTPTrue, TPGroupComplianceTestData.TradingPartnerName,
				TPGroupComplianceTestData.ProductName_null, TPGroupComplianceTestData.DocumentName, TPGroupComplianceTestData.SendRequestComments,FormListTestData.formNames[0]);
		objLoginOut.logout();
		objLoginOut.loginAs(LoginOutTestData.Responder);
		
		//Search request and submit back to requestor
		ObjReq.FillAndSubmit2ActorForm(TPGroupComplianceTestData.RequestName, TPGroupComplianceTestData.ContainerName, TPGroupComplianceTestData.AttentionComments, TPGroupComplianceTestData.TestingFacility);	

		//Logout from responder
		objLoginOut.logout();

		//Login with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		//Search request and approve
		ObjReq.ApproveRequest(RequestTestData.RequestName, RequestTestData.ApprovedComments);
		
		//Verify status
		//ObjReq.VerifyRequestStatus("Approved");
	}	

}

