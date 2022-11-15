package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.ExpenseReportAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ExpenseReportTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyExpenseReport() {
		test = getTest("TC_Expense_Report");
		new LoginAction(driver).logoutLogin();
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
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
		new LoginAction(driver).logoutLogin();
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		manageExpenseAction.addExpense();
		manageExpenseAction.fillExpenseDetails();
		manageExpenseAction.saveAsDraft();
		manageExpenseAction.submitForApproval();
		ExpenseReportAction expenseReportAction = new ExpenseReportAction(driver);
		new LoginAction(driver).logoutLogin();
		expenseReportAction.naviagateToExpenseReportPage();
		expenseReportAction.selectValues();
		expenseReportAction.selectDates();
		expenseReportAction.clickSearch();
		expenseReportAction.expenseReportCount();
	}
}