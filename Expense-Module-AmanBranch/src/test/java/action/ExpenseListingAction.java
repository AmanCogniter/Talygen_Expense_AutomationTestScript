package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ExpenseListingPageObject;
import utils.WebBasePage;

public class ExpenseListingAction extends WebBasePage {

	WebDriver driver;

	ExpenseListingPageObject expenseListingPage;

	public ExpenseListingAction(WebDriver driver) {
		super(driver, "Expense Listing Page");
		this.expenseListingPage = new ExpenseListingPageObject(driver);

		this.driver = driver;
	}

	// navigate Expenses
	public void navigateToExpenses() {

		expenseListingPage.clickFullMenu();
		expenseListingPage.clickExpenseSideMenu();
		//expenseListingPage.clickExpense();
		expenseListingPage.clickExpenseListing();
	}

	// perform search
	public void performSearch() {
		expenseListingPage.clickExpandAll();
		expenseListingPage.clickProject();
		//expenseListingPage.clickStatus();
		expenseListingPage.clickDateFrom();
		expenseListingPage.clickDateTo();
		expenseListingPage.clickSearch();
	}
	// perform search for Send For Approval
		public void performSearchForSendForApproval() {
			expenseListingPage.clickExpandAll();
			expenseListingPage.clickProject();
			
			expenseListingPage.clickSearch();
		}

	public void verifyDraftStatus() {
		expenseListingPage.getTextOfDraftStatus();
	}

	public void verifyPendingStatus() {
		expenseListingPage.getTextOfPendingStatus();
	}

	public void clickAllCheckbox() {
		expenseListingPage.clickAllCheckbox();
	}

	public void checkButtonsVisibility() {
		expenseListingPage.checkButtonsVisibility();
	}

	public void removeExpense() {
		expenseListingPage.selectFirstCheckbox();
		expenseListingPage.removeExpense();
		expenseListingPage.okButton();
	}

	public void clickActionButton() {
		staticWait(3000);
		expenseListingPage.clickActionButton();
	}

	public void attachmentTab() {
		expenseListingPage.attachmentTab();
		expenseListingPage.getAttachmentText();
	}

	public void verifyDownloadFile() {
		expenseListingPage.clickDownloadFile();
		expenseListingPage.verifyFileUpload();
	}

	public void verifySendForApproval() {
		clickActionButton();
		expenseListingPage.clickSendForApproval();
		expenseListingPage.okButton();
		performSearchForSendForApproval();
		verifyPendingStatus();
	}

	public void editExpense() {
		performSearchForSendForApproval();
		clickActionButton();
		expenseListingPage.editExpense();
	}

	public void verifyExpenseSearch() {
		expenseListingPage.verifyExpenseSearch();
	}

}