package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.DateTime;
import utils.PropertiesLoader;

import utils.WebBasePage;

public class ProjectListingPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	DateTime dateTime;
	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);
	static int randomNumber;
	/*
	 * static RandomNumber random=new RandomNumber();
	 * 
	 * int randomNumber = random.getRandomNumber();
	 */
	static String getCurrentDate = dateformat.format(date);
	static String projectName;

	public ProjectListingPage(WebDriver driver) {
		super(driver, "Project Listing Page");

		this.dateTime = new DateTime(driver);

		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		//findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on Project
	public void clickProjectSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Project Management']//a//i//following::text()[1]//following::span[1]"),
				"Project Management Side menu", 10);
	}

	// click on Ticket Report
	public void clickProject() {
		staticWait(3000);
		click(By.xpath(
				"//ul[@class='submenu clschild_1 d-flex']//a[@data-original-title='Project' and @id='cadmin_messageboard_link']"),
				"Project", 20);
	}

	/* Click on Close Tour Guide */
	public void closeTourGuidePopup() { 
		staticWait(3000);
       click(By.xpath("//div[contains(text(),'Widgets')]/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon']"
					  ), "Close Tour Guide Popup", 20); 
       }

	// click on Add project
	public void clickAddProject() {
		click(By.xpath("//a[@data-original-title='Add Project']"), "Add project", 20);
	}

	/* Click On closedefaultTemplateTourGuidePopup */
	public void closedefaultTemplateTourGuidePopup() { 
		staticWait(3000);
       click(By.xpath("(//div[@class='guided-tour-step-footer']/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon'])[4]"
					  ), "Close Tour Guide Popup", 20); }

	// select default template
	public void selectDefaultTemplate() {
		staticWait(3000);
		clickByJavascript(By.cssSelector("#temp_0"), "Select default template", 20);
	}

	// enter project name
	public void enterProjectName() {
		projectName = prop.getProperty("enterProjectName") + datevalue;
		enter(By.xpath("//input[@name='project_name']"), projectName, "enterProject Name", 20);
	}

	// click on add channel
	public void addChannel() {
		click(By.xpath(
				"//select[@name='channel_id']//following::span[@class='input-group-text border-0 bg-transparent p-0 pl-2'][1]"),
				"Add Channel", 20);
	}

	// enter Channel name
	public void enterChannelName() {
		 Random random=new Random();

	 randomNumber = random.nextInt(10000);
		enter(By.cssSelector("#ChannelName"), prop.getProperty("enterChannelName") + randomNumber, "Enter Channel name",
				20);
	}

	// enter Channel name
	public void enterChannelDescription() {
		enter(By.cssSelector("#ChannelDescription"), prop.getProperty("enterChannelDescription"),
				"Enter Channel description", 20);
	}

	// click Save button
	public void SaveButton() {

		click(By.xpath("//a[@class='btn btn-success formbtn mr-2']"), "Save button", 20);
	}

	// select priority
	public void selectPriority() {

		selectValueWithText(By.xpath("//select[@name='priority_id']"), "High", "Select Priority", 20);
	}

	// enter Estimated Cost
	public void enterEstimatedCost() {

		enter(By.cssSelector("#estimated_cost"), prop.getProperty("enterProjectAmount"), "enter project estimated cost",
				20);

	}

	// enter Purchase Number
	public void enterPurchaseNumber() {
		enter(By.cssSelector("#ponumber"), prop.getProperty("enterPurchaseNumber"), "enter project amount", 20);
	}

	// select priority
	public void selectLocation() {
		selectValueWithText(By.xpath("//select[@name='location_id']"), "Dallas", "Select Location", 20);
	}

	// enter project description
	public void enterProjectDescription() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		switchToFrame();
		WebElement element = findElementVisibility(By.tagName("body"), 15);
		element.clear();
		enter(By.tagName("body"), prop.getProperty("enterProjectDescription"), "Add Project Description", 20);
		driver.switchTo().defaultContent();
	}

	// click next button
	public void clickNextButton() {
		clickByJavascript(By.cssSelector("#btnNext"), "Next button", 20);
	}

	// click next button
	public void nextButton() {
		click(By.cssSelector("#btnNextstep2"), "Next button", 20);
	}

	// select Currency
	public void selectCurrency() {
		selectValueWithText(By.xpath("//select[@name='currency_id']"), "United States dollar (USD)", "Select Currency",
				20);
	}

	// click Slider button
	public void sliderYesButton() {

		clickByJavascript(
				By.xpath("//label[@class='switch medium']//following::span[@class='slider-no' and text()='Fixed']"),
				"Slider Fixed button", 20);
	}

	// enter Project Hours
	public void enterProjectHours() {
		/*
		 * enter(By.cssSelector("#estimated_hours"),
		 * prop.getProperty("enterProjectHours"), "enter project hours", 20);
		 */
		enter(By.xpath("//input[@id='estimated_hours']"), prop.getProperty("enterProjectHours"), "enter project hours", 20);
	}

	// enter Project Rate
	public void enterProjectRate() {
		enter(By.cssSelector("#base_rate"), prop.getProperty("enterProjectRate"), "enter project Rate", 20);
	}

	// click Checkbox
	public void selectCheckbox() {
		clickByJavascript(By.xpath(
				"//div[@class='table-responsive table-fix-header float-left']//tbody//tr[1]//td[1]//input//following::label[1]"),
				"Select checkbox", 20);
	}

	/* Close Finished SetUpTour Guide Popup */
	public void closeFinishedSetUpTourGuidePopup() { 
		staticWait(3000);
       click(By.xpath("//div[contains(text(),'Click on Save to finish the project setup.')]/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon']"
					  ), "Close  Finished SetUp Tour Guide Popup", 20); 
       }

	

	// click Save
	public void clickSave() {
		
		click(By.xpath("//div[@class='search-btm-btn']//a[@data-original-title='Save']"), "click Save", 20);
	}

	// click Automation project
	public void clickAutomationProject() {
		staticWait(3000);
		click(By.xpath("//div/h5/a/span[text()='Project Name']"), "Project Name", 20);
		enter(By.xpath("//div/input[@placeholder='Search by Project Name']"), projectName, "Project Name", 20);
		staticWait(2000);
		click(By.xpath("//div/h5//span[@data-original-title='Search']"), "Search Button", 20);
		clickByJavascript(
				By.xpath("//table[@id='ProjectListing']//tbody//tr[1]//span[@title='" + projectName + "']//a"),
				"click Automation project", 20);
	}

	// click Expense limit
	public void expenseLimit() {
		findElementVisibility(By.cssSelector("#aProjectOverView12"), 2);
		click(By.cssSelector("#aProjectOverView12"), "click Expense limit", 20);
	}

	// Add Expense limit
	public void addExpenseLimit() {
		clickByJavascript(By.cssSelector("#ancaddexpenselimitloaddata"), "add expense limit", 20);
//		enter(By.cssSelector("#ancaddexpenselimitloaddata"), prop.getProperty("enterExpenseMaximumLimit"),
//				"Maximum expense limit", 20);
	}

	// Add Expense limit
	public void expenseAllowedPerDay() {
		enter(By.cssSelector("#ExpenseMax"), prop.getProperty("enterExpenseMaximumLimit"), "Maximum expense limit", 20);
	}

	// click Task
	public void clickTask() {
		click(By.cssSelector("#aProjectOverView2"), "click Task", 20);
	}

	public void navigateBack() {
		driver.navigate().back();
		logger.debug("Navigate back to project listing page");
	}

}
