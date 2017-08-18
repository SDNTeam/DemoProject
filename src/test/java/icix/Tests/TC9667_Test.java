package icix.Tests;

import java.lang.reflect.Method;
import icix.Modules.LoginOut;
import icix.Modules.Product;
import icix.TestData.LoginOutTestData;
import icix.TestData.ProductTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;
import org.testng.annotations.Test;

//Scenario: Verify Create a New Product Group

public class TC9667_Test extends TestBase{
	
	Product objProduct = new Product();
	LoginOut objLoginOut = new LoginOut();


	@Test(description="Verify Create a New Product Group")
	public void Productgroup(Method method) throws Exception {
		ConsoleLog.info("The Testcase name is :" + method.getName());
		
		// Login to the salesforce
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		objProduct.addProductGroup(ProductTestData.prodGrpName);
		
		Log.info("Product created");
//		objProduct.verifySuccessMessage();
	}

}
