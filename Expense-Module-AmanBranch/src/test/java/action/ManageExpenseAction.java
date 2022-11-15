package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ManageExpensePage;
import utils.WebBasePage;

public class ManageExpenseAction extends WebBasePage {

	WebDriver driver;
	ManageExpensePage manageExpensePage;

	public ManageExpenseAction(WebDriver driver) {
		super(driver, "Add Expense Limit");
		this.manageExpensePage = new ManageExpensePage(driver);
		this.driver = driver;
	}

	// Add expense
	public void addExpense() {

		manageExpensePage.clickFullMenu();
		manageExpensePage.clickExpenseSideMenu();
		manageExpensePage.clickAddExpense();
		//manageExpensePage.closeEndTourGuide();

	}

	// expense details
	public void fillExpenseDetails() {

		manageExpensePage.enterExpenseTitle();
		manageExpensePage.enterExpenseDate();
		manageExpensePage.selectProject();
		manageExpensePage.addTripName();
		manageExpensePage.selectTrip();
		manageExpensePage.selectCategory();
		//manageExpensePage.testCategory();
		
		manageExpensePage.enterExpenseAmount();
		manageExpensePage.selectCurrency();
		manageExpensePage.expenseFileUpload();
		manageExpensePage.enterExpenseDescription();
		

	}

	// submit for approval
	public void submitForApproval() {
		manageExpensePage.clickFullMenu();
		manageExpensePage.clickExpenseSideMenu();
		manageExpensePage.clickExpense();
		//manageExpensePage.closeSearchTourGuide();
		manageExpensePage.clickOnExpenedAll();
		manageExpensePage.enterValueIntoSearchField();
		manageExpensePage.selectProjectCheckBox();
		manageExpensePage.clickOnSearchButton();
		manageExpensePage.clickOnActionButton();
		manageExpensePage.clickOnEditExpense();
		//manageExpensePage.closeEndTourGuide();
		manageExpensePage.clickSubmitForApproval();
		//manageExpensePage.closeSearchTourGuide();
	}

	// Save as draft
	public void saveAsDraft() {
		manageExpensePage.clickSaveAsDraft();
		//manageExpensePage.closeSearchTourGuide();
	}

	// expense success message
	public void expenseSuccessMessage() {
		manageExpensePage.addExpenseSuceessMessage();
	}
}