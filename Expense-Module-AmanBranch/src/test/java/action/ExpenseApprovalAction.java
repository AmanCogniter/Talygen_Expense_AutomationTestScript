package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ExpenseApprovalPage;
import utils.WebBasePage;

public class ExpenseApprovalAction extends WebBasePage {

	WebDriver driver;
	ExpenseApprovalPage expenseApprovalPage;

	public ExpenseApprovalAction(WebDriver driver) {
		super(driver, "Expense Approval");
		this.expenseApprovalPage = new ExpenseApprovalPage(driver);
		this.driver = driver;
	}

	public void expenseApproval() {
		expenseApprovalPage.clickFullMenu();
		expenseApprovalPage.clickExpenseSideMenu();
		expenseApprovalPage.clickExpenseApproval();
	}

	public void selectCheckbox() {
		expenseApprovalPage.selectCheckbox();
	}

	public void clickApprove() {
		expenseApprovalPage.approveButton();
	}

	public void clickReject() {
		expenseApprovalPage.rejectButton();
	}

	public void clickViewHistory() {
		expenseApprovalPage.viewHistory();
		expenseApprovalPage.approvalHistoryPage();

	}

	public void postNewComment() {
		expenseApprovalPage.postNewComment();
	}

	public void enterComment() {
		expenseApprovalPage.enterDescription();
		expenseApprovalPage.enterTitle();
	}

	public void companyRadio() {
		expenseApprovalPage.companyRadioButton();
	}

	public void clientRadioButton() {
		expenseApprovalPage.clientRadio();
	}
	
	public void submitButton() {
		expenseApprovalPage.clickSubmit();
	}

	public void approveOkButton() {
		expenseApprovalPage.approveOkButton();

	}
	
	public void performApprovalSearch() {
		expenseApprovalPage.dateFrom();
		expenseApprovalPage.dateTo();
		expenseApprovalPage.project();
		expenseApprovalPage.clickSearch();
	}
	
	public void sendForApproval() {
		expenseApprovalPage.clickAction();
		expenseApprovalPage.clickSendForApproval();
		expenseApprovalPage.enterTitle();
		expenseApprovalPage.enterDescription();
		expenseApprovalPage.postNewComment();
	}

	
	
	
	

}
