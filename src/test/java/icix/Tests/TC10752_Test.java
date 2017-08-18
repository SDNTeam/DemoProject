package icix.Tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.TestData.TPGroupTestData;
import icix.Utils.Common;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.TestBase;

public class TC10752_Test extends TestBase{
	
	LoginOut objLoginOut = new LoginOut();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	FormList ObjFormList=new FormList();
	@Test(description="VerifySendReqAtRespSide")
	public  void VerifySendReqAtRespSide(Method method) throws Exception {
		ConsoleLog.info("The testcase name is :" + method.getName());
		
		//Login with requestor
			objLoginOut.loginAs(LoginOutTestData.Requestor);
			Log.info("Login sucessfully");
			
			ObjFormList.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
					FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
					FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
					FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
					FormListTestData.newFeature, FormListTestData.formNames);
		
	// Creating New Trading Partner Group with the combination of tag,status and Type
			ObjTP.createTPG(TPGroupComplianceTestData.tpgName, TPGroupComplianceTestData.tpgTagsQA, TPGroupComplianceTestData.tpgStatus, TPGroupComplianceTestData.tpgType);
		TakeScreenshots.takescreenshotOnSuccess();	
		Log.info("Trading partner Group Cretaed sucessfully");
		
		Common.RefreshPage(5000);
		// Set the Requirements then send
		ObjTP.SetRequirement(TPGroupComplianceTestData.requestType, FormListTestData.formNames, TPGroupComplianceTestData.buttoSend);
		Log.info("Requiremnt send Sucessfully");
		objLoginOut.logout();

		objLoginOut.loginAs(LoginOutTestData.Responder);
		Log.info("Login  As a Responder");
//		//Searched created Trading Partner Group
	
		//ObjTP.searchAnythingTest(FormListTestData.formNames[0], FormListTestData.tPRequestName);	
		Common.GlobalSearch("Requests", FormListTestData.formNames[0]);
		
		Log.info("Request send Sucessfully");
		
	}
}
