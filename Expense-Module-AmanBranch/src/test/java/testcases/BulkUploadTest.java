package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.BulkUploadAction;
import action.LoginAction;
import utils.WebTestBase;

public class BulkUploadTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyBulkUploadValidation() {
		test = getTest("TC_Bulk_upload_validation");
		new LoginAction(driver).logoutLogin();
		BulkUploadAction bulkUploadAction = new BulkUploadAction(driver);
		bulkUploadAction.bulkUpload();
		bulkUploadAction.verifyUploadValidation();
	}

	@Test(priority = 1)
	 public void verifyExpenseFileUpload() {
		test = getTest("TC_Bulk_upload_validation");
		new LoginAction(driver).logoutLogin();
		BulkUploadAction bulkUploadAction = new BulkUploadAction(driver);
		bulkUploadAction.bulkUpload();
		bulkUploadAction.verifyExpenseFile();
		bulkUploadAction.importButton();
		bulkUploadAction.excelFile();

	}

//	@Test(dependsOnMethods = "verifyExpenseFileUpload")
//	public void verifyFieldsValidation() {
//		test = getTest("TC_Bulk_upload_validation");
//		BulkUploadAction bulkUploadAction = new BulkUploadAction(driver);
//		bulkUploadAction.clickExpenseLimitButton();
//		bulkUploadAction.verifyFieldValidation();
//	}
}
