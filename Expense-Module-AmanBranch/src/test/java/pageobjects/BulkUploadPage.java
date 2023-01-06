package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class BulkUploadPage extends WebBasePage {

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
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	Row nextRow;
	String sheet;
	HSSFSheet sheets;
	static int counter = 0;
	static String expenseDateFromWeb;

	public BulkUploadPage(WebDriver driver) {
		super(driver, "Bulk Upload Page");
		this.dateTime = new DateTime(driver);
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		//findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
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

	// click sample upload file
	public void clickSampleDownloadFile() {
		staticWait(3000);
		clickByJavascript(By.xpath("//div//span[@id='basic-addon2']//a//i"), "Download Sample file", 10);

	}

	public void clickUploadFile() {
		staticWait(3000);
		clickByJavascript(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
				"Upload file", 10);
	}

	// bulk uploada
	public void clickBulkUpload() {
		/*
		 * clickByJavascript( By.
		 * xpath("//ul[@class='submenu clschild_2 d-flex']//a[@data-original-title='Bulk Upload Expense']"
		 * ), "Bulk Upload", 10);
		 */
		/*
		 * clickByJavascript( By.
		 * xpath("//div[contains(text(),'Bulk Upload')]/ancestor::div[@class='menu-box']/descendant::a[contains(text(),'Bulk Upload Expense')]"
		 * ), "Bulk Upload", 10);
		 */
		clickByJavascript(
				By.xpath("//li[@class='menuitem']/ancestor::ul[@data-p-name='Expense ']/descendant::a[@data-original-title='Bulk Upload Expense']"),
				"Bulk Upload Expense", 10);
	}
	/* Click on Close Tour Guide */
	public void closeTourGuidePopup() { 
		staticWait(3000);
       click(By.xpath("//div[contains(text(),'Download the sample file and enter the expense details for bulk upload.')]/ancestor::div[@class='guided-tour-step-tooltip-inner']/descendant::span[@title='End tour']/*[name()='svg' and @class='guided-tour-icon']"
					  ), "Close Tour Guide Popup", 20); 
       }


	// Import button
	public void clickImport() {
		staticWait(3000);
		clickByJavascript(By.xpath("//input[@class='btn btn-info formbtn widthhalf fa fa-input']"), "Import button",
				10);
	}

	// Bulk upload validation
	public void verifyBulkUploadValidation() {
		staticWait(3000);
		verifySuccessMessage(
				By.xpath("//div[@class='alert alert-dismissible fade show msg mw-90 alert-danger']//span[text()]"),
				prop.getProperty("bulkUploadValidation"), 20);
		staticWait(2000);
		click(By.xpath("//div[@class='alert alert-dismissible fade show msg mw-90 alert-danger']//button[@type='button']"), "Close button",
				10);
	}

	// upload file
	public void uploadDocument() {
//		findElementVisibility(
//				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//		String h = filePath + prop.getProperty("expenseFileDoc");
//		System.out.println("file path is :: " + h);
//		

		/*
		 * driver.findElement(By.
		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
		 * )) .click();
		 */
		driver.findElement(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flAvatar']"))
		.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Expense-Module-AmanBranch\\Expense-Module-AmanBranch\\src\\main\\resources\\testfiles\\Expense.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Import button
	public void validateExpenseList() {
		clickByJavascript(By.cssSelector("#aValidate"), "validate exapense list ", 10);
	}

	// verify validation message
	public void verifyValidationMessages() {

		verifyValidateMessage("Project is required.");
		verifyValidateMessage("Category is required");
	}

	// span[@class='invalid-feedback' and text()='Project is required.']

	// verify validation message
	public void verifyValidateMessage(String value) {
		staticWait(3000);
		String validationMessage;
		try {
			findElementsVisibility((By.xpath("//span[@class='invalid-feedback' and text()='" + value + "']")));
			validationMessage = getText(By.xpath("//span[@class='invalid-feedback' and text()='" + value + "']"), 20);
			logger.debug("validation message is :: " + validationMessage);
			if (validationMessage.equals(value)) {
				getTest().log(LogStatus.PASS, validationMessage + " is successfully displayed");
			} else {
				getTest().log(LogStatus.FAIL, "Validation message is not successfully displayed");
				logger.debug("validation message is not displayed");
				takeScreenshot(validationMessage);
				Assert.fail("" + validationMessage);
				validationMessage = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// aRead xls file
	public void readExcelFile() {
		staticWait(3000);
		try {
			// Path of the excel file
			FileInputStream fis = new FileInputStream("C:\\Users\\aanand\\eclipse-workspace\\Expense-Module-AmanBranch\\Expense-Module-AmanBranch\\src\\main\\resources\\testfiles\\Expense.xls");/*C:\\Users\\aanand\\Downloads\\Expense.xls*/
			// Creating a workbook
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);

			sheets = workbook.getSheet(sheet.getSheetName());
			Iterator<Row> iterator = sheets.iterator();
			Row nextRow = null;
			nextRow = iterator.next();
			nextRow = null;
			counter = 1;

			String expenseDateOne = null;

			while (iterator.hasNext()) {
				nextRow = iterator.next();
//				nextRow = iterator.next();

				System.out.println("counter values is ::" + counter);

				if (nextRow.getCell(Integer.valueOf(prop.getProperty("tripFromExcel"))) != null) {
					String tripFromExcel = null;

					tripFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("tripFromExcel")))
							.getStringCellValue();
					System.out.println("value from excel" + tripFromExcel);
					selectTripFromExcel(tripFromExcel);
				}

				if (nextRow.getCell(Integer.valueOf(prop.getProperty("titleFromExcel"))) != null) {
					String titleFromExcel = null;

					titleFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("titleFromExcel")))
							.getStringCellValue();
					System.out.println("title from excel" + titleFromExcel);
					matchTitleFromExcel(titleFromExcel);
				}

//				if (nextRow.getCell(Integer.valueOf(prop.getProperty("categoryFromExcel"))) != null) {
//					String categoryFromExcel = null;
//
//					categoryFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("categoryFromExcel")))
//							.getStringCellValue();
//					System.out.println("value from excel" + categoryFromExcel);
//					matchCategoryFromExcel(categoryFromExcel);
//				}

//				if (nextRow.getCell(Integer.valueOf(prop.getProperty("projectFromExcel"))) != null) {
//
//					expenseDateOne = nextRow.getCell(Integer.valueOf(prop.getProperty("projectFromExcel")))
//							.getStringCellValue();
//					System.out.println("value from excel" + expenseDateOne);
//					matchExpenseDateFromExcel(expenseDateOne);
//			}

//			if (nextRow.getCell(Integer.valueOf(prop.getProperty("taskFromExcel"))) != null) {
//				String taskFromExcel = null;
//
//				taskFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("taskFromExcel")))
//						.getStringCellValue();
//				System.out.println("title from excel" + taskFromExcel);
//				matchTaskFromExcel(taskFromExcel);
//			}

				if (nextRow.getCell(Integer.valueOf(prop.getProperty("amountFromExcel"))) != null) {
					int amountFromExcel;
					amountFromExcel = (int) nextRow.getCell(Integer.valueOf(prop.getProperty("amountFromExcel")))
							.getNumericCellValue();
					System.out.println("amount from excel" + amountFromExcel);
					matchAmountFromExcel(amountFromExcel);
				}

				if (nextRow.getCell(Integer.valueOf(prop.getProperty("CurrencyFromExcel"))) != null) {
					String currencyFromExcel = null;

					currencyFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("CurrencyFromExcel")))
							.getStringCellValue();
					System.out.println("currency from excel from excel" + currencyFromExcel);
					matchCurrencyFromExcel(currencyFromExcel);
				}

				if (nextRow.getCell(Integer.valueOf(prop.getProperty("DescriptionFromExcel"))) != null) {
					String descriptionFromExcel = null;
					descriptionFromExcel = nextRow.getCell(Integer.valueOf(prop.getProperty("DescriptionFromExcel")))
							.getStringCellValue();
					System.out.println("description from excel" + descriptionFromExcel);
					matchDescriptionFromExcel(descriptionFromExcel);
				}
				counter++;

				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// enter Description
	public void matchExpenseDateFromExcel(String excelDateOne) {
		expenseDateFromWeb = getAtribute(By.xpath("//input[@id='txtdatepicker0']"), "value", 20);

		if (expenseDateFromWeb.equals((excelDateOne))) {
			logger.info("Expense datea from excel is matched");
		} else {
			logger.info("Expense date from excel is not matched");
		}
	}

	// select trip from excel
	public void selectTripFromExcel(String tripFromExcel) {

		selectValueWithText(
				By.xpath("//table[@id='tblExpList']//tbody[1]//tr['" + counter
						+ "']//select[@class='select trip form-control']"),
				tripFromExcel, "select trip from excel", 20);
	}

	// match title from excel
	public void matchTitleFromExcel(String titleFromExcel) {

		expenseDateFromWeb = getAtribute(
				By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[3]//input[1]"), "value", 20);
		if (expenseDateFromWeb.equals((titleFromExcel))) {
			logger.info("Title from excel is matched");
		} else {
			logger.info("Title from excel is not matched");
		}
	}

	// match category from excel
	public void matchCategoryFromExcel(String categoryFromExcel) {

		selectValueWithText(
				By.xpath("//table[@id='tblExpList']//tbody[1]//tr['" + counter
						+ "']//td[@class='cat']//select[@class='select form-control']"),
				categoryFromExcel, "select trip from excel", 20);

	}

	// match project from excel
	public void matchProjectFromExcel(String projectFromExcel) {

		selectValueWithText(
				By.xpath("//table[@id='tblExpList']//tbody[1]//tr['" + counter
						+ "']//td[@class='pro']//select[@class='select form-control']"),
				projectFromExcel, "select project from excel", 20);
	}

	// match task from excel
	public void matchTaskFromExcel(String taskFromExcel) {

		selectValueWithText(
				By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter
						+ "']//td[7]//select[@class='select task form-control']"),
				taskFromExcel, "title from excel :: " + taskFromExcel, 20);

	}

	// match currency from excel
	public void matchCurrencyFromExcel(int currencyFromExcel) {

		selectValueWithText(By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[6]//select"),
				"currency from excel " + currencyFromExcel, "currency from excel", 20);

	}

	// match Amount from excel
	public void matchAmountFromExcel(int amountFromExcel) {

		String amountText = getAtribute(
				By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[8]//input"), "value", 20);
		if (amountText.equals((amountFromExcel))) {
			logger.info("Amount from excel is matched");
		} else {
			logger.info("amount from excel is not matched");
		}
	}

	// match description from excel
	public void matchDescriptionFromExcel(String descFromExcel) {

//		selectValueWithText(By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[9]//textarea"),
//				descFromExcel, "amount from excel :: " + descFromExcel, 20);
		String descText = getAtribute(
				By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[9]//textarea"), "value", 20);
		if (descText.equals((descFromExcel))) {
			logger.info("description from excel is matched");
		} else {
			logger.info("description from excel is not matched");
		}
	}

	// match currency from excel
	public void matchCurrencyFromExcel(String currencyFromExcel) {

		selectValueWithText(By.xpath("//table[@id='tblExpList']//tbody//tr['" + counter + "']//td[6]//select"),
				currencyFromExcel, "Currency from excel :: " + currencyFromExcel, 20);
	}
}
