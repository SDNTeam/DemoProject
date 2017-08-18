package icix.Tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.Modules.Request;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.TestData.TPGroupComplianceTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.TestBase;

public class TC9673_Test extends TestBase {


		FormList ObjForm=new FormList();
		Request ObjReq=new Request();
		LoginOut objLoginOut = new LoginOut();
		
 
		@Test(description="productTwoactor_workflow")
		public void productTwoactor_workflow(Method method) throws Exception {
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

			// logout responder
			objLoginOut.logout();

		}
	}


