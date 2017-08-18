package icix.TestData;

import java.util.Date;

public class FormListTestData {
	
	static Date d = new Date(System.currentTimeMillis());
	//Common TestData Added by Trupti(03/04/2017)
	public static String[] formNames = {"Automation form "+d};
	public static String[] formName={"23","43"};
	public static String tPRequestName = formNames[0];
	
	public static boolean BPform = true; 
	public static int NoOfTabs = 1; 
	public static int NoOfSections = 1;
	public static boolean generateServiceSection = false;  
	public static int NoOfQuestions = 1;
	public static int NoOfLinkedQuest = 0; 
	public static int NoOfReqQuest = 0; 
	public static int NoOfReadOnlyQuest = 0; 
	public static String[] ansType = {"text"}; 
	public static String picklistVal = null; 
	public static String MultiPickVal = null; 
	public static String[][] NamenValue = {{},{}}; 
	public static String defaultVal = null;
	public static String dependencyValue = null; 
	public static String newFeature = null; 

	
	//public static String BrandLimitResult= "Fail";
	public static String BrandLimitResult="Pass";

	public static String RequestName="AutoTest "+d;
	
	public static String TradingPartnerName= "Day-Based QA Testing 02 SD";
	public static String RegulatoryLimitResult="Fail";
	
	public static String ProductName="Rk_Product test";
	public static String TestingFacility="feature06";
	public static String RejectComments="Comments to reject request";

	public static String DocumentNamefor2Actor= "Testing09";
	public static String ContaninerNamefor2Actor= "AutomationForm_01";
	
	//public static String formName[] = {"formsForAutomation"};
	public static String nameOfCopyForm = "NewFormsAutomation"+d;
	
	//TC9670

	public static int NoOfTabs_TC9670 = 1; 
	public static int NoOfSections_TC9670 = 1;
	public static boolean generateServiceSection_TC9670 = false;  
	public static int NoOfQuestions_TC9670 = 1;
	public static int NoOfLinkedQuest_TC9670 = 0; 
	public static int NoOfReqQuest_TC9670 = 0; 
	public static int NoOfReadOnlyQuest_TC9670 = 0; 
	public static String[] ansType_TC9670 = {"text"}; 
	public static String picklistVal_TC9670 = null; 
	public static String MultiPickVal_TC9670 = null; 
	public static String[][] NamenValue_TC9670 = {{},{}}; 
	public static String defaultVal_TC9670 = null;
	public static String dependencyValue_TC9670 = null; 
	public static String newFeature_TC9670 = null; 

	//
	
}
