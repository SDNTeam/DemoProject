package icix.Locators;

import org.openqa.selenium.By;

public class FormListRepo {
	public static By lnkFormList=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'FormList')]");
    public static By searchInput=By.id("j_id0:form:searchInput");
    public static By searchButton=By.id("j_id0:form:searchButton");
    public static By unpublishbutton=By.xpath("//input[contains(@value,'unpublish')]");
    public static By deleteButton=By.xpath("//input[@value='delete']");
//  public static By btnNewForm=By.xpath("//input[@name='j_id0:form:j_id12']");
    public static By btnNewForm=By.xpath("//input[@name='j_id0:form:j_id12'][@value='New Form']");
    //public static By btnNewForm=By.xpath(".//*[@id='buttonsBlock']/input[1]");
    public static By drpContainerType=By.id("j_id0:form:containerBlock:containerNew:inputContainerType");
    public static By drpDisplaytype=By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:0:j_id85");
    
	public static By ButtonsBlock=By.id("buttonsBlock");
    
    public static By txtContainerName= By.id("j_id0:form:containerBlock:containerNew:inputContainerName");
    public static By drpContainerConType=By.id("j_id0:form:containerBlock:containerNew:inputContainerContainerType");
    public static  By chkFormType=By.id("j_id0:form:containerBlock:containerNew:inputContainerBestPracticeForm");
    public static By  btnCreateCon=By.id("j_id0:form:containerBlock:createContainer");
	public static By btnSaveCon=By.id("j_id0:form:buttonSave");
	public static By TabLayout=By.id("j_id0:form:tabLayout_lbl");
	public static By txtLayoutName=By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutName");
	public static String Layout_Name = "QA_Testlayout";
	public static By LayoutType=By.id("j_id0:form:layoutBlock:layoutNew:inputLayoutUiType");
	public static By btnCreateLayout=By.id("j_id0:form:layoutBlock:createLayout");
	public static By btnSaveLayout=By.id("j_id0:form:buttonSave");
	public static By tabTabs=By.id("j_id0:form:tabTabs_lbl");
	public static By btnCreateTab=By.id("j_id0:form:createTab");
	public static By btnSaveTab=By.id("j_id0:form:buttonSave");
	public static By tabSection=By.id("j_id0:form:tabSections_lbl");
	public static By btnGenerateServiceSection=By.id("j_id0:form:createServiceSection");
	public static By btnAddSection=By.xpath("//input[contains(@id,'createSection')]");
	public static By btnSaveSection=By.xpath("//input[@value='SAVE']");
	public static By tabQst=By.id("j_id0:form:tabLinkedQuestions_lbl");
	public static By txtQstName=By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionName");
	public static By txtAreaAns=By.xpath("//textarea[contains(@id,'inputQuestionQuestionText')]");
	public static By reqQuestion = By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionResponseRequired");
	public static By readOnlyQuest =By.id("j_id0:form:newElementWithQuestion:newElementBlock:inputElementReadOnly");
	public static By linkedLookup =By.id("j_id0:form:newElementWithQuestion:newElementBlock:inputElementLinkedQuestion_lkwgt");
	public static By answerType = By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionAnswerType");
	public static By optionListName =By.id( "j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionOptionListName");
	public static By ElementWithQuestion=By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:targetId:theImage");
	public static By btnAddQst=By.id("j_id0:form:newElementWithQuestion:addNewLinkedQuestion");
	public static By btnSaveAll=By.id("j_id0:form:buttonSave");
	public static By btnPublish=By.id("j_id0:form:buttonPublish");
    public static By editContainerName= By.id("j_id0_form_containerBlock_containerExist_outputContainerName_ilecell");// New Added R (06.02.17)
    public static By txtEditContainerName= By.id("j_id0_form_containerBlock_containerExist_outputContainerName");// New Added R (06.02.17)
    public static By editdrpContainerConType=By.id("j_id0_form_containerBlock_containerExist_outputContainerContainerType_ilecell");    
    public static By btnPreview=By.id("j_id0:form:buttonPreview");
    public static By frameFormList = By.tagName("iframe");
	
	//used in deleteForm()
	public static By btnUnPublishForm = By.xpath("//input[contains(@value,'unpublish')]");
	public static By btnDeleteForm = By.xpath("//input[@value='delete']");
	public static By txtSearchForm = By.id("j_id0:form:searchInput");
	public static By btnSearchForm = By.id("j_id0:form:searchButton");
	
    
}
