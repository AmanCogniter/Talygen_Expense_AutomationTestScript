package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.ExpenseApprovalAction;
import action.ExpenseApprovalHistoryAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ExpenseApprovalTest extends WebTestBase {

	@Test(priority = 1)
	public void verifyExpenseApproveFunctionality() {
		test = getTest("TC_Expense_Approval");
		new LoginAction(driver).logoutLogin();
		ExpenseApprovalAction expenseApprovalAction = new ExpenseApprovalAction(driver);
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
		/*
		 * this code will create a project
		 */
		projectListingAction.navigateToProject();
		projectListingAction.addProject();
		projectListingAction.addChannel();
		projectListingAction.selectPriority();
		projectListingAction.enterPurchaseNumber();
		projectListingAction.selectLocation();
		projectListingAction.enterProjectDescription();
		projectListingAction.clickNextButton();
		/*
		 * This code will add exopense and send for approval
		 */
		AddExpenseLimitAction addExpenseLimitAction = new AddExpenseLimitAction(driver); 
		  addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategory();
		  addExpenseLimitAction.addExpenseLimit();
		manageExpenseAction.addExpense();
		manageExpenseAction.fillExpenseDetails();
		manageExpenseAction.saveAsDraft();
		manageExpenseAction.submitForApproval();
		/*
		 * This code will approve the expense
		 */
		expenseApprovalAction.expenseApproval();
		expenseApprovalAction.selectCheckbox();
		expenseApprovalAction.clickApprove();
		expenseApprovalAction.enterComment();
		expenseApprovalAction.postNewComment();
		expenseApprovalAction.companyRadio();
		expenseApprovalAction.submitButton();
		expenseApprovalAction.approveOkButton();
		expenseApprovalAction.clickViewHistory();
		
		  ExpenseApprovalHistoryAction expenseApprovalHistoryAction = new ExpenseApprovalHistoryAction(driver);
		  expenseApprovalHistoryAction.verifyApprovedStatus();
		 
	}

	@Test(priority = 2)
	public void verifyExpenseRejectFunctionality() {
		test = getTest("TC_Expense_Approval");
		new LoginAction(driver).logoutLogin();
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
		/*
		 * this code will create a project
		 */
		projectListingAction.navigateToProject();
		projectListingAction.addProject();
		projectListingAction.addChannel();
		projectListingAction.selectPriority();
		projectListingAction.enterPurchaseNumber();
		projectListingAction.selectLocation();
		projectListingAction.enterProjectDescription();
		projectListingAction.clickNextButton();
		/*
		 * This code will add exopense and send for approval
		 */
		AddExpenseLimitAction addExpenseLimitAction = new AddExpenseLimitAction(driver); 
		  addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategory();
		  addExpenseLimitAction.addExpenseLimit();
		manageExpenseAction.addExpense();
		manageExpenseAction.fillExpenseDetails();
		manageExpenseAction.saveAsDraft();
		manageExpenseAction.submitForApproval();
		/*
		 * This code is written for rejecting the expense
		 */
		ExpenseApprovalAction expenseApprovalAction = new ExpenseApprovalAction(driver);
		expenseApprovalAction.expenseApproval();
		expenseApprovalAction.selectCheckbox();
		expenseApprovalAction.clickReject();
		expenseApprovalAction.enterComment();
		expenseApprovalAction.postNewComment();
		expenseApprovalAction.companyRadio();
		expenseApprovalAction.submitButton();
		expenseApprovalAction.approveOkButton();
		expenseApprovalAction.clickViewHistory();
		ExpenseApprovalHistoryAction expenseApprovalHistoryAction = new ExpenseApprovalHistoryAction(driver);
		expenseApprovalHistoryAction.verifyRejectStatus();
	}

	/*
	 * At this time Expense Reject and Apporve by client test Script is on hold , we will work on it letter
	 */
	/*
	 * @Test(priority = 2, enabled=false) public void verifyExpenseRejectByClient()
	 * { test = getTest("TC_Expense_Approval"); new
	 * LoginAction(driver).logoutLogin(); ExpenseApprovalAction
	 * expenseApprovalAction = new ExpenseApprovalAction(driver);
	 * expenseApprovalAction.expenseApproval();
	 * expenseApprovalAction.selectCheckbox(); expenseApprovalAction.clickReject();
	 * expenseApprovalAction.enterComment(); expenseApprovalAction.postNewComment();
	 * expenseApprovalAction.clientRadioButton();
	 * expenseApprovalAction.submitButton();
	 * expenseApprovalAction.approveOkButton();
	 * expenseApprovalAction.clickViewHistory(); //ExpenseApprovalHistoryAction
	 * expenseApprovalHistoryAction = new ExpenseApprovalHistoryAction(driver);
	 * //expenseApprovalHistoryAction.verifyRejectStatus();
	 * 
	 * }
	 * 
	 * @Test(priority = 3,enabled=false) public void verifyExpenseApproveByClient()
	 * { test = getTest("TC_Expense_Approval"); new
	 * LoginAction(driver).logoutLogin(); ExpenseApprovalAction
	 * expenseApprovalAction = new ExpenseApprovalAction(driver);
	 * expenseApprovalAction.expenseApproval();
	 * expenseApprovalAction.selectCheckbox(); expenseApprovalAction.clickApprove();
	 * expenseApprovalAction.enterComment(); expenseApprovalAction.postNewComment();
	 * expenseApprovalAction.clientRadioButton();
	 * expenseApprovalAction.submitButton();
	 * expenseApprovalAction.approveOkButton();
	 * expenseApprovalAction.sendForApproval();
	 * expenseApprovalAction.clickViewHistory(); //ExpenseApprovalHistoryAction
	 * expenseApprovalHistoryAction = new ExpenseApprovalHistoryAction(driver);
	 * //expenseApprovalHistoryAction.navigateToApprovalHistoryPage();
	 * //expenseApprovalHistoryAction.verifyApprovedStatus(); }
	 */}
