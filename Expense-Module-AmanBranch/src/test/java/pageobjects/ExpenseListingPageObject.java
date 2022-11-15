package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExpenseListingPageObject extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static String datePattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;

	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;
	static String tripName;
	AddExpenseLimitPage addExpenseLimitPage;
	ProjectListingPage projectListingPage;

	public ExpenseListingPageObject(WebDriver driver) {
		super(driver, "Expense Listing Page");

		this.dateTime = new DateTime(driver);
		this.addExpenseLimitPage = new AddExpenseLimitPage(driver);
		this.projectListingPage = new ProjectListingPage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on expense
	public void clickExpenseSideMenu() {
		clickByJavascript(By.xpath("//li[@data-name='Expense ']//a//i//following::text()[1]//following::span[1]"),
				"Expense Side menu", 10);
	}

	// click on expense
	public void clickExpense() {
		click(By.xpath("//li[@id='menuitem9']//a"), "Expense", 20);
	}

	// click on expense listing
	public void clickExpenseListing() {
//		clickByJavascript(By.xpath("//div[@id='headingThree2' and @class='card-header']"), "Status", 10);
		clickByJavascript(By.xpath("//a[@data-original-title='Expenses']"), "expense listing", 10);
	}

	// click on project
	public void clickProject() {
		String projectname = ProjectListingPage.projectName;
//		clickByJavascript(By.xpath("//div[@id='headingOne1' and @class='card-header']"), "Project", 10);
		click(By.xpath("//a[@data-toggle='collapse']/span[text()='Project']/ancestor::h5/descendant::i[@class='fa fa-angle-down rotate-icon']"), "Expand project", 20);
		enter(By.xpath("//div[@class='input-group customsearchbox']/input[@type='text']"), projectname, "Project Name",
				20);
		/*clickByJavascript(
				By.xpath("//input[@class='custom-control-input dynamic projectId'][1]//following::label[text()='"
						+ ProjectListingPage.projectName + "']"),
				"Project" + ProjectListingPage.projectName, 10);
				*/
		staticWait(2000);
		click(By.xpath("//div[@class='custom-control w-100 custom-control-inline custom-checkbox']/label[text()='"+projectname+"']"), "Checkbox", 20);
		//clickByJavascript(By.xpath("//a[@data-original-title=' Search']"), "Search button", 10);
	}

	// click on status
	public void clickStatus() {
//		clickByJavascript(By.xpath("//div[@id='headingThree2' and @class='card-header']"), "Status", 10);
		click(By.xpath("//a[@data-toggle='collapse']/span[text()='Status']/ancestor::h5/descendant::i[@class='fa fa-angle-down rotate-icon']"), "Expand Status", 20);
		clickByJavascript(
				By.xpath("//div[@class='custom-control custom-radio']//following::label[text()='Approval Pending']"),
				"Approval Pending", 10);
	}

	// click on Date froma
	public void clickDateFrom() {
//		clickByJavascript(By.xpath("//div[@id='headingThree3' and @class='card-header']"), "Date From", 10);
		click(By.xpath("//a[@data-toggle='collapse']/span[text()='Date']/ancestor::h5/descendant::i[@class='fa fa-angle-down rotate-icon']"), "Expand Date", 20);
		  enter(By.xpath("//input[@name='DateFrom2']"), dateTime.datevalue,
		  "enter current Date" + dateTime.datevalue, 20);
		 
	}

	// click on Date To
	public void clickDateTo() {
//		clickByJavascript(By.xpath("//div[@id='headingThree4' and @class='card-header']"), "Date To", 10);
		enter(By.xpath("//input[@name='DateTo2']"), dateTime.datevalue, "enter current Date" + dateTime.datevalue,
				20);
	}

	// click on Search
	public void clickSearch() {
		//clickByJavascript(By.xpath("//a[@class='ancsearch collapsed']"), "Search", 10);
		clickByJavascript(By.xpath("//a[@data-original-title=' Search']"), "Search button", 10);
	}

	// click on all checkbox
	public void clickAllCheckbox() {
		clickByJavascript(By.cssSelector("#chkAll_0"), "All checkbox", 10);
	}

	// click on expand all
	public void clickExpandAll() {
		staticWait(3000);
		clickByJavascript(By.xpath("//span[@class='ancExpandAllCollapseAll']"), "Expand All", 10);
		clickByJavascript(By.xpath("//span[@class='ancExpandAllCollapseAll']"), "Collapse All", 10);
	}

	// verify Approval Pending button status
	public void getTextOfPendingStatus() {
		staticWait(3000);
		try {
			//String pendingText = getText(By.xpath("//table[@id='tblExpense']//tr[1]//td[10]//span"), 20);
			String pendingText = getText(By.xpath("//table[@id='tablelistingdata']//tr[1]//td[8]//span"), 20);
			if (pendingText.contains("Approval Pending")) {
				getTest().log(LogStatus.PASS, pendingText + "status is visible on expense listing screen");
				logger.info(pendingText + "Status is visible on expense listing screen");
			}
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "status is not visible on expense listing screen");
			logger.info("status is not visible on expense listing screen");
			takeScreenshot("status is not visible on expense listing screen");
			Assert.fail("Status is not visible on expense listing screen");
		}
	}

	public void getTextOfDraftStatus() {
		staticWait(3000);
		try {
			//String pendingText = getText(By.xpath("//table[@id='tblExpense']//tr[1]//td[10]//span"), 20);
			String pendingText = getText(By.xpath("//table[@id='tablelistingdata']//tr[1]//td[8]//span"), 20);
			if (pendingText.contains("Draft")) {
				getTest().log(LogStatus.PASS, pendingText + "status is visible on expense listing screen");
				logger.info(pendingText + "Status is visible on expense listing screen");
			}
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "status is not visible on expense listing screen");
			logger.info("status is not visible on expense listing screen");
			takeScreenshot("status is not visible on expense listing screen");
			Assert.fail("Status is not visible on expense listing screen");
		}
	}

	// Button visibilty
	public void checkButtonsVisibility() {
		toCheckElementIsDisplayed(By.xpath("//a/span[text()=' Add Expense']"), 20, "Add expense");
		toCheckElementIsDisplayed(By.xpath("//a/span[text()=' Send for Approval']"), 20, "Send for approval");
		toCheckElementIsDisplayed(By.xpath("//a/span[contains(text(),'Remove')]"), 20, "Remove");
	}

	// click and enter comment
	public void enterComment() {
		clickByJavascript(
				By.xpath("//td[@class='text-center mobile-action']//following::a[@data-original-title=' Comments(0)']"),
				"comment", 10);

		enter(null, otherDateValue, FILE_NAME, characterLength);
	}

	// click action button
	public void clickActionButton() {
//		findElementVisibility(By.xpath("//tbody//tr[1]//span[@class='actions mobileaction']"), 20);
//		clickByJavascript(By.xpath("//tbody//tr[1]//span[@class='actions mobileaction']"), "Action button.", 10);

		findElementVisibility(By.xpath("//table[@id='tablelistingdata']/tbody/tr/td/span[@class='actions mobileaction']"), 20);
		clickByJavascript(By.xpath("//table[@id='tablelistingdata']/tbody/tr/td/span[@class='actions mobileaction']"), "Action button.", 10);

	}

	// select first checkbox
	public void selectFirstCheckbox() {
		clickByJavascript(By.xpath("//tbody//tr[1]//td//div[@class='custom-control custom-checkbox']//input"),
				"First checkbox", 10);
	}

	// click Delete button
	public void removeExpense() {
		clickByJavascript(By.cssSelector("#DeleteMultiple"), "Delete expense", 10);
	}

	// click Ok button
	public void okButton() {
		clickByJavascript(By.xpath("//button[@class='btn btn-success formbtn widthhalf']"), "click Ok button", 10);
	}

	// view attachement tab
	public void attachmentTab() {
		clickByJavascript(By.xpath("//table[@id='tablelistingdata']/tbody/tr/td/span[@class='actions mobileaction']//span[@id='action-list']//a/span[text()='View Attached File(s)']"), "click Attachment tab", 10);
	}

	// view attachement tab
	public void getAttachmentText() {
		try {
			String attachmentFile = getText(
					By.xpath("//table[@id='table-openactivities-content']//tbody//tr//td[2]"),
					20);
			if (attachmentFile.contains("file-sample_100kB.doc")) {
				getTest().log(LogStatus.PASS, attachmentFile + "is attached with file name.");
				logger.info(attachmentFile + "is attached with file name.");
			}
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "File is not attached.");
			logger.info("File is not attached.");
			takeScreenshot("File is not attached.");
			Assert.fail("File is not attached.");
		}
	}

	// Download fileA
	public void clickDownloadFile() {
		clickByJavascript(By.xpath("//a[@title='Download File']"), "click Download File.", 10);
	}

	// verify download file
	public void verifyFileUpload() {
		//isFileDownloaded("C:\\Users\\rmahajan\\Downloads", "file-sample_100kB.doc");
		isFileDownloaded("C:\\Users\\aanand\\Downloads", "file-sample_100kB.doc");
	}

	// Send for approval
	public void clickSendForApproval() {

//		clickByJavascript(By.cssSelector("#chkAll_0"), "select all", 10);

		clickByJavascript(By.xpath("//tbody//tr[1]//td//a[@data-original-title='Send for Approval']"),
				"Send For approval", 10);

//		clickByJavascript(By.cssSelector("#aCommanApproval"), "Send For approval", 10);
	}

	// edit expense
	public void editExpense() {
		clickByJavascript(By.xpath("//tbody//tr[1]//td//a[@data-original-title='Edit Expense'][1]"), "Edit expense",
				10);
	}

	// expand All
	public void expandAll() {
		clickByJavascript(By.xpath("//*[@id='headingThree3']/h5/a[1]"), "Expand all", 10);
	}

	// verify expense searched
	public void verifyExpenseSearch() {
		String catogeryName = AddExpenseLimitPage.categoryNameWithDate;
		verifyActualExpectedValues(By.xpath("//table[@id='tablelistingdata']//td[3]"), catogeryName,
				"Catogery name" + catogeryName, 20);
	}

}