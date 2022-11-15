package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatement {

	WebDriver driver;

	public WaitStatement(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElementVisibility(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println();
			return null;
		}
	}

	public boolean findElementInVisibility(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println();
			return true;
		}
	}

	public WebElement findElementClickable(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			wait.until((ExpectedCondition<Boolean>) _webDriver -> (_webDriver.findElement(by) != null));
		} catch (Exception e) {
			System.out.println();
			return null;
		}
		return driver.findElement(by);
	}

	public WebElement findElementPresence(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);

		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			wait.until((ExpectedCondition<Boolean>) _webDriver -> (_webDriver.findElement(by) != null));
		} catch (Exception e) {
			System.out.println();
			return null;
		}
		return driver.findElement(by);

	}

	public WebElement findElementsVisibility(final By by) {

		List<WebElement> webElements = driver.findElements(by);
		for (WebElement ele : webElements) {
			try {
				if (ele.isDisplayed()) {
					return ele;
				}
			} catch (Exception e) {
				System.out.println();
				return null;
			}
		}
		return null;
	}

	public WebElement findElementsPresence(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		List<WebElement> webElements = driver.findElements(by);
		for (WebElement ele : webElements) {
			try {
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
				wait.until((ExpectedCondition<Boolean>) _webDriver -> (ele != null));
				return ele;
			} catch (Exception e) {
				System.out.println();
				return null;
			}
		}
		return driver.findElement(by);
	}

	public WebElement waitForInVisibilityOfElement(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
		} catch (Exception e) {
			System.out.println();
			return null;
		}
		return driver.findElement(by);
	}

	public WebElement waitForVisibilityOfElement(final By by, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (Exception e) {
			System.out.println();
			return null;
		}
		return driver.findElement(by);
	}

	// Creating a custom function
	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='2px solid red'", element);

	}

	// Creating a custom function
	public void mouseHover() {
		Actions hover = new Actions(driver);

		WebElement Elem_to_hover = driver
				.findElement(By.xpath("//table[@id='tblticketlistigdata']//tbody//tr/td[5]//span"));

		hover.moveToElement(Elem_to_hover);
		hover.build();
		hover.perform();

	}
}
