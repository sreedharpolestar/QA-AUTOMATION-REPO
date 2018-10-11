package scriptResources;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Notification_resources.BaseTest;

import scriptResources.*;

public class BasePage extends BaseTest {

	public static WebDriverWait webDriverWait;
	private static WebDriver _driver = null;
	public String platformURL = getProps().getProperty("platformURL");
	private static Point locationPoint;
	private static Locatable elementLocation;
	private static Random randomNumber;

	public BasePage(WebDriver driver) {
		_driver = driver;
		// webDriverWait = new WebDriverWait(_driver,
		// Integer.parseInt(getProps().getProperty("webDriverWaitTimeout")));
		verbose("Base Page class instanciated");
	}

	public WebDriverWait getWebDriverWait() {
		return webDriverWait;
	}

	public void refreshThePage() {
		getDriver().navigate().refresh();
		verbose("Refreshed the page");
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		int numberOfElements = getElements(locator).size();

		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(getDriver()).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		if (numberOfElements == 1) {
			for (int i = 0; i < 3; i++) {

				element = getDriver().findElement(locator);

			}
		} else if (numberOfElements == 0) {

			error("Element cannot be located on the page. Locator used '" + locator.toString()
					+ "'.Number of elements found..." + numberOfElements);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			fwait.until(ExpectedConditions.elementToBeClickable(locator));
			element = getDriver().findElement(locator);

		} else {
			error("There are more than one elements on the page. Locator used '" + locator.toString()
					+ "'.\n Number of elements found..." + numberOfElements);
			element = getDriver().findElement(locator);
		}

		/*
		 * int count = 0; boolean unfound = true; WebElement element = null;
		 * 
		 * while (unfound && count < 50) {
		 * 
		 * count += 1;
		 * 
		 * try {
		 * 
		 * element = getDriver().findElement(locator); unfound = false;
		 * 
		 * } catch (org.openqa.selenium.StaleElementReferenceException e) {
		 * 
		 * verbose("Stale element exception in finding element " +
		 * locator.toString()); verbose(e.getMessage());
		 * 
		 * } catch (NoSuchElementException nse) {
		 * 
		 * verbose("NoSuchElementException for element " + locator.toString());
		 * verbose(nse.getMessage());
		 * 
		 * } catch (Exception e) {
		 * 
		 * verbose(e.getMessage());
		 * 
		 * } }
		 */
		return element;

	}

	public Boolean isDataRendered(By locator) {
		Boolean boo = false;

		if (getElement(locator).isDisplayed() == true && getElement(locator).getText().isEmpty() == false) {
			verbose(" Item displayed and the data is rendered, .. " + getElement(locator).getText());
			boo = true;

		}
		return boo;
	}

	public List<WebElement> getElements(By locator) {

		List<WebElement> elements = getDriver().findElements(locator);
		return elements;
	}

	public void clickOnIt(By locator) {
		waitExplicitly(2);
		getElement(locator).click();
	}

	public void sendKeysEffectively(By locator, String value) {
		waitExplicitly(1);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		//
		// Actions action = new Actions(getDriver());
		// action.sendKeys(Keys.TAB).build().perform();
		//
		// if zoneshape is circular then the appendString will be ".00000"
		// if zoneshape is Polygon then different
		// for rectangle shapes different
		// to be implemented later
		verbose("entered " + value + " in the element located " + locator);

		// String appendString = null;
		//
		// if (getElement(locator).getText().toString() == (value+appendString))
		// {
		//
		// verbose("entered "+ value + " in the element located "+ locator);
		// return true;
		//
		// } else {
		//
		// verbose("entered "+ value + " in the element located "+ locator+".
		// And checking if that value still there.."+false);
		// verbose("found "+getElement(locator).getText().toString());
		// return false;
		//
		// }
	}

	public int getRandomNumber(int bound) {
		randomNumber = new Random();
		return randomNumber.nextInt(bound);
	}

	public Boolean isElementPresentAndEnabled(By locator) {
		try {
			waitForVisibility(getElement(locator));
			return getElement(locator).isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public Boolean isElementPresentAndDisplayed(By locator) {
		try {
			waitForVisibility(getElement(locator));
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public Boolean isElementPresentAndSelected(By locator) {
		try {
			waitForVisibility(getElement(locator));
			return getElement(locator).isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public Boolean isElementPresent(By locator) {
		try {
			getDriver().findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForVisibility(WebElement element) throws Error {
		getWebDriverWait().until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForClickableElement(By menuItemTracking) throws Error {
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getElement(menuItemTracking)));
	}

	public Point findElementLocation(WebElement webElement) {

		elementLocation = (Locatable) webElement;
		locationPoint = elementLocation.getCoordinates().onPage();

		return locationPoint;
	}

	public void actionZoomIn(Boolean action) {

		int i = 0;
		while (i < 2) {

			if (action == true) {

				getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
				verbose("zoomen in by ' ctrl+ add ' keys");

			} else {

				getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				verbose("zoomen in by ' ctrl+ substract ' keys");

			}

			i++;
		}
	}

	public Boolean isOneEqualOrContainTwo(String one, String two) {

		if (one.contains(two)) {
			return true;
		} else {
			return false;
		}
	}

	public void actionZoomIn(By locator) {

		(new Actions(getDriver())).doubleClick(getElement(locator));
		verbose("actioned a double click...");

	}

	public void hoverOver(By locator) {

		(new Actions(getDriver())).moveToElement(getElement(locator));
		verbose("hovered over to the element ...");

	}

	public Point getTheCoordinatesOfElement(By locator) {

		Point point = findElementLocation(getElement(locator));

		return point;
	}

}
