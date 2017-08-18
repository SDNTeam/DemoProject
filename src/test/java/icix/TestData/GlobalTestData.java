package icix.TestData;

import java.util.Date;

public class GlobalTestData {
	
	static Date d = new Date(System.currentTimeMillis());	
	
	//public static String BrandLimitResult= "Fail";
	public static String BrandLimitResult="Pass";
	public static String ApprovedComments= "Comments to approve request";
	public static String TradingPartnerName= "Day-Based QA Testing 02 SD";
	public static String RegulatoryLimitResult="Fail";
	
	public static String RequestName="AutoTest"+ d;;
	
	

	//TC9647
		public static String country = "United States";
		public static String icixId = "112";
		
		//TC9653
		public static String relationshipType = "Agent";
		public static String relInfoCmnts = "This is a test comment";
		public static String tagName = "Tag "+ d;
		
		//TC9659
		public static String NameofProduct = "Product Test" + d;
		public static String ProductRelationshipWithTP = ""; 
		public static String ProgramName = "";

}
