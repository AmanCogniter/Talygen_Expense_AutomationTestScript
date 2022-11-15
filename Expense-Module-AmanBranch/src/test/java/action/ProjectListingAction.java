package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ProjectListingPage;
import utils.WebBasePage;

public class ProjectListingAction extends WebBasePage {
	WebDriver driver;
	ProjectListingPage projectListingPage;

	public ProjectListingAction(WebDriver driver) {
		super(driver, "Project Listing Page");
		this.projectListingPage = new ProjectListingPage(driver);
		this.driver = driver;
	}

	// navigate To Projecta
	public void navigateToProject() {

		projectListingPage.clickFullMenu();
		projectListingPage.clickProjectSideMenu();
		projectListingPage.clickProject();

	}

	// Add project
	public void addProject() {
		//projectListingPage.closeTourGuidePopup();
		projectListingPage.clickAddProject();
		//projectListingPage.closedefaultTemplateTourGuidePopup();
		projectListingPage.selectDefaultTemplate();
		projectListingPage.clickNextButton();
		projectListingPage.enterProjectName();
	}

	// Add Channel
	public void addChannel() {

		projectListingPage.addChannel();
		projectListingPage.enterChannelName();
		projectListingPage.enterChannelDescription();
		projectListingPage.SaveButton();
	}

	// Select priority
	public void selectPriority() {
		projectListingPage.selectPriority();
	}

	// enter Purchase Number and Estimated Cost
	public void enterPurchaseNumber() {
		projectListingPage.enterEstimatedCost();
		projectListingPage.enterPurchaseNumber();

	}

	// select Location
	public void selectLocation() {
		projectListingPage.selectLocation();
	}

	// select Location
	public void enterProjectDescription() {

		projectListingPage.enterProjectDescription();
	}

	// click Next Button
	public void clickNextButton() {
		projectListingPage.selectCurrency();
		projectListingPage.sliderYesButton();
		projectListingPage.enterProjectHours();
		projectListingPage.enterProjectRate();
		projectListingPage.nextButton();
		//projectListingPage.closeFinishedSetUpTourGuidePopup();
		projectListingPage.selectCheckbox();
		projectListingPage.clickSave();
		projectListingPage.clickAutomationProject();
		projectListingPage.expenseLimit();
		projectListingPage.addExpenseLimit();
		projectListingPage.expenseAllowedPerDay();
		projectListingPage.navigateBack();

	}

	// click task Button
	public void clickTask() {
//		projectListingPage.clickAutomationProject();
//		projectListingPage.clickTask();
	}
	
}