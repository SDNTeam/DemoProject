package icix.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DocumentLibraryRepo {
	public static By linkDocument=By.xpath("//span[@class='label slds-truncate slds-text-link'][contains(.,'Document Library')]");
	public static By btnAddDocument=By.xpath("//a[contains(.,'Add a Document')]");
	public static By browseLink=By.id("browseLink");
	public static By btnSave = By.id("documentDialogSaveButton"); //By.xpath("//button[contains(.,'Save')]");

	public static By uploadButton=By.id("uploadButton");
	public static By btnShowMore = By.id("btn_ShowMore1");
//	public static By btnShowMore = By.xpath("//button[@id='btn_ShowMore1']");//By.id("btn_ShowMore1");

	public static By frame = By.tagName("iframe");
	public static By btnAddDoc = By.id("btn_AddDocument");
	public static By browse = By.xpath("//a[@id='browseLink']");
	public static By category = By.id("category");
	public static By btnUpload = By.id("uploadButton");
	public static By Sendlnk = By.xpath("//a[@id='link_Send1']");
	public static By ReqName = By.id("requestName");
	public static By Resipents = By.id("recipients");
	public static By ResipentDrop = By.xpath("//h3[@style='font-weight: bold;']");//By.xpath("//div[@class='slds-media__body']");
	public static By coment = By.id("comments");
	public static By btnSend = By.id("sendDialogSendButton");
	public static By tabClose = By.id("btn_errorDialogCloseButton");
	public static By  documentList=By.xpath("//table[@id='docTable']/tbody/tr");
	public static By  uploadedDocumentName=By.xpath("//table[@id='docTable']/tbody/tr[1]/td[2]/a");
}
