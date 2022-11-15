package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ManageExpensePage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static String datePattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;
	public static String expAmount;
	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;
	static String tripName;
	static String randomNameGenerator = nameGenerator();
	ProjectListingPage projectListingPage; 
	AddExpenseLimitPage addExpenseLimitPage;
	ManageExpensePage manageExpensePage;

	
	  String filePath = System.getProperty("user.dir") +
	  "\\src\\main\\resources\\testfiles\\";
	 
	//String filePath = System.getProperty("user.dir") + "/src/test/resources/testfiles/file-sample_100kB.doc";

	public ManageExpensePage(WebDriver driver) {
		super(driver, "Manage Expense Page");
		this.dateTime = new DateTime(driver);
		this.addExpenseLimitPage = new AddExpenseLimitPage(driver);
		this.projectListingPage = new ProjectListingPage(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);

//		pageNavigate("https://app.talygen.com/Expenses/Add", "Add expense");
		findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on expense
	public void clickExpenseSideMenu() {
		staticWait(3000);
		clickByJavascript(By.xpath("//li[@data-name='Expense ']/descendant::span[@class='fa  fa-angle-right gotosub']"),
				"Expense Side menu", 10);
	}

	// click on expense
	public void clickExpense() {
		//click(By.xpath("//li[@id='menuitem9']//a"), "Expense", 20);
		click(By.xpath("//a[@data-original-title='Expenses']"), "Expense", 20);
	}

	// click on Add expense
	public void clickAddExpense() {
		click(By.xpath("//a[@data-original-title='Add Expense']"), "Add Expense", 20);
	}

//	// select default template
//	public void selectDefaultTemplate() {
//		clickByJavascript(By.cssSelector("#ExpenseTitle"), "Select default template", 20);
//	}
	/* Close Finished SetUpTour Guide Popup */
	public void closeEndTourGuide() { 
		staticWait(3000);
       click(By.xpath("//div[contains(text(),'Submit the required details.')]/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon']"
					  ), "Close Tour Guide", 20); 
       }
	// enter expense title
	public void enterExpenseTitle() {
	enter(By.cssSelector("#ExpenseTitle"), prop.getProperty("enterExpenseTitle") + randomNameGenerator,"enter expense title", 20);
		
		//enter(By.cssSelector("#ExpenseTitle"),"AutomationExpenseAJBDBJAKGC","enter expense title", 20);
		
		
	}
 
	// enter expense date
	public void enterExpenseDate() {

		//enter(By.xpath("//input[@id='ExpenseDate']"), DateTime.datevalue, "enter expense Date" + DateTime.datevalue,	20);
		
		  click(By.xpath("//input[@id='ExpenseDate']/..//div[@data-toggle='datetimepicker']"),
		  "enter expense Date" , 25); 
		  click(By.xpath("//input[@id='ExpenseDate']/..//div[@data-toggle='datetimepicker']"),
		  "enter expense Date" , 25);
		 

	}

	// select project
	public void selectProject() {
		staticWait(3000);
		//selectValueWithText(By.cssSelector("#ProjectId"), projectListingPage.projectName, "select project", 20);
	selectValueWithText(By.xpath("//tg-select/label[text()='Project']/ancestor::div[@class='form-group']/descendant::select[@id='ProjectId']"), projectListingPage.projectName, "select project", 20);
		
		
		//selectValueWithText(By.cssSelector("#ProjectId"),"Automation_Project123456789", "select project", 20);
	}

	// select add trip
	public void addTripName() {

		click(By.xpath(
				"//select[@id='TripId']//following::a[@class='aAddMorePopUp submitbtn btn-dark theme-primary round-icon-small'][1]"),
				"add trip", 20);
		tripName = prop.getProperty("enterAutomationTrip") + otherDateValue;
		enter(By.cssSelector("#TripName"), tripName, "enter trip Name " + otherDateValue, 20);
		enter(By.cssSelector("#TripDesc"), prop.getProperty("enterTripDesc") + otherDateValue, "enter trip Description",
				20);
		otherDateValue = "";
		click(By.xpath("//div[@class='modal-footer']//following::button[@class='btn btn-success']"), "save", 20);
	}

	// select Trip
	public void selectTrip() {
		findElementPresence(By.cssSelector("#TripId"), 30);
		selectValueWithText(By.cssSelector("#TripId"), tripName, "select trip", 20);
	}

	// enter expense date
	public void enterExpenseAmount() {
		expAmount = prop.getProperty("enterAmountUsd");
		enter(By.cssSelector("#ExpenseAmount"), expAmount, "enter expense Amount", 20);
	}

	// select currency
	public void selectCurrency() {
		
		selectValueWithText(By.cssSelector("#CurrencyId"),"United States dollar (USD)", "select currency", 20);
		
		/*
		 * WebElement currency =
		 * driver.findElement(By.xpath("//select[@id='CurrencyId']")); Select sel = new
		 * Select(currency); sel.selectByIndex(2);
		 * System.out.println(" Print Currency Value");
		 */
		 
	}

	// enter expense description
	public void enterExpenseDescription() {
		enter(By.cssSelector("#Description"), prop.getProperty("enterExpenseDescription"), "Add expense description",
				20);
	}

	// select category
	
	 public void testCategory()
	 {
		 selectValueWithText(By.cssSelector("#ddlCategory"),"AutomationCategory220713144648", "select Category", 20);
	 }
	 
	public void selectCategory() {

//			selectValueWithText(By.cssSelector("#ddlCategory"), prop.getProperty("enterCategoryName") + datevalue, "select currency", 20);
		staticWait(2000);

		// driver.findElement(By.name("ExpenseCategoryId")).click();

		clickByJavascript(By.cssSelector("#ddlCategory"), "Select Category", 25);

		List<WebElement> categoryNameWithDate = driver.findElements(By.xpath("//select[@id='ddlCategory']//option"));

		for (int i = 0; i <= categoryNameWithDate.size() - 1; i++) {
			if (categoryNameWithDate.get(i).getText().contains(addExpenseLimitPage.categoryNameWithDate)) {
				categoryNameWithDate.get(i).click();
				break;
			}
		}
	}

	// click submit for approval
	public void clickSubmitForApproval() {
		staticWait(3000);
		/* click(By.cssSelector("#aSendForApproval"), "Submit for approval	", 20); */
		 click(By.cssSelector("#aSendForApproval"), "Submit for approval	", 20); 
		//click(By.xpath("//div[contains(@class,'text-right')]/ancestor::div[@class='row flex-row-reverse']/descendant::a[@id='aSendForApproval']"), "Submit for approval	", 20);
	}

	// click Save as Draft
	public void clickSaveAsDraft() {
		staticWait(5000);
		//click(By.cssSelector("#aSubmit"), "Save as Draft", 20);
		//click(By.xpath("//a[@id='aSubmit']/span[.='Save As Draft']"), "Save as Draft", 20);
		//findElementVisibility(By.cssSelector("#notifymessage"), 20);
		clickByJavascript(By.xpath("//a[@id='aSubmit']"), "Save as Draft", 25);
		
		
	}

	// Uplaod file
	public void expenseFileUpload() {
		
		  findElementPresence(By.xpath("//input[@id='flFile']"), 20)
		  .sendKeys(filePath + prop.getProperty("testfileDoc"));
		 
		/*
		 * findElementPresence(By.
		 * xpath("//div[@class='custom-file']/ancestor::div[@id='divFiles']/descendant::span[contains(@class,'group-span-filestyle input-group-btn ')]/label[text()='Choose File']"
		 * ), 20) .sendKeys(filePath + prop.getProperty("testfileDoc"));
		 */
	}
	
	

	// Add expense success message
	public void addExpenseSuceessMessage() {
		//verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("expenseSuccessMessage"), 20);
		verifySuccessMessage(By.xpath("//div[@class='alert alert-dismissible fade show msg mw-90 alert-danger']/span"), prop.getProperty("expenseSuccessMessage"), 20);
	}

	public void editExpenseTitle() {
		enter(By.cssSelector("#ExpenseTitle"), prop.getProperty("enterExpenseTitle"), "enter expense title", 20);
	}
	/* Close Search Filters Tour Guide */
	public void closeSearchTourGuide() {
		click(By.xpath("//div[contains(text(),'Search your expenses using the search filters.')]/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon']"), "Close Search Tour Guide	", 20);
	}

	/* Click On ExpenedAll */
	public void clickOnExpenedAll() {
		clickByJavascript(By.xpath("//a[@data-original-title='Expand All or Collapse All']"), "ExpenedAndCollapse", 25);
	}
	/* Enter value into Search Field */
	public void enterValueIntoSearchField() {
		staticWait(3000);
		String searchProjectName=projectListingPage.projectName;
		enter(By.xpath("//input[@placeholder='Search']"), searchProjectName, "Enter Value Into Search Field", 20);
		
	}
	/* Click on Project Check Box */
	public void selectProjectCheckBox() {
		String projectName=projectListingPage.projectName;
		click(By.xpath("//label[text()='"+projectName+"']"), "CheckBox	", 20);
		
	}
	/* click On Search button */
	public void clickOnSearchButton() {
		clickByJavascript(By.xpath("//a[@data-original-title=' Search']"), "Search", 25);
	}
	/* Click On action button */
	public void clickOnActionButton() {
		staticWait(3000);
		click(By.xpath("//td[@class='text-center mobile-action']/span[@class='actions mobileaction']"), "Action	", 20);
	}
	/* Click On Edit Expense */
	public void clickOnEditExpense() {
		click(By.xpath("//span[text()='Edit Expense']"), "Edit Expense	", 20);
	}
}