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

public class ExpenseApprovalHistoryPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static String datePattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;
	ExpenseApprovalPage expenseApprovalPage;
	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;
	static String tripName;

	public ExpenseApprovalHistoryPage(WebDriver driver) {
		super(driver, "Expense Approval History Page");
		this.dateTime = new DateTime(driver);
		this.expenseApprovalPage = new ExpenseApprovalPage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// verify Approval status text
	//public void verifyApprovalHistoryStatus(String status) {
	public void verifyApprovalHistoryStatus() {
		try {
			String approvedstatus="Approved";
			String rejectstatus="Rejected";
			String getApprovalText = getText(
					By.xpath("//table[@class='table table-bordered mb-0']//tr[@class='medium-bar gray'][1]//td[9][1]"),
					20);
			if (getApprovalText.contains(approvedstatus)) {
				getTest().log(LogStatus.PASS, getApprovalText + " is visible as expected.");
				logger.info(getApprovalText + " is visible as expected.");

			} else if (getApprovalText.contains(rejectstatus)) {
				getTest().log(LogStatus.PASS, getApprovalText + " is visible as expected.");
				logger.info(getApprovalText + " is visible as expected.");
				
			}
			/*
			 * else { getTest().log(LogStatus.FAIL, "Error occurred. ");
			 * logger.info(getApprovalText + " Status Status is not visible as expected.");
			 * takeScreenshot(new Object() { }.getClass().getEnclosingMethod().getName());
			 * Assert.fail(getApprovalText + " Status is not visible as expected."); }
			 */
			
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "Error occurred. ");
			logger.info("Error occurred. " + e);
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
			Assert.fail("Status is not visible as expected.");
		}
	}
	

	// verify expemse approve status
	
	
	/*
	 * public void verifyApproveStatus() { 
	 * verifyApprovalHistoryStatus("Approved");
	 * }
	 */
	 
	 
	// navigate To approval history page
	public void navigateToApprovalHistoryPage() {
		
//	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs.get(0));
	    driver.get(expenseApprovalPage.getApprovalHistoryPage);
	}

	// verify reject status
	/*
	 * public void verifyRejectedStatus() { 
	 * verifyApprovalHistoryStatus("Rejected");
	 * }
	 */

	// click date from
	public void clickDateFrom() {
		click(By.xpath("//a[@aria-controls='collapseOne1']"), "date from", 20);
	}

	// enter date from
	public void enterDateFrom() {
		enter(By.xpath("//input[@id='datepicker2']"), dateTime.datevalue, "Date From " + dateTime.datevalue, 20);
	}

	// click date To
	public void clickDateTo() {
		click(By.xpath("//a[@aria-controls='collapseThree2']"), "date To", 20);
	}

	// enter date To
	public void enterDateTo() {
		enter(By.xpath("//div[@aria-labelledby='headingThree2']"), dateTime.datevalue,
				"Date From " + dateTime.datevalue, 20);
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
}
