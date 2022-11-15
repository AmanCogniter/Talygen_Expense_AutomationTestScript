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

public class ExpenseOverLmitPage extends WebBasePage {

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
	static String totalRecordCount;
	static String recordCount;
	static String maxAddExpAmount;
	static String maxLimitExpenseAmount;

	public ExpenseOverLmitPage(WebDriver driver) {
		super(driver, "Expense Over Limit Page");
		this.dateTime = new DateTime(driver);
		this.projectListingPage = new ProjectListingPage(driver);
		this.addExpenseLimitPage = new AddExpenseLimitPage(driver);
		this.manageExpensePage = new ManageExpensePage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		//findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on expense Report
	public void clickExpenseReport() {
		staticWait(3000);
		//findElementInVisibility(
				//By.xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Expense Report']"), 20);

		click(By.xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Expense Report']"),
				"Click on expense Report", 20);
	}

	// click on Side menu
	public void clickExpenseSideMenu() {
		staticWait(3000);
		/*
		 * click(By.xpath(
		 * "//li[@data-name='Expense']//a//i//following::text()[1]//following::span[1]")
		 * , "Expense Side menu", 20);
		 */
		click(By.xpath("//li[@data-name='Expense ']/descendant::span[@class='fa  fa-angle-right gotosub']"),
				"Expense Side menu", 20);
	}

	// click on expense Over limit
	public void clickExpenseOverLimit() {
		click(By.cssSelector("#aExpenseOverLimitReport"), "Expense Over limit", 20);
	}

	// Select project
	public void selectProject() {
		click(By.xpath("//label[text()='Project:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

		enter(By.xpath("//label[text()='Project:']//following::input[@class='form-control multiselect-search'][1]"),
				projectListingPage.projectName, "Enter project", 20);
		// ul[@class='multiselect-container dropdown-menu
		// show']//li//label[contains(text(),' "+ + projectListingPage.projectName +
		// "'+)]
		click(By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[contains(text(),' "
				+ projectListingPage.projectName + "')]"), "select projectName from excel", 20);

	}

	// Select category
	public void selectCategory() {
		click(By.xpath("//label[text()='Category:']//following::span[@class='multiselect-native-select'][1]"),
				"Click on project", 20);

		enter(By.xpath("//label[text()='Category:']//following::input[@class='form-control multiselect-search'][1]"),
				addExpenseLimitPage.categoryNameWithDate, "Enter project", 20);

		click(By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//label[contains(text(),' "
				+ addExpenseLimitPage.categoryNameWithDate + "')]"), "select Ctegory from excel", 20);

	}

	// Over limit checkbox
	public void selectOverLimitCheckbox() {
		clickByJavascript(By.cssSelector("#chkoverlimit"), "Overlimit checkbox", 20);
	}

	// select start End Date
	public void selectStartEndDate() {
//		click(By.xpath("//div[@data-target='#dtFrom']"), "Select Start date", 20);

//		dateTime.getWeekStartEndDate();
//		enter(By.xpath("//input[@name='dtFrom']"), dateTime.datevalue, "Enter start date", 20);

		click(By.xpath("//div[@data-target='#dtTo']"), "Select End date", 20);
	}

	// click search
	public void clickSearch() {
		click(By.cssSelector("#aSearch"), "click search", 20);
	}

	// click clear
	public void clickClear() {
		click(By.cssSelector("#aClear"), "click clear", 20);
	}

	// get Total Record Count
	public void getTotalRecordCount() {
		try {
			
			//WebElement element = findElementPresence(By.xpath("//tr[@valign='top'][2]/td[8]/div"), 20);
			WebElement element = findElementPresence(By.xpath("//div[@id='viewer_pageviewOuterContainer']"), 20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("arguments[0].scrollIntoView();", element);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			switchToFrame();
			logger.info("Switch to reports frame");
			staticWait(4000);
			//recordCount = gettextByJSexecuter(By.xpath("//tr[@valign='top'][2]/td[8]/div"), "Total Records count", 20);
			recordCount = gettextByJSexecuter(By.xpath("//div[@id='viewer_pageviewOuterContainer']"), "Total Records count", 20);

//			recordCount = Integer.parseInt(totalRecordCount);
			logger.info("Total record count from detail Report :: " + recordCount);
			maxAddExpAmount = AddExpenseLimitPage.maxExpenseAmount;
			maxLimitExpenseAmount = ManageExpensePage.expAmount;

//			float a = Integer.parseInt(maxAddExpAmount);
			/*
			 * float a = Float.parseFloat(maxAddExpAmount); float b =
			 * Float.parseFloat(maxLimitExpenseAmount); float c = b - a; float e =
			 * Float.parseFloat(recordCount);
			 */
			int  a = Integer.parseInt(maxAddExpAmount);
			int b = Integer.parseInt(maxLimitExpenseAmount);
			int c = b - a;
			int e = Integer.parseInt(recordCount);
			/*
			 * String d = Float.toString(c); String f = Float.toString(e);
			 */
			String d = Integer.toString(c);
			String f = Integer.toString(e);
			logger.info("Total record count from detail Report :: " + c);

			if (f.equals(d)) {
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
