package icix.TestData;

import icix.Tests.TC10752_Test;

import java.util.Date;

public class TPGroupComplianceTestData {

	static Date d = new Date(System.currentTimeMillis());
	//common test Data(Added By Trupti(03/04/2017)
	public static String requestTypeAll[] = {"All"};
	public static String formNames[] = {"Automation"+d};
	public static String buttonsave  = "btnSave"; // save or send reqs, supported values are btnSave and btnSend
	public static String buttoSend  = "btnSend";
	public static String tpgTags[] = {"lab"};  // Tag Names
	public static String tpgTagsOragnic[] = {"Organic"};
	public static String tpgTagsQA[] = {"QATag_1"};


	public static String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	public static String tpgType[] = {}; // tpg Relationship types
	public static String editTags[] = {"Kosher","QATag_1"};
	public static String tabName = "Requests"; // on which object you want to search 
	public static String searchKeyWord = "Automation"+d;; // Requirement
	public static String RequestName = "AutoTest"+ d;
	public static boolean selectTPTrue = true;
	public static String TradingPartnerName ="StagingPKG02"; 
	public static String ProductName_null = null;
	public static String DocumentName = "Automation"+d;
	public static String SendRequestComments = "Request Sent..";
	public static String ContainerName = "Automation Form"+d;
	public static String AttentionComments = "Request is submitted..";
	public static String TestingFacility = null;
	
	
	//Test data for TC9672
	public static String FormName_TC9672 = "BSE Statement";
	public static String[] formNames_TC9672 = {"Testing-Tr"};


	//"sdd3v06" Day Based QA02 "Day-Based QA Testing 02 SD";


	public static String SendRequestComments_TC9672 = "Test comment";

	public static String AttentionComments_TC9672 = "Request is sent..";
	
	
	//Test data for TC9666
	public static String tpgName = "VerifySendRequirement " +d; // Trading partner Group Name
	//public static String tpgTags[] = {"Organic"};  // Tag Names (New1) // Tag Names  for r3lqa03rk@icix.com
	//public static String tpgStatus[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	//ublic static String tpgType[] = {}; // tpg Relationship types
	public static String requestType[] = {"All"};
	public static String saveOrSend  = "btnSend"; // save or send reqs, supported values are btnSave and btnSend
	//public static String searchKeyWord ="Automation";
	
	//Test data for TC10799
	public static String tpgName_TC10799 = "AutoReqCreationAddTP " + d; // Trading partner Group Name
	
	


	
	
	public static String wfStatus_TC10799 = "Open"; // Workflow status, supported values are Closed, Open.
	public static String ReqStatus_TC10799 = "New"; // Request Status , Supported values are New,Approved, Rejected, Cancelled etc..
	 // Tpg tags for editing tpg
	

}
