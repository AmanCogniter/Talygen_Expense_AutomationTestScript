package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ExpenseApprovalHistoryPage;
import utils.WebBasePage;

public class ExpenseApprovalHistoryAction extends WebBasePage {

	WebDriver driver;
	ExpenseApprovalHistoryPage expenseApprovalHistoryPage;

	public ExpenseApprovalHistoryAction(WebDriver driver) {
		super(driver, "Expense Approval History");
		this.expenseApprovalHistoryPage = new ExpenseApprovalHistoryPage(driver);
		this.driver = driver;
	}

	public void navigateToApprovalHistoryPage() {
		expenseApprovalHistoryPage.navigateToApprovalHistoryPage();
	}
	
	
	public void verifyApprovedStatus() {
		//expenseApprovalHistoryPage.verifyApproveStatus();
		expenseApprovalHistoryPage.verifyApprovalHistoryStatus();
	}
	
	public void verifyRejectStatus() {
	//expenseApprovalHistoryPage.verifyRejectedStatus();
		expenseApprovalHistoryPage.verifyApprovalHistoryStatus();
	}
}
