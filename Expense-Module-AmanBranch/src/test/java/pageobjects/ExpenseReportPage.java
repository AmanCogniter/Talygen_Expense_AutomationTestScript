package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExpenseReportPage extends WebBasePage {

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
	AddExpenseLimitPage addExpenseLimitPage;
	ManageExpensePage manageExpensePage;
 	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;
	static String tripName;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	static String getApprovalHistoryPage;
	static String maxAddExpAmount;
	static String maxLimitExpenseAmount;
	static String recordCount;

	public ExpenseReportPage(WebDriver driver) {
		super(driver, "Expense Report Page");
		this.dateTime = new DateTime(driver);
		this.projectListingPage = new ProjectListingPage(driver);
		this.addExpenseLimitPage = new AddExpenseLimitPage(driver);
		this.manageExpensePage = new ManageExpensePage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on Side menu
	public void clickExpenseSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Expense ']/descendant::span[@class='fa  fa-angle-right gotosub']"),
				"Expense Side menu", 20);
	}

	// click on expense Report
	public void clickExpenseReport() {
		staticWait(3000);
		click(By.xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Expense Report']"),
				"Click on expense Report", 20);
	}

	// click on expense Report tab
	public void clickExpenseReportTab() {
		click(By.cssSelector("#aExpenseReport"), "Click on expense Report tab", 20);
	}

	// Select project
	public void selectProject() {
		click(By.xpath("//label[text()='Project:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

		enter(By.xpath("//label[text()='Project:']//following::input[@class='form-control multiselect-search'][1]"),
				projectListingPage.projectName, "Enter project", 20);
		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[contains(text(),' "
						+ projectListingPage.projectName + "')]"),
				"select projectName.", 20);

	}

	// Select category
	public void selectCategory() {
		click(By.xpath("//label[text()='Category:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

		enter(By.xpath("//label[text()='Category:']//following::input[@class='form-control multiselect-search'][1]"),
				addExpenseLimitPage.categoryNameWithDate, "Enter project", 20);

		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[contains(text(),' "
						+ addExpenseLimitPage.categoryNameWithDate + "')]"),
				"select Ctegory from excel", 20);

	}

	// Select trip
	public void selectTrip() {
		click(By.xpath("//label[text()='Trip:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

		enter(By.xpath("//label[text()='Trip:']//following::input[@class='form-control multiselect-search'][1]"),
				manageExpensePage.tripName, "Enter project", 20);

		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[contains(text(),' "
						+ manageExpensePage.tripName + "')]"),
				"select Ctegory from excel", 20);

	}

	// Select user
	public void selectUser() {
		click(By.xpath("//label[text()='User:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

//		enter(By.xpath("//label[text()='User:']//following::input[@class='form-control multiselect-search'][1]"), "",
//				"Enter project", 20);

		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[text()='  Select all']"),
				"select trip from excel", 20);

	}

	// Select Approver
	public void selectApprover() {
		click(By.xpath("//label[text()='The Approver:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

//		enter(By.xpath("//label[text()='Approver:']//following::input[@class='form-control multiselect-search'][1]"),
//				"", "Enter project", 20);

		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[text()='  Select all']"),
				"select trip from excel", 20);

	}

	// Select status
	public void selectStatus() {
		click(By.xpath("//label[text()='Status:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

//		enter(By.xpath("//label[text()='Status:']//following::input[@class='form-control multiselect-search'][1]"), "",
//				"Enter project", 20);

		clickByJavascript(
				By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[text()=' Approval Pending']"),
				"select trip from excel", 20);

	}

	// enter title
	public void enterTitle() {
		enter(By.cssSelector("#ExpenseTitle"), "", "Enter title", 20);

	}

	// click on Start end Date
	public void selectStartEndDate() {
		click(By.xpath("//div[@class='input-group-append' and @data-target='#datepicker2']"), "Click on Start date.",
				20);
		click(By.xpath("//div[@class='input-group-append' and @data-target='#datepicker3']"), "Click on end date.", 20);

	}

	// click on project
	public void clickProject() {
		click(By.xpath("//label[@class='form-check-label' and @for='Project']"), "Project radio button.", 20);
	}

	// click on category
	public void clickCategory() {
		click(By.xpath("//label[@class='form-check-label' and @for='Category']"), "Category radio button.", 20);
	}

	// click on Trip
	public void clickTrip() {
		click(By.xpath("//label[@class='form-check-label' and @for='Trip']"), "Trip radio button.", 20);
	}

	// click on Search
	public void clickSearch() {
		click(By.cssSelector("#aSearch"), "Search button.", 20);
	}

	// get Total Record Count
	public void getTotalRecordCount() {
		try {
			//WebElement element = findElementPresence(By.xpath("//tr[@valign='top'][2]/td[8]/div"), 20);
			WebElement element = findElementPresence(By.xpath("//div[@id='viewer_pageviewContainer']"), 20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("arguments[0].scrollIntoView();", element);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			switchToFrame();
			logger.info("Switch to reports frame");
			staticWait(4000);
			//click(By.xpath("//tr[@valign='top'][2]/td[@style='HEIGHT:5.33mm']//following::a"), "plus icon", 20);
			click(By.xpath("//li[@id='viewer_toolbar_li_zoomin']"), "plus icon", 20);

			//recordCount = gettextByJSexecuter(By.xpath("//tr[@valign='top'][2]/td[8]/div"), "Total Records count", 20);
			recordCount = gettextByJSexecuter(By.xpath("//div[@id='viewer_table1']"), "Total Records count", 20);

			logger.info("Total record count from detail Report :: " + recordCount);

			maxLimitExpenseAmount = ManageExpensePage.expAmount;

//			float a = Float.parseFloat(maxAddExpAmount);
			float b = Float.parseFloat(maxLimitExpenseAmount);
//			float c = b - a;
			float e = Float.parseFloat(recordCount);
			String d = Float.toString(b);
			String f = Float.toString(e);
			logger.info("Total record count from detail Report :: " + f);

			if (d.equals(f)) {
				System.out.println("Count is matched.");
				getTest().log(LogStatus.PASS, "Count is matched as expected." + d);
				logger.info("Count is matched as expected." + d);

			} else {
				getTest().log(LogStatus.FAIL, "Count is not matched as expected." + d);
				logger.info("Count is not matched as expected." + d);
				takeScreenshot(new Object() {
				}.getClass().getEnclosingMethod().getName());
				Assert.fail("Count is not matched." + d);
			}
		} catch (Exception e) {
			logger.error("Error from getTotalRecordCount method " + e);
			e.printStackTrace();
		}
	}
}
