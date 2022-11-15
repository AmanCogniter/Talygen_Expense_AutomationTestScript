package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddExpenseLimitAction;
import action.LoginAction;
import action.ProjectListingAction;
import utils.WebTestBase;

public class AddExpenseLimitTest extends WebTestBase {
	static String Screenname = "<b>Expense</b>";
	@Test(priority = 0)
	public void addExpenseLimit() {
		test = getTest(Screenname +": TC_Expense_ExpenseLimit");
		AddExpenseLimitAction addExpenseLimitAction = new AddExpenseLimitAction(driver);
		ProjectListingAction projectListingAction = new ProjectListingAction(driver);
		new LoginAction(driver).logoutLogin();
		projectListingAction.navigateToProject();
		projectListingAction.addProject();
		projectListingAction.addChannel();
		projectListingAction.selectPriority();
		projectListingAction.enterPurchaseNumber();
		projectListingAction.selectLocation();
		projectListingAction.enterProjectDescription();
		projectListingAction.clickNextButton();
		  addExpenseLimitAction.addExpLimit();
		  addExpenseLimitAction.addExpenseCategory();
		  addExpenseLimitAction.addExpenseLimit();
		  addExpenseLimitAction.expenseLimitSuccessMsg();
		 
	}

}
