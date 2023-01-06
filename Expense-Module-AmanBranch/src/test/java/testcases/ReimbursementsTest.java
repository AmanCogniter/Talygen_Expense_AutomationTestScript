package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import action.ReimbursementsAction;
import utils.WebTestBase;

public class ReimbursementsTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyReimbursementReportWithCompany() {
		test = getTest("TC_Expense_Reimbursements");
		new LoginAction(driver).logoutLogin();
	
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
		ReimbursementsAction reimbursementsAction = new ReimbursementsAction(driver);
		
		new LoginAction(driver).logoutLogin();
		reimbursementsAction.navigateToReimbursementPage();
		reimbursementsAction.selectValues();
		reimbursementsAction.selectDates();
		reimbursementsAction.selectCompany();
		reimbursementsAction.clickSearch();
		reimbursementsAction.expenseReimbursementReport();
		driver.navigate().refresh();
	}
	
	@Test(priority = 1)
	public void verifyReimbursementReportWithClient() {
		test = getTest("TC_Expense_Reimbursements");
		ReimbursementsAction reimbursementsAction = new ReimbursementsAction(driver);
		new LoginAction(driver).logoutLogin();
		reimbursementsAction.navigateToReimbursementPage();
		reimbursementsAction.selectValues();
		reimbursementsAction.selectDates();
		reimbursementsAction.selectClient();
		reimbursementsAction.clickSearch();
		reimbursementsAction.expenseReimbursementReport();
	}
}
