package icix.Tests;

//Scenario: Verify Trading partner search by using Trading partner Company Name

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import icix.Modules.Account;
import icix.Modules.LoginOut;
import icix.TestData.AccountTestData;
import icix.TestData.LoginOutTestData;
import icix.Utils.Common;
import icix.Utils.TestBase;

public class TC9648_Test extends TestBase {
	
	Account objAccount=new Account();
	LoginOut objLoginOut = new LoginOut();
	

	@Test(description="Verify Trading partner search by using Trading partner Company Name", groups="TP Search")
	public void SearchByCompanyName(Method method) throws Exception {
		
		//1. Add Description of the test
		//2. Log the Test start
		//3. Log Step Name
		//4. Verify current Steps
		
		logTestStep("Test started:" + method.getName());
		logTestStep("Log in to application");
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		logTestStep("Search TP with: "+ AccountTestData.SearchbyCompanyName);
		objAccount.searchTPBy(AccountTestData.SearchbyCompanyName);
		
		logTestStep("Verify Search" );
		objAccount.verifySearch();
		
		
	}

}
