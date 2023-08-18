package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.ExpenseApprovalAction;
import action.ExpenseApprovalHistoryAction;
import action.ExpenseListingAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ExpenseListingTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyFileAndButtonsFunctionality() {
		test = getTest("TC_Expense_Listing");
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);

		new LoginAction(driver).logoutLogin();
		ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		expenseListingAction.navigateToExpenses();
		// expenseListingAction.performSearch();
		// expenseListingAction.verifyExpenseSearch();
		// expenseListingAction.verifyPendingStatus();
		expenseListingAction.clickAllCheckbox();
		expenseListingAction.checkButtonsVisibility();
		expenseListingAction.clickActionButton();
		expenseListingAction.attachmentTab();
		expenseListingAction.verifyDownloadFile();
	}

	@Test(priority = 1)
	public void verifySendForApprovalFunctionality() {
		test = getTest("TC_Expense_Listing");
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
		 * This code will add expense and Save as draft
		 */
		
		  AddExpenseLimitAction addExpenseLimitAction = new
		  AddExpenseLimitAction(driver); addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategory();
		  addExpenseLimitAction.addExpenseLimit(); manageExpenseAction.addExpense();
		  manageExpenseAction.fillExpenseDetails(); manageExpenseAction.saveAsDraft();
		 
		new LoginAction(driver).logoutLogin();
		ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		expenseListingAction.navigateToExpenses();
		expenseListingAction.performSearchForSendForApproval();

		expenseListingAction.verifyDraftStatus();
		expenseListingAction.verifySendForApproval();
	}

	@Test(priority = 2)
	public void verifyEditExpenseFunctionality() {
		test = getTest("TC_Expense_Listing");
		new LoginAction(driver).logoutLogin();
		ExpenseApprovalAction expenseApprovalAction = new ExpenseApprovalAction(driver);
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
		/*
		 * this code will create a project
		 */
		   projectListingAction.navigateToProject();
		
		  projectListingAction.addProjectForEditExpense(); 
		  projectListingAction.addChannelForEditExpense();
		  projectListingAction.selectPriority();
		  projectListingAction.enterPurchaseNumber();
		  projectListingAction.selectLocation();
		  projectListingAction.enterProjectDescription();
		  projectListingAction.clickNextButton();
		  
			/* This code will add expense and Save as draft */
		  
		  AddExpenseLimitAction addExpenseLimitAction = new
		  AddExpenseLimitAction(driver); addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategoryForEditExpense();
		  addExpenseLimitAction.addExpenseLimit(); 
		  manageExpenseAction.addExpense();
		  manageExpenseAction.fillExpenseDetailsForEditExpense(); 
		  manageExpenseAction.saveAsDraft();
		 
		//new LoginAction(driver).logoutLogin();
		ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		
		expenseListingAction.verifyDraftStatus();
		expenseListingAction.editExpense();
	}

	@Test(priority = 3)
	public void verifySearchFunctionality() {
		test = getTest("TC_Expense_Listing");
		new LoginAction(driver).logoutLogin();
		ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		expenseListingAction.navigateToExpenses();
		expenseListingAction.performSearch();
		expenseListingAction.verifyExpenseSearch();
	}
}
