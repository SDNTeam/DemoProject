package icix.TestData;

import java.util.Date;

public class ProductTestData {
	
	
	static Date d = new Date(System.currentTimeMillis());
	//Common Data Added By Trupti(05/04/2017)
	
	public static String selectTP = "StagingPKG02";
	public static String ProductName ="Product Testing";
	public static String id = "UPC";
	public static String idtxt = "1231231231";
	public static String univeralID = "111";

	public static String TradingPartner= "StagingPKG02";

	public static String Description = "Product Testing";
	public static String prodGrpName="Automation Product Group " + d;
	public static String TpgTagsName="QA"+d;
	
	
	
	
	public static String NameofProduct= ("TestProduct")+d;
	public static String CategoryName="TestCategory";
	
	
	public static String TestClass="4.15 (ASTM F963-11), Stability and Overlo";
	public static String TestName="Decabromodiphenyl ether (DecaBDE)";
	public static String TestType="Quantitative";
	public static String TestMethodName="Test Method";
	public static String Operator="<=";
	public static String Value="3";
	public static String Measure="%";
	public static String Message="Fail";

	public static String ProductRelationshipWithTP="Day-Based QA Testing 02 SD";
	public static String FormName="Product Test Form 1/4/2017 3:20 AM";
	public static String SearchProductForTradingPartner= "Day-Based QA Testing 03 SD";
	
	//S
	public static String RequestName="AutoTest"+d;
	public static String TradingPartnerName= " sdd3v06";
	//public static String ProductName="Rk_Product test";
	
	public static String DocumentName="Product Test Form 1/24/2017 4:42 AM";
	public static String SendRequestComments= "Request is sent..";
	public static String ContaninerName="Product Test Form 1/24/2017 4:42 AM";
	public static String AttentionComments="Attention Comments From Responder";
	public static String ApprovedComments= "Comments to approve request";
	
	//TC10781	
	
	public static String univeralID_TC10781 = "111";
	

	
	
	//TC10782	
	public static String selectTP_TC10782 = "Day-Based QA Testing 03 SD";
	
	public static String ProductName_TC10782 = "New Automation Testing";
	public static String id_TC10782 = "UPC";
	public static String idtxt_TC10782 = "1231231231";
	public static String Description_TC10782 = "Automation Testing";
	public static String TradingpRel_TC10782= "Automation Testing";

	//TC9667
	public static String productGroupName = "Automation Product Group " + d;


}
