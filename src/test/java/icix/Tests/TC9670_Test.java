package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.FormList;
import icix.Modules.LoginOut;
import icix.TestData.FormListTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

//Scenario: Verify Create a New  From using form Builder

public class TC9670_Test extends TestBase{
	
	LoginOut objLoginOut = new LoginOut();
	FormList objFormList = new FormList();

	@Test(description="Verify Create a New  From using form Builder")
	public void createNew_form(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objFormList.createNewForm(FormListTestData.BPform, FormListTestData.NoOfTabs, FormListTestData.NoOfSections, FormListTestData.generateServiceSection, 
				FormListTestData.NoOfQuestions, FormListTestData.NoOfLinkedQuest, FormListTestData.NoOfReqQuest, FormListTestData.NoOfReadOnlyQuest,
				FormListTestData.ansType, FormListTestData.picklistVal, FormListTestData.MultiPickVal, 
				FormListTestData.NamenValue, FormListTestData.defaultVal, FormListTestData.dependencyValue, 
				FormListTestData.newFeature, FormListTestData.formNames);
		Log.info("Form created Sucessfully");
	}
}
