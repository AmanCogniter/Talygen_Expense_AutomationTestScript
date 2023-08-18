package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddExpenseLimitPage;
import utils.WebBasePage;

public class AddExpenseLimitAction extends WebBasePage {

	WebDriver driver;
	AddExpenseLimitPage addExpenseLimitPage;

	public AddExpenseLimitAction(WebDriver driver) {
		super(driver, "Add Expense Limit");
		this.addExpenseLimitPage = new AddExpenseLimitPage(driver);
		this.driver = driver;
	}

	public void addExpLimit() {

		addExpenseLimitPage.addExpenseLimit();
	}

// navigate To add Expense category
	public void addExpenseCategory() {

		addExpenseLimitPage.addExpenseCategory();
		addExpenseLimitPage.enterCategoryName();
		addExpenseLimitPage.selectCatogeryType();
		addExpenseLimitPage.enterCategoryDescription();
		addExpenseLimitPage.saveCategory();

	}
	// navigate To add Expense category
		public void addExpenseCategoryForEditExpense() {

			addExpenseLimitPage.addExpenseCategory();
			addExpenseLimitPage.enterCategoryNameForEditExpense();
			addExpenseLimitPage.selectCatogeryType();
			addExpenseLimitPage.enterCategoryDescription();
			addExpenseLimitPage.saveCategory();

		}

	public void addExpenseLimit() {
//		addExpenseLimitPage.addExpenseCategory();
		addExpenseLimitPage.selectCategoryName();
		addExpenseLimitPage.addExpenseLimitFrom();
		addExpenseLimitPage.addExpenseLimitTo();

//		addExpenseLimitPage.datePickerExpenseLimitTo();
//		addExpenseLimitPage.datePickerExpenseLimitFrom();

		addExpenseLimitPage.selectUser();
		addExpenseLimitPage.maxExpenseLimit();
		addExpenseLimitPage.maxExpenseAllowedPerDay();
		addExpenseLimitPage.selectOverLimit();
		addExpenseLimitPage.selectExpenseApproval();
		addExpenseLimitPage.saveExpenseLimit();

	}

	public void expenseLimitSuccessMsg() {
		addExpenseLimitPage.expenseLimitVerify();
	
	}
	

}
