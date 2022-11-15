package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ExpenseReportPage;
import utils.WebBasePage;

public class ExpenseReportAction extends WebBasePage {

	WebDriver driver;
	ExpenseReportPage expenseReportPage;

	public ExpenseReportAction(WebDriver driver) {
		super(driver, "Expense Report Page");
		this.expenseReportPage = new ExpenseReportPage(driver);
		this.driver = driver;
	}

	public void naviagateToExpenseReportPage() {
		expenseReportPage.clickFullMenu();
		expenseReportPage.clickExpenseSideMenu();
		expenseReportPage.clickExpenseReport();
		expenseReportPage.clickExpenseReportTab();
	}

	public void selectValues() {
		expenseReportPage.selectProject();
		expenseReportPage.selectCategory();
		expenseReportPage.selectTrip();
		expenseReportPage.selectUser();
		expenseReportPage.selectApprover();
		expenseReportPage.selectStatus();
	}

	public void selectDates() {
		expenseReportPage.selectStartEndDate();
	}

	public void clickSearch() {
		expenseReportPage.clickSearch();
	}

	public void expenseReportCount() {
		expenseReportPage.getTotalRecordCount();
	}
}
