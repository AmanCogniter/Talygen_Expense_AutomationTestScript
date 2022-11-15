package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExpenseApprovalPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static String datePattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;
	ProjectListingPage projectListingPage;

	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;
	static String tripName;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	static String getApprovalHistoryPage;

	public ExpenseApprovalPage(WebDriver driver) {
		super(driver, "Expense Approval Page");
		this.dateTime = new DateTime(driver);
		this.projectListingPage = new ProjectListingPage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(1000);
		findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on Side menu
	public void clickExpenseSideMenu() {
		staticWait(1000);
		click(By.xpath("//li[@data-name='Expense ']/descendant::span[@class='fa  fa-angle-right gotosub']"),
				"Expense Side menu", 20);
	}

	// click on full menu
	public void clickExpenseApproval() {
		staticWait(1000);
		/*
		 * findElementInVisibility( By.
		 * xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Expense Approval']"
		 * ), 20);
		 */
		click(By.xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Expense Approval']"),
				"Expense Approval", 20);
	}

	// click on full menuA
	public void selectCheckbox() {
//		clickByJavascript(By.xpath("//table[@id='tblExpenseApproval']//tbody//tr[1]//td[1]//div//input"),
//				"Select checkbox", 20);

		clickByJavascript(By.cssSelector("#chkAll_0"), "Select checkbox", 20);
	}

	// click on Approve button
	public void approveButton() {
		clickByJavascript(By.cssSelector("#hlkApprove"), "Approve", 20);
	}

	// click on reject button
	public void rejectButton() {
		clickByJavascript(By.cssSelector("#hlkReject"), "Reject", 20);
	}

	// click on view history
	public void viewHistory() {
		clickByJavascript(By.xpath("//a[@class='view-history p-action-btn text-white']"), "View history", 20);
	}

	// enter Description
	public void enterDescription() {
		enter(By.cssSelector("#CommentDescription"), prop.getProperty("expApprovalDesc"),
				"Expense Approval Description.", 20);
	}

	// enter title
	public void enterTitle() {
		enter(By.cssSelector("#CommentTitle"), prop.getProperty("expApprovalTitle"), "Expense Approval Title.", 20);
	}

	// click on Post new comment
	public void postNewComment() {
		clickByJavascript(By.cssSelector("#aPostComment"), "Post new comment", 20);
	}

	// click on client Radio button
	public void clientRadio() {
		clickByJavascript(
				By.xpath("//div[@class='form-control pl-0 border-0']//following::div//following::input[@id='rdo_0']"),
				"Reimburse By Client", 20);
	}

	// click on company Radio button
	public void companyRadioButton() {
		clickByJavascript(
				By.xpath("//div[@class='form-control pl-0 border-0']//following::div//following::input[@id='rdo_1']"),
				"Reimburse By Company", 20);
	}

	// click on Submit Radio button
	public void clickSubmit() {
		clickByJavascript(By.cssSelector("#aSubmit"), "Submit Button", 20);
	}

	// click on Submit Radio button
	public void approveOkButton() {
		clickByJavascript(By.xpath("//button[@class='btn btn-success formbtn widthhalf']"), "Approve Ok Button", 20);
	}

	// click on Action button
	public void clickAction() {
		clickByJavascript(By.xpath("//*[@id='tblExpenseApproval']/tbody/tr[1]/td[9]/span/i"), "Action Button", 20);
	}

	// click on Date from buttona
	public void dateFrom() {
		clickByJavascript(By.xpath("//a[@aria-controls='collapseOne1']"), "Date from Button", 20);
	}

	// click on Date To button
	public void dateTo() {
		clickByJavascript(By.xpath("//a[@aria-controls='collapseThree2']"), "Date To Button", 20);
	}

	// click on Project
	public void project() {
		clickByJavascript(By.xpath("//a[@aria-controls='collapseThree3']"), "Project", 20);

	}

	// click on user
	public void user() {
		clickByJavascript(By.xpath("//a[@aria-controls='collapseThree4']"), "User", 20);
	}

	// click on showData
	public void showData() {
		clickByJavascript(By.xpath("//a[@aria-controls='collapseThree5']"), "Show Data", 20);
	}

	// select and search Project
	public void selectProject() {

		enter(By.xpath(
				"//div[@aria-labelledby='headingThree3']//input[@class='form-control searchcustomfilter border-right-0' and @placeholder='Search']"),
				ProjectListingPage.projectName, "project name " + ProjectListingPage.projectName, 20);

		click(By.xpath(
				"//a[@aria-controls='collapseThree3']//following::label[@class='custom-control-label' and text()='"
						+ ProjectListingPage.projectName + "']"),
				"projectName", 20);
	}

	// click on Search
	public void clickSearch() {
		clickByJavascript(By.xpath("//a[@class='ancsearch collapsed']"), "Search", 10);

	}

	// click on send for approval
	public void clickSendForApproval() {
		clickByJavascript(
				By.xpath("//table[@id='tblExpenseApproval']/tbody/tr[1]//span[contains(text(),'Send for Correction')]"),
				"Send for approval", 10);

	}

	// get Approval history Page Url
	public void approvalHistoryPage() {
		getApprovalHistoryPage = getCurrentUrl(driver.getCurrentUrl(), "Expense Approval History Page ");
	}

}
