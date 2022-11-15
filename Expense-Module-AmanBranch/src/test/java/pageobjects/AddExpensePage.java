package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class AddExpensePage extends WebBasePage {

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
	DateTime dateTime;

	public AddExpensePage(WebDriver driver) {
		super(driver, "Add Expense Page");
		this.driver = driver;
		this.dateTime = new DateTime(driver);
	}

	// click on full menu
	public void clickExpenseSideMenu() {
		click(By.xpath("//li[@data-name='Expense']//a//i//following::text()[1]//following::span[1]"),
				"Expense Side menu", 20);
	}

	// click on full menu
	public void addExpenseCategory() {
		click(By.xpath("//a[@class='aAddMorePopUp submitbtn round-icon-small btn-dark theme-primary']"),
				"Add Expense limit", 20);
	}

	// click on full menu
	public void add() {
		click(By.xpath("//a[@data-original-title='Expenses']"), "Add Expense limit", 20);
	}

}
