package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ExpenseOverLmitPage;
import utils.WebBasePage;

public class ExpenseOverLimitAction extends WebBasePage {

	WebDriver driver;
	ExpenseOverLmitPage expenseOverLimitPage;

	public ExpenseOverLimitAction(WebDriver driver) {
		super(driver, "Expense Over Limit");
		this.expenseOverLimitPage = new ExpenseOverLmitPage(driver);
		this.driver = driver;
	}

	public void naviagateToExpenseOverLimitPage() {
		expenseOverLimitPage.clickFullMenu();
		expenseOverLimitPage.clickExpenseSideMenu();
		expenseOverLimitPage.clickExpenseReport();
		expenseOverLimitPage.clickExpenseOverLimit();
	}

	public void selectValues() {
		expenseOverLimitPage.selectProject();
		expenseOverLimitPage.selectCategory();
		expenseOverLimitPage.selectOverLimitCheckbox();
	}

	public void selectDates() {
		expenseOverLimitPage.selectStartEndDate();
	}

	public void clickSearch() {
		expenseOverLimitPage.clickSearch();
	}

	public void expenseOverLimitCount() {
		expenseOverLimitPage.getTotalRecordCount();
	}

}
