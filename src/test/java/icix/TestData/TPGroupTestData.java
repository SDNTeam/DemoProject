package icix.TestData;

import java.util.Date;

public class TPGroupTestData {

	static Date d = new Date(System.currentTimeMillis());
	
	//Common Data(Added by Trupti(03/04/2017)
	public static String tpgName = "TradinGpartnerGroup " + d; // Trading partner Group Name
	public static String tpgTagsOrganic[] = {"Organic"};  // Tag Names
	public static String tpgStatusActive[]= {"Active"}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	public static String tpgType[] = {"Agent","Broker"}; // tpg Relationship types

	public static String tpgName_TC10467 = "TPG_tag_status_and_Type " + d; // Trading partner Group Name
	public static String tpgStatusNull[]= {};
	public static String tpgTypeNull[]= {};
	public static String tpgTags[] = {""};  // Tag Names
	
	
	
	//Test data for TC10752
	public static String tpgName_TC10752 = "VerifySendReqAtRespSide " + d; // Trading partner Group Name
	public static String tpgTags_TC10752[] = {"Organic"};  // Tag Names
	public static String tpgStatus_TC10752[]= {}; // tpg Status, supported values are Active,Inactive,Pending and Suspended
	public static String tpgType_TC10752[] = {}; // tpg Relationship types
	public static String requestType_TC10752[] = {"All"};
	public static String saveOrSend_TC10752  = "btnSend"; // save or send reqs, supported values are btnSave and btnSend 
	public static String tabName_TC10752 = "Request";
	public static String formNames_TC10752[]= {"Automation"};
	public static String searchKeyWord_TC10752 = "Automation"; //Should be same as formName
}
