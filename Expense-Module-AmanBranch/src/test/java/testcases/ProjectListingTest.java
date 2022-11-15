package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.LoginAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class ProjectListingTest extends WebTestBase {

	/*
	 * @Test(priority = 0) public void addProjectWithSubmit() { test =
	 * getTest("TC_Project_Listing"); new LoginAction(driver).logoutLogin();
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
	 * getTest("TC_Project_Listing"); new LoginAction(driver).logoutLogin();
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
	 * getTest("TC_Project_Listing"); new LoginAction(driver).logoutLogin();
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
	 * getTest("TC_Project_Listing"); new LoginAction(driver).logoutLogin();
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

	// ----------------------------------------------------------------------------------------------------------------------------------------------------

	@Test(priority = 0)
	public void addProjectWithDefaultTemplate() {
		test = getTest("TC_Project_Listing");
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
		 driver.close();
	}
}
