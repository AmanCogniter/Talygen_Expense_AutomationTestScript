package pageobjects;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class AddExpenseLimitPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;

	static String datevalue = dateformat.format(date);
	static String categoryNameWithDate;
	public static String maxExpenseAmount;
	//static RandomNumber random=new RandomNumber();

	static int randomNumber;
	DateTime dateTime;

	public AddExpenseLimitPage(WebDriver driver) {
		super(driver, "Add Expense Page");
		this.driver = driver;
		this.dateTime = new DateTime(driver);
	}

	
	/* click on Add Expense Limit */
	public void addExpenseLimit() {
		clickByJavascript(By.cssSelector("#ancaddexpenselimitloaddata"), "Expense category add", 20);
	}

	/* click on add Expense category */
	public void addExpenseCategory() {
		click(By.xpath("//a[@class='aAddMorePopUp submitbtn round-icon-small btn-dark theme-primary']"),
				"Add Expense limit", 20);
	}

	/* enter Category Name */
	public void enterCategoryName() {
		 Random random=new Random();

		 randomNumber = random.nextInt(1000);

		//categoryNameWithDate = prop.getProperty("enterCategoryName") + datevalue;
		categoryNameWithDate = prop.getProperty("enterCategoryName") + datevalue;
		enter(By.cssSelector("#CategoryName"), categoryNameWithDate, "Enter category Name", 20);
	}
	/* enter Category Name */
	public void enterCategoryNameForEditExpense() {
		 Random random=new Random();

		 randomNumber = random.nextInt(1000);

		//categoryNameWithDate = prop.getProperty("enterCategoryName") + datevalue;
		categoryNameWithDate = prop.getProperty("enterCategoryNameForExpense") + datevalue;
		enter(By.cssSelector("#CategoryName"), categoryNameWithDate, "Enter category Name", 20);
	}

	/* select Category Name */
	public void selectCategoryName() {
		staticWait(2000);
		// driver.findElement(By.name("ExpenseCategoryId")).click();
		clickByJavascript(By.name("ExpenseCategoryId"), "Click on dropdown", 25);
		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='ExpenseCategoryId']//option"));
		System.out.println(allOptions.size());
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().contains(categoryNameWithDate)) {
				allOptions.get(i).click();
				break;
			}
		}
	}
	/* Select category Type */
	public void selectCatogeryType() {
		click(By.xpath("//select[@id='CategoryTypeId']"),
				"Select Catogery Type", 20);
	
		WebElement expense = driver.findElement(By.xpath("//select[@id='CategoryTypeId']"));
		Select select= new Select(expense);
		select.selectByVisibleText("Expense");
	}

	// Category Description
	public void enterCategoryDescription() {
		enter(By.cssSelector("#CategoryDescription"), prop.getProperty("enterCategoryDescription"),
				"Add category Description", 20);
	}

	// click on Save button -- Category
	public void saveCategory() {
		click(By.xpath("//div[@class='modal-footer' and @aria-required='false']//button[@data-original-title='Save']"),
				"SAVE category bUTTON", 20);
	}

	// -----Add expense limit ---------

	public void addExpenseLimitFrom() {
		staticWait(2000);
		
		 dateTime.getWeekStartEndDate();
		 staticWait(2000);
		//System.out.println( dateTime.getWeekStartEndDate());
		enter(By.xpath("//input[@id='txtExpenseLimitFrom']"), dateTime.weekStartDate, "Enter start date", 20);
	}

	public void addExpenseLimitTo() {
	//dateTime.getWeekStartEndDate();
		staticWait(2000);
		driver.findElement(By.xpath("//input[@id='txtExpenseLimitTo']/..//div[@data-toggle='datetimepicker']")).click();
		driver.findElement(By.xpath("//a[@title='Clear selection']")).click();
	//	driver.findElement(By.xpath("//input[@id='txtExpenseLimitTo']")).clear();
		staticWait(2000);
		enter(By.xpath("//input[@id='txtExpenseLimitTo']"), dateTime.weekEndDate, "Enter end date", 20);
		//clickByJavascript(By.xpath("//div[@data-target='#txtExpenseLimitTo']"), "end date ", 20);

//		clickByJavascript(By.xpath(
//				"//input[@class='datepicker form-control hasdatetimepicker notvue valid']//following::div[1]//span"),
//				"end date ", 20);
	}

//	public void datePickerExpenseLimitTo() {
//
//		click(By.xpath("//div[@data-target='#txtExpenseLimitFrom']//following::span[@class='input-group-text']"),
//				"Date picker expense limit To", 20);
//	}

//	public void datePickerExpenseLimitFrom() {
//		click(By.xpath("//div[@data-target='#txtExpenseLimitFrom']//span[@class='input-group-text']"),
//				"Date picker expense limit from", 20);
//	}

	public void selectUser() {

		clickByJavascript(By.xpath("//button[@title='Select Users']//span"), "Select user", 20);

		click(By.xpath(
				"//button[@class='multiselect custom-select btn btn-default']//following::li[@class='multiselect-item multiselect-all']//following::li[1]"),
				"Select user", 20);
		click(By.xpath(
				"//div[@class='btn-group show']/button[@type='button']"),
				"Closed Dropdown", 20);
	}

	// expense maximum limit
	public void maxExpenseLimit() {
		maxExpenseAmount = prop.getProperty("enterExpenseMaximumLimit");
		enter(By.cssSelector("#ExpenseMax"), prop.getProperty("enterExpenseMaximumLimit"), "Maximum expense allowed",
				20);
//		clickByJavascript(By
//				.xpath("//input[@class=\"datepicker form-control hasdatetimepicker notvue valid\"]//following::div[1]"),
//				"end date ", 20);
	}

	// expense allowed per day
	public void maxExpenseAllowedPerDay() {
		/*
		 * enter(By.cssSelector("#ExpensePerDay"),
		 * prop.getProperty("enterExpenseMaximumLimit"), "Expense allowed per day", 20);
		 */	
		enter(By.xpath("//tg-input/input[@id='ExpensePerDay']"), prop.getProperty("enterExpensePerDay"), "Expense allowed per day",
				20);

		
	}

	public void selectOverLimit() {

		/*
		 * clickByJavascript( By.xpath(
		 * "//label[@class='custom-control-label universal-custom-control-label pt-1' and @for='chk_10']"
		 * ), "Select over limit checkbox", 20);
		 */
		 staticWait(2000);
		clickByJavascript(	By.xpath(	"//label[text()='Allow expenses over the limit:']/ancestor::div[@class='form-group']/descendant::label[contains(@class,'custom-control-label universal-custom-control-label')]"),
				"Select over limit checkbox", 30);
		
		//clickByJavascript(By.xpath("(//label[text()='Allow expenses over the limit:']/..//label)[1]"),"Select over limit checkbox", 30);
	}

	public void selectExpenseApproval() {

		/*
		 * clickByJavascript( By.xpath(
		 * "//label[@class='custom-control-label universal-custom-control-label pt-1' and @for='chk_11']"
		 * ), "Select Approval required checkbox", 20);
		 */
		
		 staticWait(2000);
		clickByJavascript(
				By.xpath(
						"(//label[text()='Approval required per transaction:']/..//label)[2]"),
				"Select Approval required checkbox", 30);
		
		
		
		
	}

	public void saveExpenseLimit() {
		/* click(By.cssSelector("#btnSave"), "Save", 20); */
		click(By.xpath("//div[@class='col-lg-6 text-right']/ancestor::div[@class='row flex-row-reverse']/descendant::a[@id='btnSave']"), "Save", 20);
	}

	// Expense limit success message
	public void expenseLimitVerify() {
		/*
		 * verifySuccessMessage(By.cssSelector("#notifymessage div"),
		 * prop.getProperty("expenseLimitValidationMessage"), 20);
		 */
		
		  //verifySuccessMessage(By.xpath("//table[@id='ExpenseLimitListing']/thead/tr/th[@id='th-CATEGORY']/ancestor::div[@class='table-responsive']/descendant::td/a[@class='blue-time']"), prop.getProperty("expenseLimitValidationMessage"), 20);
		verifySuccessMessage(By.xpath("//table[@id='ExpenseLimitListing']/thead/tr/th[@id='th-CATEGORY']/ancestor::div[@class='table-responsive']/descendant::td/a[@class='blue-time']"),categoryNameWithDate , 20);
		 
	}

//	public void saveExpenseLimit() {
//verifySuccessMessage(By.xpath(FILE_NAME), FILE_NAME, characterLength);	}
//	
//	expenseLimitValidationMessage
	
}
