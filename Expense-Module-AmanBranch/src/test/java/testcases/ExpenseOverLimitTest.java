package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.ExpenseOverLimitAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ExpenseOverLimitTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyOverLimitReport() {
		test = getTest("TC_Expense_Overlimit");
//		new LoginAction(driver).logoutLogin();
//		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
//		projectListingAction.navigateToProject();
//		projectListingAction.addProject();
//		projectListingAction.addChannel();
//		projectListingAction.selectPriority();
//		projectListingAction.enterPurchaseNumber();
//		projectListingAction.selectLocation();
//		projectListingAction.enterProjectDescription();
//		projectListingAction.clickNextButton();
//		AddExpenseLimitAction addExpenseLimitAction = new AddExpenseLimitAction(driver);
//		addExpenseLimitAction.addExpLimit();
//		addExpenseLimitAction.addExpenseCategory();
//		addExpenseLimitAction.addExpenseLimit();
//		new LoginAction(driver).logoutLogin();
//		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
//		manageExpenseAction.addExpense();
//		manageExpenseAction.fillExpenseDetails();
//		manageExpenseAction.submitForApproval();
		
		new LoginAction(driver).logoutLogin();
		ExpenseOverLimitAction expenseOverLimitAction = new ExpenseOverLimitAction(driver);
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		projectListingAction.navigateToProject();
		projectListingAction.addProject();
		projectListingAction.addChannel();
		projectListingAction.selectPriority();
		projectListingAction.enterPurchaseNumber();
		projectListingAction.selectLocation();
		projectListingAction.enterProjectDescription();
		projectListingAction.clickNextButton();
		AddExpenseLimitAction addExpenseLimitAction = new AddExpenseLimitAction(driver); 
		addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategory();
		  addExpenseLimitAction.addExpenseLimit();
		  manageExpenseAction.addExpense();
			manageExpenseAction.fillExpenseDetails();
			manageExpenseAction.saveAsDraft();
			manageExpenseAction.submitForApproval();
		expenseOverLimitAction.naviagateToExpenseOverLimitPage();
		expenseOverLimitAction.selectValues();
		expenseOverLimitAction.selectDates();
		expenseOverLimitAction.clickSearch();
		expenseOverLimitAction.expenseOverLimitCount();
	}
}
