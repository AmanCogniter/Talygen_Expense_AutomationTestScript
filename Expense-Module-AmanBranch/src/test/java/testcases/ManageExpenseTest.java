package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.ExpenseListingAction;
import action.LoginAction;
import action.ManageExpenseAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ManageExpenseTest extends WebTestBase {

	/*
	 * @Test(priority = 0) public void addProjectWithSubmit() { test =
	 * getTest("TC_Add_Project"); new LoginAction(driver).logoutLogin();
	 * ProjectListingAction projectListingAction = new ProjectListingAction(driver);
	 * projectListingAction.navigateToProject(); projectListingAction.addProject();
	 * projectListingAction.addChannel(); projectListingAction.selectPriority();
	 * projectListingAction.enterPurchaseNumber();
	 * projectListingAction.selectLocation();
	 * projectListingAction.enterProjectDescription();
	 * projectListingAction.clickNextButton(); AddExpenseLimitAction
	 * addExpenseLimitAction = new AddExpenseLimitAction(driver);
	 * addExpenseLimitAction.addExpLimit();
	 * addExpenseLimitAction.addExpenseCategory();
	 * addExpenseLimitAction.addExpenseLimit(); //
	 * addExpenseLimitAction.expenseLimitSuccessMsg(); ManageExpenseAction
	 * manageExpenseAction = new ManageExpenseAction(driver);
	 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.submitForApproval(); //
	 * manageExpenseAction.expenseSuccessMessage(); ExpenseListingAction
	 * expenseListingAction = new ExpenseListingAction(driver);
	 * expenseListingAction.verifyPendingStatus();
	 * expenseListingAction.clickAllCheckbox();
	 * expenseListingAction.checkButtonsVisibility();
	 * expenseListingAction.clickActionButton();
	 * expenseListingAction.attachmentTab();
	 * expenseListingAction.verifyDownloadFile(); }
	 * 
	 * @Test(priority = 1) public void validateButtonVisibility() { test =
	 * getTest("TC_Add_Project"); new LoginAction(driver).logoutLogin();
	 * ProjectListingAction projectListingAction = new ProjectListingAction(driver);
	 * projectListingAction.navigateToProject(); projectListingAction.addProject();
	 * projectListingAction.addChannel(); projectListingAction.selectPriority();
	 * projectListingAction.enterPurchaseNumber();
	 * projectListingAction.selectLocation();
	 * projectListingAction.enterProjectDescription();
	 * projectListingAction.clickNextButton(); AddExpenseLimitAction
	 * addExpenseLimitAction = new AddExpenseLimitAction(driver);
	 * addExpenseLimitAction.addExpLimit();
	 * addExpenseLimitAction.addExpenseCategory();
	 * addExpenseLimitAction.addExpenseLimit(); ManageExpenseAction
	 * manageExpenseAction = new ManageExpenseAction(driver);
	 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.saveAsDraft(); ExpenseListingAction expenseListingAction
	 * = new ExpenseListingAction(driver); expenseListingAction.verifyDraftStatus();
	 * expenseListingAction.verifySendForApproval(); //
	 * expenseListingAction.removeExpense(); //
	 * manageExpenseAction.expenseSuccessMessage(); //
	 * expenseListingAction.performSeaarch(); }
	 * 
	 * @Test(priority = 2) public void verifyEditExpenseFunctionality() { test =
	 * getTest("TC_Add_Project"); new LoginAction(driver).logoutLogin();
	 * ProjectListingAction projectListingAction = new ProjectListingAction(driver);
	 * projectListingAction.navigateToProject(); projectListingAction.addProject();
	 * projectListingAction.addChannel(); projectListingAction.selectPriority();
	 * projectListingAction.enterPurchaseNumber();
	 * projectListingAction.selectLocation();
	 * projectListingAction.enterProjectDescription();
	 * projectListingAction.clickNextButton(); AddExpenseLimitAction
	 * addExpenseLimitAction = new AddExpenseLimitAction(driver);
	 * addExpenseLimitAction.addExpLimit();
	 * addExpenseLimitAction.addExpenseCategory();
	 * addExpenseLimitAction.addExpenseLimit(); ManageExpenseAction
	 * manageExpenseAction = new ManageExpenseAction(driver);
	 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.saveAsDraft(); ExpenseListingAction expenseListingAction
	 * = new ExpenseListingAction(driver); expenseListingAction.verifyDraftStatus();
	 * expenseListingAction.editExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.saveAsDraft(); //
	 * manageExpenseAction.expenseSuccessMessage(); //
	 * expenseListingAction.removeExpense(); //
	 * manageExpenseAction.expenseSuccessMessage(); //
	 * expenseListingAction.performSeaarch(); }
	 * 
	 * @Test(priority = 3) public void verifySearch() { test =
	 * getTest("TC_Add_Project"); new LoginAction(driver).logoutLogin();
	 * ProjectListingAction projectListingAction = new ProjectListingAction(driver);
	 * projectListingAction.navigateToProject(); projectListingAction.addProject();
	 * projectListingAction.addChannel(); projectListingAction.selectPriority();
	 * projectListingAction.enterPurchaseNumber();
	 * projectListingAction.selectLocation();
	 * projectListingAction.enterProjectDescription();
	 * projectListingAction.clickNextButton(); AddExpenseLimitAction
	 * addExpenseLimitAction = new AddExpenseLimitAction(driver);
	 * addExpenseLimitAction.addExpLimit();
	 * addExpenseLimitAction.addExpenseCategory();
	 * addExpenseLimitAction.addExpenseLimit(); //
	 * addExpenseLimitAction.expenseLimitSuccessMsg(); ManageExpenseAction
	 * manageExpenseAction = new ManageExpenseAction(driver);
	 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.submitForApproval(); //
	 * manageExpenseAction.expenseSuccessMessage(); ExpenseListingAction
	 * expenseListingAction = new ExpenseListingAction(driver);
	 * expenseListingAction.performSearch();
	 * expenseListingAction.verifyExpenseSearch();
	 * 
	 * }
	 */

// _______________________________________________________________________________________________________________________________________________________//	

	@Test(priority = 1)
	public void addExpenseWithSaveAsDraft() {
		test = getTest("TC_Add_Expense");
		new LoginAction(driver).logoutLogin();
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
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
		manageExpenseAction.addExpense();
		manageExpenseAction.fillExpenseDetails();
		manageExpenseAction.saveAsDraft();
		//manageExpenseAction.submitForApproval();
		//manageExpenseAction.expenseSuccessMessage();
		 ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		expenseListingAction.performSearchForSendForApproval();

		expenseListingAction.verifyDraftStatus();
	}
	
	/*
	 * @Test
	 * 
	 * public void testExpense() {
	 * 
	 * test = getTest("TC_Add_Expense"); new LoginAction(driver).logoutLogin();
	 * 
	 * ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
	 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
	 * manageExpenseAction.saveAsDraft();
	 * 
	 * 
	 * 
	 * }
	 */
	@Test(priority = 2)
	public void addExpenseWithSubmitForApproval() {
		test = getTest("TC_Add_Expense");
		new LoginAction(driver).logoutLogin();
		ManageExpenseAction manageExpenseAction = new ManageExpenseAction(driver);
		manageExpenseAction.submitForApproval();
		/*
		 * manageExpenseAction.addExpense(); manageExpenseAction.fillExpenseDetails();
		 * manageExpenseAction.saveAsDraft();
		 */
//		expenseListingAction.removeExpense();
//		manageExpenseAction.expenseSuccessMessage();
		 ExpenseListingAction expenseListingAction = new ExpenseListingAction(driver);
		expenseListingAction.performSearchForSendForApproval();
		expenseListingAction.verifyPendingStatus();
	}

}
