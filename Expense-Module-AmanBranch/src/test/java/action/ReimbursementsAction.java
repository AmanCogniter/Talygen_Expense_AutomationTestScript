package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ReimbursementsPage;
import utils.WebBasePage;

public class ReimbursementsAction extends WebBasePage {

	WebDriver driver;
	ReimbursementsPage reimbursementsPage;

	public ReimbursementsAction(WebDriver driver) {
		super(driver, "Reimbursements");
		this.reimbursementsPage = new ReimbursementsPage(driver);
		this.driver = driver;
	}

	public void navigateToReimbursementPage() {
		reimbursementsPage.clickFullMenu();
		reimbursementsPage.clickExpenseSideMenu();
		reimbursementsPage.clickExpenseReport();
		reimbursementsPage.clickReimbursement();
	}

	public void selectValues() {
		reimbursementsPage.selectProject();
		reimbursementsPage.selectApprover();
		reimbursementsPage.selectUser();
	}

	public void selectDates() {
		reimbursementsPage.clickStartEndDate();
	}

	public void selectCompany() {
		reimbursementsPage.clickCompany();
	}
	
	public void selectClient() {
		reimbursementsPage.clickClient();
	}
	
	public void clickSearch() {
		reimbursementsPage.clickSearch();
	}

	public void expenseReimbursementReport() {
		reimbursementsPage.getTotalRecordCount();
	}

}
