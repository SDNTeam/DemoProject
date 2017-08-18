package icix.Tests;

import java.lang.reflect.Method;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.TPGroupCompliance;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.TestData.TPGroupTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TakeScreenshots;
import icix.Utils.TestBase;

import org.testng.annotations.Test;

//Scenario - Verify user is able to create Trading Partner group with the combination of tag,status and Type

public class TC10467_Test extends TestBase{
	FormList ObjFormList = new FormList();
	TPGroupCompliance ObjTP=new TPGroupCompliance();
	LoginOut objLoginOut = new LoginOut();

	@Test(priority=1, description="Verify user is able to create Trading Partner group with the combination of tag,status and Type", groups="TP Group")
	public void TPG_RelationshipType(Method method) throws Exception {
		logTestStep("Test started:" + method.getName());
		
		//Login the application with requestor
		logTestStep("Log in to application"  );
		objLoginOut.loginAs(LoginOutTestData.Requestor);

		// Create a form
		logTestStep("Create a new form" );
		ObjFormList.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
				FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
				FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
				FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
				FormListTestData.newFeature, FormListTestData.formNames);


		// Create a Trading partner Group
		logTestStep("Create a Trading partner group" );
		ObjTP.createTPG(TPGroupComplianceTestData.tpgName, TPGroupComplianceTestData.tpgTagsQA, TPGroupComplianceTestData.tpgStatus, TPGroupComplianceTestData.tpgType);

		// Set the Requirements then send
		logTestStep("Set Requirements" );
		ObjTP.SetRequirement(TPGroupComplianceTestData.requestType, FormListTestData.formNames, TPGroupComplianceTestData.buttoSend);
	
		
	}
}	