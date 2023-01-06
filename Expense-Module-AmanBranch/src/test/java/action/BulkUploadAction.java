package action;

import org.openqa.selenium.WebDriver;

import pageobjects.BulkUploadPage;
import utils.WebBasePage;

public class BulkUploadAction extends WebBasePage {

	WebDriver driver;
	BulkUploadPage bulkUploadPage;

	public BulkUploadAction(WebDriver driver) {
		super(driver, "Bulk UploadPage");
		this.bulkUploadPage = new BulkUploadPage(driver);

		this.driver = driver;
	}

	// Bulk upload
	public void bulkUpload() {
		bulkUploadPage.clickFullMenu();
		bulkUploadPage.clickExpenseSideMenu();
		bulkUploadPage.clickBulkUpload();
		//bulkUploadPage.closeTourGuidePopup();

	}

	// check Bulk upload validation
	public void verifyUploadValidation() {
		bulkUploadPage.clickImport();
		bulkUploadPage.verifyBulkUploadValidation();
	}

	// check Bulk upload validation
	public void verifyDownloadFile() {

		bulkUploadPage.clickSampleDownloadFile();

	}

	// check Bulk upload validation
	public void verifyExpenseFile() {
//		bulkUploadPage.clickSampleUploadFile();
		bulkUploadPage.uploadDocument();
//		bulkUploadPage.clickImport();
	}

	public void importButton() {

		bulkUploadPage.clickImport();
	}

	public void clickExpenseLimitButton() {

		bulkUploadPage.validateExpenseList();
	}

	public void verifyFieldValidation() {

		bulkUploadPage.verifyValidationMessages();
	}

	public void excelFile() {

		bulkUploadPage.readExcelFile();
		//bulkUploadPage.validateExpenseList();
		
	}
	
}