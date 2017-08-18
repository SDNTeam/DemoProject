package icix.Tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import icix.Modules.LoginOut;
import icix.Modules.Product;
import icix.TestData.LoginOutTestData;
import icix.TestData.ProductTestData;
import icix.Utils.ConsoleLog;
import icix.Utils.Log;
import icix.Utils.TestBase;

//Scenario: Create Product Without Universal Id

public class TC10781_Test extends TestBase{
	
	Product objProduct = new Product();
	LoginOut objLoginOut = new LoginOut();
	
	@Test(description="Create Product Without Universal Id", groups="ICIX Products")
	public void CreateProductWithoutUID (Method method) throws Exception{
		
		logTestStep("Test Case Name is: "+method.getName());
		
		logTestStep("Log in to application");
		objLoginOut.loginAs(LoginOutTestData.Requestor);
		
		logTestStep("Create product Without UID");
		objProduct.ProductSearchWithoutUID(ProductTestData.selectTP,
				ProductTestData.ProductName,ProductTestData.id,ProductTestData.idtxt
				,ProductTestData.Description,ProductTestData.TradingPartner);
		
		
		

	}
	
}
