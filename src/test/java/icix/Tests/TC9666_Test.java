package icix.Tests;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.Common;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

//Scenario: Verify User able to send the Requirements to the trading partner group Members

public class TC9666_Test extends TestBase {

	FormList ObjFormList = new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();

	@Test(priority=1, description="Verify User able to send the Requirements to the trading partner group Members")
	public void VerifySendRequirement(Method method) throws Exception {
		ConsoleLog.info("The testcase name is: " + method.getName());
		
		//Login the application with requestor
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		// Create a form
		ObjFormList.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
				FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
				FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
				FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
				FormListTestData.newFeature, FormListTestData.formNames);


		// Create a Trading partner Group
		ObjTP.createTPG(TPGroupComplianceTestData.tpgName, TPGroupComplianceTestData.tpgTagsQA, TPGroupComplianceTestData.tpgStatus, TPGroupComplianceTestData.tpgType);

		// Set the Requirements then send 		
		ObjTP.SetRequirement(TPGroupComplianceTestData.requestType, FormListTestData.formNames, TPGroupComplianceTestData.buttoSend);
//		
		objLoginOut.logout();
	
	//Login the application with responder
			objLoginOut.loginAs(LoginOutTestData.Responder);
			//ObjTP.searchAnything(TPGroupComplianceTestData.tabName, TPGroupComplianceTestData.searchKeyWord);
			Common.GlobalSearch("Workflows", FormListTestData.formNames[0]);
			//Common.GlobalSearch(TPGroupComplianceTestData.tabName, TPGroupComplianceTestData.searchKeyWord);
	}
	/*@Test(priority=2)
	public void VerifySendReqAtRespSide(Method method) throws Exception{
		TC10752_Test test=new TC10752_Test();
		test.VerifySendReqAtRespSide(method);
	}

	@Test(priority=3)
	public void VerifyRequestClosedAfterRemovingRequirement(Method method) throws Exception{
		TC10753_Test test=new TC10753_Test();
		test.VerifyRequestClosedAfterRemovingRequirement(method);
	}*/

}
