package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.Common;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

import org.testng.annotations.Test;

//Scenario: Verify Create A New TP Request at requester and verify the request in Responder

public class TC9672_Test extends TestBase {

	FormList ObjForm = new FormList();
	TPGroupCompliance ObjTP = new TPGroupCompliance();
	Request ObjReq=new Request();
	LoginOut objLoginOut = new LoginOut();
	

	@Test(description="Verify Create A New TP Request at requester and verify the request in Responder")
	public void TwoActorWorkFlow(Method method) throws Exception {
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
		Common.GlobalSearch("Workflows", FormListTestData.formNames[0]);
		
		//ObjTP.searchAnythingTest(FormListTestData.formNames[0], FormListTestData.tPRequestName);	
		//Thread.sleep(4000);
				/*ObjReq.submitBackToRequestor(TPGroupComplianceTestData.RequestName, TPGroupComplianceTestData.ContainerName, 
				TPGroupComplianceTestData.AttentionComments, TPGroupComplianceTestData.TestingFacility);*/
	}

}