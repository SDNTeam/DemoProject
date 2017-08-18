package icix.Modules;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import icix.Locators.FormListRepo;
import icix.Locators.GlobalRepo;
import icix.Locators.RequestRepo;
import icix.Start.Start;
import icix.TestData.FormListTestData;
import icix.Utils.Common;
import icix.Utils.Log;

public class FormList {
	
	public static Date d;
	boolean BPform = true; // Best practice form or not?
	int NoOfTabs = 1; // No of Tabs
	int NoOfSections = 1; // No of sections in each tab
	boolean generateServiceSection = false; // generate Service Section
	int NoOfQuestions = 1; // No of Questions in each Section
	int NoOfLinkedQuest = 0; // No of Linked Questions
	int NoOfReqQuest = 0; // No of Mandatory fields Questions in Total questions
	int NoOfReadOnlyQuest = 0; // No of Read Only Questions in Total questions
	String ansType[] = { "text" }; // for different answer type, available types
	// text,checkbox, date,
	// datetime,multi-picklist,
	// number,picklist,long
	// text,upload,search,multi-search,radio,email
	// address
	String picklistVal; // If answer type is picklist then set values available
	// types
	// boolean,chemicals,countries,currencies,ingredients,microbiological,months
	String MultiPickVal; // If answer type is multi-picklist then set values
	// available types
	// boolean,chemicals,countries,currencies,ingredients,microbiological,months
	String NamenValue[][] = { {}, // add picklist or multi-picklist options --
			// add name here
			{} }; // // add picklist or multi-picklist options -- add Value here
	String defaultVal; // Select default value for picklist and multi-picklist
	String dependencyValue; // Select dependency value , It should be in
	// NamenValue list
	String newFeature; // it's created for feature purpose, now leave it.
	String formNames[] = { "AutomationForm" };
	
	 WebDriver driver;
	 
	 public FormList(){
		 this.driver=Start.getDriverInstance();
	 }

	public void searchAndCreateForm(String formNames[])
			throws Exception {
		try {
//			Common.ClickElement(FormListRepo.lnkFormList, 3000);
			deleteForm(formNames);
			newForm(formNames);
		} catch (Exception e) {
			newForm(formNames);
		}
	}

	public void searchForm(String formNames[]) throws Exception {
//		Common.SwitchToLightiningView();
		Common.clickAppLauncher();
		Common.ClickElement(FormListRepo.lnkFormList, 10);
		Common.SwitchToFrame();
		Common.ClearAndSendKey((By.id("j_id0:form:searchInput")), formNames, 10);
		Common.ClickElement((By.id("j_id0:form:searchButton")), 10);
		Common.ClearAndSendKey(FormListRepo.txtSearchForm, formNames, 10);
		Common.ClickElement(FormListRepo.btnSearchForm, 10);
	}

	// Delete form
	public void deleteForm(String formNames[])	throws Exception {

		searchForm(formNames);
		Common.ClickElement(FormListRepo.btnUnPublishForm, 20);
		Common.ClickElement(FormListRepo.btnDeleteForm, 10);
		Common.alert(3000);
		//	Common.SwitchToDefaultContent(2000);

	}

	public void newForm(String formNames[]) throws Exception {
		// Create Form
		createNewForm(BPform, NoOfTabs, NoOfSections, generateServiceSection,
				NoOfQuestions, NoOfLinkedQuest, NoOfReqQuest,
				NoOfReadOnlyQuest, ansType, picklistVal, MultiPickVal,
				NamenValue, defaultVal, dependencyValue, newFeature, formNames);
	}

	//Updated by Vishal Dhiman
	//Purpose - Broke the function into smaller functions
	public void createNewForm(boolean BPform, int NoOfTabs, int NoOfSections, boolean generateServiceSection, int NoOfQuestions, int NoOfLinkedQuest, int NoOfReqQuest, int NoOfReadOnlyQuest,
			String ansType[], String picklistVal, String MultiPickVal, String NamenValue[][], String defaultVal, String dependencyValue,
			String newFeature, String formNames[]) throws Exception {
		FormList objFormList = new FormList();

		Common.openAppLauncher();
		if(Common.checkExistenceOfElement(FormListRepo.lnkFormList, 10)==true)
			Common.ClickElement(FormListRepo.lnkFormList, 10);
		Log.info("FormList list is clicked");

		d = new Date(System.currentTimeMillis());
		Common.SwitchToFrame();
//	    WebElement btnBlock = (new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(By.id("buttonsBlock")));

		do{
			//WebElement we3= driver.findElement(By.xpath(ObjForm.btnNewForm));
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", we3);
			WebElement we3= Start.driver.findElement(By.xpath("//form/div[3]/input[1]"));
			((JavascriptExecutor)Start.driver).executeScript("arguments[0].click();", we3);
		}
		while (Common.FindAllElements(FormListRepo.btnNewForm,10).size() > 0);
		Log.info("New form button is clicked.");

		objFormList.addContainer(formNames);
		objFormList.addLayout();
		objFormList.addTab(NoOfTabs);
		objFormList.addSection(NoOfSections, generateServiceSection);
		objFormList.addQuestion(NoOfQuestions, NoOfLinkedQuest, NoOfReqQuest, NoOfReadOnlyQuest, ansType, picklistVal, MultiPickVal, NamenValue, defaultVal, dependencyValue,
				newFeature);
		

		WebElement we2 = Common.FindAnElement(FormListRepo.btnSaveAll, 10);
		Common.javascriptExecutor(we2, 6000);
		WebElement wePublish = Common.FindAnElement(FormListRepo.btnPublish, 10);
		Common.javascriptExecutor(wePublish, 10000);
		Common.SwitchToDefaultContent(5000);
	}

	public void copyAndEditForm() throws Exception{
		Common.SwitchToFrame();
		//	driver.switchTo().frame(0);
		Common.ClickElement(By.id("j_id0:form:buttonCancel"), 10);
		//driver.findElement(By.id("j_id0:form:buttonCancel")).click();
		Common.ClearAndSendKey(By.id("j_id0:form:searchInput"),formNames, 10);
		//driver.findElement(By.id("j_id0:form:searchInput")).sendKeys(formName);
		Common.ClickElement(By.id("j_id0:form:searchButton"), 10);
		//driver.findElement(By.id("j_id0:form:searchButton")).click();
		Common.ClickElement(By.id("j_id0:form:dataPageBlock:j_id44:0:j_id71"), 10);
		//driver.findElement(By.id("j_id0:form:dataPageBlock:j_id44:0:j_id71")).click();
		Common.ClickElement(By.id("j_id0:form:dataPageBlock:j_id44:0:j_id73"), 10);

		Common.doubleClick(FormListRepo.editContainerName, 10);
		/*Actions act = new Actions(driver);
				act.moveToElement(
						driver.findElement(By.xpath(ObjForm.txtContainerName)))
						.doubleClick().build().perform();
				Thread.sleep(3000);*/
		Common.ClearAndSendKeys(FormListRepo.txtEditContainerName, FormListTestData.nameOfCopyForm, 10);

		//Common.ClearAndSendKey(FormRepo.txtContainerName, nameOfCopyForm, 10);

		/*driver.findElement(By.xpath(ObjForm.txtContainerName)).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath(ObjForm.txtContainerName)).sendKeys(nameOfCopyForm);
				Thread.sleep(1000);*/
		Common.ClickElement(FormListRepo.editdrpContainerConType, 10);
		/*
				driver.findElement(By.id(ObjForm.drpContainerConType)).click();
				Thread.sleep(1000);*/

		WebElement weSave =Common.FindAnElement(FormListRepo.btnSaveAll, 10);
		Common.javascriptExecutor(weSave, 5000);

		Common.ClickElement(FormListRepo.btnPreview, 10);

		/*
				WebElement weSave = driver.findElement(By.id(ObjForm.btnSaveAll));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", weSave);
				Thread.sleep(5000);
				driver.findElement(By.id("j_id0:form:buttonPreview")).click();*/
	}

	//Added by Vishal Dhiman on 16/02/2017
	public void addContainer(String formNames[]) throws Exception{
		Common.ClickElement(FormListRepo.txtContainerName, 10);
		Common.ClearAndSendKey(FormListRepo.txtContainerName, formNames, 10);
		Log.info("Form name " +formNames+ " added.");
		Common.SelectDropdownText(FormListRepo.drpContainerConType, "Single Form", 0);

		Common.SelectDropdownText(FormListRepo.drpContainerType, "Form", 10);

		if (BPform == true) {
			Common.ClickElement(FormListRepo.chkFormType, 10);
		}
		Common.ClickElement(FormListRepo.btnCreateCon, 10);
		Common.ClickElement(FormListRepo.btnSaveCon, 10);
		Log.info("Container added successfully");
	}

	//Added by Vishal Dhiman on 16/02/2017
	public void addLayout() throws Exception{
//		Thread.sleep(4000);
		Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
		Common.ClickElement(FormListRepo.TabLayout, 20);
		Common.ClearAndSendKeys(FormListRepo.txtLayoutName, FormListRepo.Layout_Name + d, 10);
		Common.SelectDropdownText(FormListRepo.LayoutType, "desktop", 10);

		Common.ClickElement(FormListRepo.btnCreateLayout, 10);
		Log.info("Layout added successfully.");
	}
	
	//Added by Vishal Dhiman on 16/02/2017
	public void addTab(int NoOfTabs ) throws Exception{
		Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
		for (int t = 1; t <= NoOfTabs; t++) {
			int tabId = t - 1;
			Common.ClickElement(FormListRepo.tabTabs, 20);
			Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
			Common.ClickElement(FormListRepo.btnCreateTab, 20);
			Common.ClearAndSendKeys(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + tabId
							+ ":j_id47"), "QA Test Tab" + t, 20);
			Common.ClickElement(FormListRepo.btnSaveTab, 20);
			Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
			Common.ClickElement(
					By.id("j_id0:form:tabBlock:tabSection:tabTable:" + tabId
							+ ":selectTab"), 20);
			Log.info("Tab " +t+ " added successfully.");
		}
	}
	
	//Added by Vishal Dhiman on 16/02/2017
	public void addSection(int NoOfSections, boolean generateServiceSection) throws Exception{
		for (int s = 1; s <= NoOfSections; s++) {
			int sectionId = s - 1;
			Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
			Common.ClickElement(FormListRepo.tabSection, 20);
			if (generateServiceSection == true) {

				Common.ClickElement(FormListRepo.btnGenerateServiceSection,
						20);
			} else {
				Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
				Common.ClickElement(FormListRepo.btnAddSection, 20);
				Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
				Common.ClearAndSendKeys(By.id("j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ sectionId + ":j_id74"), "QA Test Section"
										+ s, 20);
				for (int counter = 1; counter <= 4; counter++) {
					Common.switchToActiveElementKeys(Keys.TAB, 20);
				}
				//Common.switchToActiveElementString("Card", 0);
				Common.SelectDropdownText(FormListRepo.drpDisplaytype, "Table", 5);

				Common.ClickElement(FormListRepo.btnSaveSection, 20);
				Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
				Common.ClickElement(
						By.xpath("//input[@id='j_id0:form:sectionBlock:sectionSection:sectionTable:"
								+ sectionId + ":selectSection']"), 20);
				Log.info("Section " +s+ " added successfully.");
			}
		}
	}
	
	//Added by Vishal Dhiman on 16/02/2017
	public void addQuestion(int NoOfQuestions, int NoOfLinkedQuest, int NoOfReqQuest, int NoOfReadOnlyQuest,
			String ansType[], String picklistVal, String MultiPickVal, String NamenValue[][], String defaultVal, String dependencyValue,
			String newFeature) throws Exception{
		Common.waitForElementTobeInvisible(GlobalRepo.imgWaitingLoader, 120);
		Common.ClickElement(FormListRepo.tabQst, 20);

		for (int q = 1; q <= NoOfQuestions; q++) {
			boolean flag1 = true;
			boolean flag2 = true;
			int linkedid = q - 1;

			Common.ClearAndSendKeys(FormListRepo.txtQstName, "QA " + q + d, 20);
			Common.ClearAndSendKeys(FormListRepo.txtAreaAns, "QA Test Question " + q + d, 20);
			// for Required questions
			if (q <= NoOfReqQuest) {
				Common.ClickElement(FormListRepo.reqQuestion, 20);
			}
			// for Read only Questions
			if (q > NoOfReqQuest
					&& q <= NoOfReadOnlyQuest + NoOfReqQuest) {

				Common.ClickElement(FormListRepo.readOnlyQuest, 20);
			}

			// for linked questions
			if (q % 2 == 0 && q <= (NoOfLinkedQuest * 2)) {

				Common.ClickElement(FormListRepo.linkedLookup, 20);
				String parentWindowHandler = Common.WindowHandle();
				for (String handle : Common.WindowHandles()) { //Changes here
					Common.SwitchToWindowHandle(handle);
				}

				Common.ClearAndSendKeys((By.id("lksrch")), "QA" + linkedid + d, 10);
				Common.ClickElement((By.name("go")), 20);
				Common.SwitchToDefaultContent(0);
				Common.SwitchToFrame();
			}

			// for pick list and multi picklist questions
			if (NoOfQuestions == ansType.length) {

				new Select(
						Common.FindAnElement(FormListRepo.answerType, 20))
				.selectByVisibleText(ansType[q - 1]);

				if (ansType[q - 1].contains("picklist")
						&& picklistVal != null) {
					new Select(
							Common.FindAnElement(FormListRepo.optionListName, 20)).selectByVisibleText(picklistVal);

				}
				if (ansType[q - 1].contains("multi-picklist")
						&& MultiPickVal != null) {
					new Select(
							Common.FindAnElement(FormListRepo.optionListName, 20)).selectByVisibleText(MultiPickVal);

				}
			} else {
				new Select(
						Common.FindAnElement(FormListRepo.answerType, 20))
				.selectByVisibleText(ansType[0]);

				if (ansType[0].contains("picklist")
						&& picklistVal != null) {
					new Select(
							Common.FindAnElement(FormListRepo.optionListName, 20))
					.selectByVisibleText(picklistVal);

				}
				if (ansType[0].contains("multi-picklist")
						&& MultiPickVal != null) {
					new Select(
							Common.FindAnElement(FormListRepo.optionListName, 20))
					.selectByVisibleText(MultiPickVal);

				}
			}

			// for Dependency value
			if (dependencyValue != null && q % 2 == 0) {

				if (flag1) {
					flag1 = false;
					Common.ClickElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:targetId:theImage"), 20);

					String parentWindowHandler = Common.WindowHandle();
					for (String handle : Common.WindowHandles()) {
						Common.SwitchToWindowHandle(handle);
					}
					Common.ClearAndSendKeys(By.id("j_id0:form:block:section:query"),"QA" + linkedid + d, 20);
					Common.ClickElement(By.cssSelector("input.btn[Value='Go']"),20);
					Common.ClickElement(By.id("j_id0:form:j_id7:j_id8:j_id9:0:j_id10"),20);

					Common.SwitchToWindowHandle(parentWindowHandler);
					Common.SwitchToFrame();
					new Select(Common.FindAnElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:inputQuestionDependencyAction"), 10))
					.selectByVisibleText("Show");
				}

			}
			// add Question button
			WebElement we1 = Common.FindAnElement(FormListRepo.btnAddQst, 20);
			Log.info("Quesion "+q+" added successfully.");
			Common.javascriptExecutor(we1, 3000);

			if (dependencyValue != null && q % 2 == 0) {
				if (flag2) {
					flag2 = false;
					WebElement weSelect = Common.FindAnElement(By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"
											+ (q - 1) + ":selectElement"), 20);
					Common.javascriptExecutor(weSelect, 6000);
					Common.ClickElement(FormListRepo.txtQstName, 20);
					for (int counter = 1; counter <= 6; counter++) {
						Common.switchToActiveElementKeys(Keys.TAB, 500);

					}
					Common.switchToActiveElementString(
							dependencyValue, 0);
					// Select drpValue=new
					// Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:j_id188")));
					// drpValue.selectByValue(dependencyValue);
					// new
					// Select(driver.findElement(By.id("j_id0:form:newElementWithQuestion:newQuestionBlock:j_id188"))).selectByVisibleText(dependencyValue);

					Common.ClickElement(By.id("j_id0:form:newElementWithQuestion:editNewLinkedQuestion"), 20);
					Common.ClickElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"), 20);

				}
			}

			// add picklist or multi picklist values
			if (NamenValue != null
					&& NoOfQuestions == ansType.length
					&& (ansType[q - 1].contains("picklist") || ansType[q - 1]
							.contains("multi-picklist"))) {
				// WebElement weSelect
				// =driver.findElement(By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"+(q-1)+":selectElement"));
				WebElement weSelect = Common.FindAnElement(By.id("j_id0:form:linkedQuestionsBlock:linkedQuestionsSection:linkedQuestionsTable:"
										+ (q - 1)
										+ ":selectElement"), 10);
				Common.javascriptExecutor(weSelect, 10);
				for (int c = 0; c < NamenValue.length;) {
					for (int j = 0; j < NamenValue[c].length; j++) {
						Common.ClickElement(By.id("j_id0:form:answerOptionBlock:createAnswerOption"), 10);

						Common.ClearAndSendKeys(By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
										+ j + ":j_id167"),
										NamenValue[c][j], 10);
						Common.ClearAndSendKeys(
								By.id("j_id0:form:answerOptionBlock:answerOptionSection:answerOptionTable:"
										+ j + ":j_id171"),
										NamenValue[c + 1][j], 10);

						// Select default value check box
						if (defaultVal != null
								&& defaultVal
								.equals(NamenValue[c + 1][j])) {
							Common.doubleClick(
									By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"
											+ j + "_j_id176_chkbox"),
											10);
							Common.ClickElement(
									By.id("j_id0_form_answerOptionBlock_answerOptionSection_answerOptionTable_"
											+ j + "_j_id176"), 10);

							Common.ClickElement(
									By.id("j_id0:form:answerOptionBlock:answerOptionSection"),
									10);

						}
					}
					WebElement weSave = Common.FindAnElement(FormListRepo.btnSaveAll, 10);
					Common.javascriptExecutor(weSave, 10);
					Common.ClickElement(By.id("j_id0:form:newElementWithQuestion:clearNewLinkedQuestion"), 10);

					break;
				}
			}
		}
	}
}
